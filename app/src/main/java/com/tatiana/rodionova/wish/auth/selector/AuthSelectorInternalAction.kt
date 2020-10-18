package com.tatiana.rodionova.wish.auth.selector

import com.tatiana.rodionova.mvi_core.Action

sealed class AuthSelectorInternalAction : Action {
    object UserIsLoggedIn : AuthSelectorInternalAction()
    object UserIsNotLoggedIn : AuthSelectorInternalAction()
}
