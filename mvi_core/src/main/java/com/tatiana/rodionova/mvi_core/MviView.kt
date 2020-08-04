package com.tatiana.rodionova.mvi_core

import kotlinx.coroutines.flow.Flow

interface MviView<A: Action, S: State> {
    val actions: Flow<A>
    fun render(state: S)
}