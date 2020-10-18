package com.tatiana.rodionova.wish.auth.email.signup

import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Reducer

class SignupEmailReducer : Reducer<SignupEmailState, Action> {
    override fun reduce(state: SignupEmailState, action: Action): SignupEmailState =
        when (action) {
            is SignupEmailAction.SignupWithEmail -> state.copy(isLoading = true)
            is SignupEmailInternalAction.SignupWithEmailSuccess -> state.copy(
                isLoginSuccessful = true,
                isLoading = false
            )
            is SignupEmailInternalAction.SignupWithEmailFailure -> state.copy(
                isLoginSuccessful = false,
                isLoading = false
            )
            else -> state
        }
}