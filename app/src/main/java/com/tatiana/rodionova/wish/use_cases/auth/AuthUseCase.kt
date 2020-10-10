package com.tatiana.rodionova.wish.use_cases.auth

interface AuthUseCase {
    fun authWithPhoneNumber(number: String)
    fun authWithEmail(email: String)
}