package com.tatiana.rodionova.wish.auth.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.MviView
import com.tatiana.rodionova.mvi_core.State
import com.tatiana.rodionova.wish.mvi.Store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AuthEmailBinder : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val store = Store<Action, AuthEmailState>(
        reducer = AuthEmailReducer(),
        initialState = AuthEmailState(),
        middlewares = listOf(AuthEmailMiddleware(auth))
    )

    init {
        store.wire(viewModelScope)
    }

    fun bind(view: MviView<Action, AuthEmailState>, uiScope: CoroutineScope) {
        store.bind(view, uiScope)
    }
}
