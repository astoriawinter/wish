package com.tatiana.rodionova.wish.auth.selector

import com.tatiana.rodionova.mvi_core.Action

sealed class AuthSelectorAction : Action {
    object CheckUserIsLogged : AuthSelectorAction()
}
