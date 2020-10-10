package com.tatiana.rodionova.wish.auth.email

import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Reducer

class AuthEmailReducer : Reducer<AuthEmailState, Action> {
    override fun reduce(state: AuthEmailState, action: Action): AuthEmailState =
        when (action) {
            is AuthEmailAction.LoginWithEmail -> state.copy(isLoading = true)
            is AuthEmailInternalAction.LoginWithEmailSuccess -> state.copy(
                isLoginSuccessful = true,
                isLoading = false
            )
            is AuthEmailInternalAction.LoginWithEmailFailure -> state.copy(
                isLoginSuccessful = false,
                isLoading = false
            )
            else -> state
        }
}