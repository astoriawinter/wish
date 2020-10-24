package com.tatiana.rodionova.wish.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val authModule = module {
    single { FirebaseAuth.getInstance() }
}