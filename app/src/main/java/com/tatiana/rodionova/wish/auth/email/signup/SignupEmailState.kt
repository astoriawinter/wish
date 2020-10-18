package com.tatiana.rodionova.wish.auth.email.signup

import com.tatiana.rodionova.mvi_core.State

data class SignupEmailState(
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false
): State