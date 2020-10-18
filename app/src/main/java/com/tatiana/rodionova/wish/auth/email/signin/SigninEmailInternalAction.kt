package com.tatiana.rodionova.wish.auth.email.signin

import com.tatiana.rodionova.mvi_core.Action

sealed class SigninEmailInternalAction : Action {
    object LoginWithEmailSuccess : SigninEmailInternalAction()
    object LoginWithEmailFailure : SigninEmailInternalAction()
}
