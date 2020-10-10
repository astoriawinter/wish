package com.tatiana.rodionova.wish.auth.email

import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Middleware
import com.tatiana.rodionova.wish.mvi.withLatestFrom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class AuthEmailMiddleware(
    private val auth: FirebaseAuth
) : Middleware<Action, AuthEmailState> {
    override fun bind(actions: Flow<Action>, state: Flow<AuthEmailState>): Flow<Action> =
        actions.filterIsInstance<AuthEmailAction.LoginWithEmail>()
            .withLatestFrom(state) { action, currentState -> action to currentState }
            .map { (action, _) ->
                try {
                    val user = auth
                        .signInWithEmailAndPassword(action.email, action.password)
                        .await()
                        .user
                    if (user != null) {
                        AuthEmailInternalAction.LoginWithEmailSuccess
                    } else AuthEmailInternalAction.LoginWithEmailFailure
                } catch (e: Exception) {
                    AuthEmailInternalAction.LoginWithEmailFailure
                }
            }
}