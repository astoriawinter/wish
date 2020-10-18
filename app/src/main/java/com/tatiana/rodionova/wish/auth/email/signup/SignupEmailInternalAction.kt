package com.tatiana.rodionova.wish.auth.email.signup

import com.tatiana.rodionova.mvi_core.Action

sealed class SignupEmailInternalAction : Action {
    object SignupWithEmailSuccess : SignupEmailInternalAction()
    object SignupWithEmailFailure : SignupEmailInternalAction()
}
