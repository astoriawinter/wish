package com.tatiana.rodionova.wish.auth.email

import com.tatiana.rodionova.mvi_core.State

data class AuthEmailState(
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false
): State