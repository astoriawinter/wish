package com.tatiana.rodionova.wish.auth.email.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.MviView
import com.tatiana.rodionova.wish.mvi.Store
import kotlinx.coroutines.CoroutineScope

class SigninEmailBinder : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val store = Store<Action, SigninEmailState>(
        reducer = SigninEmailReducer(),
        initialState = SigninEmailState(),
        middlewares = listOf(SigninEmailMiddleware(auth))
    )

    init {
        store.wire(viewModelScope)
    }

    fun bind(view: MviView<Action, SigninEmailState>, uiScope: CoroutineScope) {
        store.bind(view, uiScope)
    }
}
