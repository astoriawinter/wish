package com.tatiana.rodionova.mvi_core

import kotlinx.coroutines.flow.Flow

interface Middleware<A : Action, S : State> {
    fun bind(actions: Flow<A>, state: Flow<S>): Flow<A>
}