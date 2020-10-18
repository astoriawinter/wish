package com.tatiana.rodionova.wish.auth.selector

import com.tatiana.rodionova.mvi_core.State

data class AuthSelectorState(
    val isUserLoggedIn: Boolean = false
): State