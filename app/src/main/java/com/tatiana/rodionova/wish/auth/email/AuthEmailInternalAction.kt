package com.tatiana.rodionova.wish.auth.email

import com.tatiana.rodionova.mvi_core.Action

sealed class AuthEmailInternalAction : Action {
    object LoginWithEmailSuccess : AuthEmailInternalAction()
    object LoginWithEmailFailure : AuthEmailInternalAction()
}
