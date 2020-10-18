package com.tatiana.rodionova.wish.auth.email.signin

import com.tatiana.rodionova.mvi_core.State

data class SigninEmailState(
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false
): State