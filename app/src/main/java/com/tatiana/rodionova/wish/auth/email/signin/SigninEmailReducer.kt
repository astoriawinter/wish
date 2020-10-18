package com.tatiana.rodionova.wish.auth.email.signin

import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Reducer

class SigninEmailReducer : Reducer<SigninEmailState, Action> {
    override fun reduce(state: SigninEmailState, action: Action): SigninEmailState =
        when (action) {
            is SigninEmailAction.LoginWithEmail -> state.copy(isLoading = true)
            is SigninEmailInternalAction.LoginWithEmailSuccess -> state.copy(
                isLoginSuccessful = true,
                isLoading = false
            )
            is SigninEmailInternalAction.LoginWithEmailFailure -> state.copy(
                isLoginSuccessful = false,
                isLoading = false
            )
            else -> state
        }
}