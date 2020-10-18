package com.tatiana.rodionova.wish.auth.email.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.MviView
import com.tatiana.rodionova.wish.mvi.Store
import kotlinx.coroutines.CoroutineScope

class SignupEmailBinder : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val store = Store<Action, SignupEmailState>(
        reducer = SignupEmailReducer(),
        initialState = SignupEmailState(),
        middlewares = listOf(SignupEmailMiddleware(auth))
    )

    init {
        store.wire(viewModelScope)
    }

    fun bind(view: MviView<Action, SignupEmailState>, uiScope: CoroutineScope) {
        store.bind(view, uiScope)
    }
}
