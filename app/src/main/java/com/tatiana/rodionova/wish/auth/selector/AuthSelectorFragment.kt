package com.tatiana.rodionova.wish.auth.selector

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.MviView
import com.tatiana.rodionova.wish.R
import kotlinx.android.synthetic.main.fragment_auth_selection.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthSelectorFragment : Fragment(R.layout.fragment_auth_selection),
    MviView<Action, AuthSelectorState> {

    override val actions: Flow<AuthSelectorAction>
        get() = flow { emit(AuthSelectorAction.CheckUserIsLogged) }

    private val binder: AuthSelectorBinder by viewModels()

    override fun render(state: AuthSelectorState) {
        val destination = if (state.isUserLoggedIn) {
            R.id.FirstFragment
        } else R.id.authSelectorFragment

        val options = NavOptions.Builder()
            .setPopUpTo(R.id.authSelectorFragment, true)
            .build()
        findNavController().navigate(destination, null, options)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authEmail.setOnClickListener {
            findNavController().navigate(R.id.action_authSelectorFragment_to_authEmailFragment)
        }
        registerEmail.setOnClickListener {
            findNavController().navigate(R.id.action_authSelectorFragment_to_signupEmailFragment)
        }
        authPhone.setOnClickListener {
            //TODO
        }

        binder.bind(this, lifecycleScope)
    }
}