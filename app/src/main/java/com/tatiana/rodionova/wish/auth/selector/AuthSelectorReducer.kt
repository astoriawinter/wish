package com.tatiana.rodionova.wish.auth.selector

import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.Reducer

class AuthSelectorReducer : Reducer<AuthSelectorState, Action> {
    override fun reduce(state: AuthSelectorState, action: Action): AuthSelectorState =
        when (action) {
            is AuthSelectorAction.CheckUserIsLogged -> state.copy()
            is AuthSelectorInternalAction.UserIsLoggedIn -> state.copy(
                isUserLoggedIn = true
            )
            is AuthSelectorInternalAction.UserIsNotLoggedIn -> state.copy(
                isUserLoggedIn = false
            )
            else -> state
        }
}