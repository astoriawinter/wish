package com.tatiana.rodionova.mvi_core

interface Reducer<S: State, A: Action> {
    fun reduce(state: S, action: A) : S
}