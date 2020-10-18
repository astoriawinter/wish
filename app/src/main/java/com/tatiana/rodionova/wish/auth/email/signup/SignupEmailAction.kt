package com.tatiana.rodionova.wish.auth.email.signup

import com.tatiana.rodionova.mvi_core.Action

sealed class SignupEmailAction : Action {
    class SignupWithEmail(
        val email: String,
        val password: String,
        val name: String
    ) : SignupEmailAction()
}
