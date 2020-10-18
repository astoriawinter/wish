package com.tatiana.rodionova.wish.auth.email.signin

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Middleware
import com.tatiana.rodionova.wish.mvi.withLatestFrom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class SigninEmailMiddleware(
    private val auth: FirebaseAuth
) : Middleware<Action, SigninEmailState> {
    override fun bind(actions: Flow<Action>, state: Flow<SigninEmailState>): Flow<Action> =
        actions.filterIsInstance<SigninEmailAction.LoginWithEmail>()
            .withLatestFrom(state) { action, currentState -> action to currentState }
            .map { (action, _) ->
                try {
                    val user = auth
                        .signInWithEmailAndPassword(action.email, action.password)
                        .await()
                        .user
                    if (user != null) {
                        SigninEmailInternalAction.LoginWithEmailSuccess
                    } else SigninEmailInternalAction.LoginWithEmailFailure
                } catch (e: Exception) {
                    SigninEmailInternalAction.LoginWithEmailFailure
                }
            }
}