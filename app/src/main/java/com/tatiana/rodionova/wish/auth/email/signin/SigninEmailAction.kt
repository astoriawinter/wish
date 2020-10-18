package com.tatiana.rodionova.wish.auth.email.signin

import com.tatiana.rodionova.mvi_core.Action

sealed class SigninEmailAction : Action {
    class LoginWithEmail(val email: String, val password: String) : SigninEmailAction()
}
