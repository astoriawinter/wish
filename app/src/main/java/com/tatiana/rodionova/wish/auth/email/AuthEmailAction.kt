package com.tatiana.rodionova.wish.auth.email

import com.tatiana.rodionova.mvi_core.Action

sealed class AuthEmailAction : Action {
    class LoginWithEmail(val email: String, val password: String) : AuthEmailAction()
}
