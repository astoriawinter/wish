package com.tatiana.rodionova.wish.auth.email.signup

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Middleware
import com.tatiana.rodionova.wish.mvi.withLatestFrom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class SignupEmailMiddleware(
    private val auth: FirebaseAuth
) : Middleware<Action, SignupEmailState> {
    override fun bind(actions: Flow<Action>, state: Flow<SignupEmailState>): Flow<Action> =
        actions.filterIsInstance<SignupEmailAction.SignupWithEmail>()
            .withLatestFrom(state) { action, currentState -> action to currentState }
            .map { (action, _) ->
                try {
                    val user = auth
                        .createUserWithEmailAndPassword(action.email, action.password)
                        .await()
                        .user
                    user
                        ?.updateProfile(
                            UserProfileChangeRequest
                                .Builder()
                                .setDisplayName(action.name)
                                .build()
                        )?.await()
                    if (user != null) {
                        SignupEmailInternalAction.SignupWithEmailSuccess
                    } else SignupEmailInternalAction.SignupWithEmailFailure
                } catch (e: Exception) {
                    SignupEmailInternalAction.SignupWithEmailFailure
                }
            }
}
