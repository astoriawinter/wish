package com.tatiana.rodionova.wish.auth.selector

import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Middleware
import com.tatiana.rodionova.wish.mvi.withLatestFrom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

class AuthSelectorMiddleware(
    private val auth: FirebaseAuth
) : Middleware<Action, AuthSelectorState> {
    override fun bind(actions: Flow<Action>, state: Flow<AuthSelectorState>): Flow<Action> =
        actions.filterIsInstance<AuthSelectorAction.CheckUserIsLogged>()
            .withLatestFrom(state) { action, currentState -> action to currentState }
            .map { (action, _) ->
                if (auth.currentUser != null) {
                    AuthSelectorInternalAction.UserIsLoggedIn
                } else AuthSelectorInternalAction.UserIsNotLoggedIn
            }
}