package com.tatiana.rodionova.wish.mvi

import com.tatiana.rodionova.mvi_core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.*

class Store<A : Action, S : State>(
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<A, S>>,
    initialState: S
) {
    private val stateRelay = MutableStateFlow(initialState)
    private val actionsRelay = BroadcastChannel<A>(1)
    private val actionsFlow get() = actionsRelay.asFlow()

    fun wire(scope: CoroutineScope) {
        actionsFlow
            .withLatestFrom(stateRelay) { action, state ->
                reducer.reduce(state, action)
            }
            .distinctUntilChanged()
            .onEach { state ->
                stateRelay.value = state
            }
            .launchIn(scope)

        middlewares
            .map { it.bind(actionsFlow, stateRelay) }
            .asFlow()
            .flattenMerge(middlewares.size)
            .onEach { action ->
                actionsRelay.offer(action)
            }
            .launchIn(scope)
    }

    fun bind(view: MviView<A, S>, uiScope: CoroutineScope) {
        stateRelay
            .onEach { state ->
                view.render(state)
            }
            .launchIn(uiScope)

        view.actions
            .onEach { action ->
                actionsRelay.offer(action)
            }
            .launchIn(uiScope)
    }
}
