package com.tatiana.rodionova.wish.auth.email.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tatiana.rodionova.mvi_core.Action
import com.tatiana.rodionova.mvi_core.MviView
import com.tatiana.rodionova.wish.R
import com.tatiana.rodionova.wish.mvi.clicks
import kotlinx.android.synthetic.main.fragment_auth_signin_email.*
import kotlinx.android.synthetic.main.fragment_auth_signin_email.emailText
import kotlinx.android.synthetic.main.fragment_auth_signin_email.login
import kotlinx.android.synthetic.main.fragment_auth_signin_email.passwordText
import kotlinx.android.synthetic.main.fragment_auth_signup_email.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.map

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SignupEmailFragment : Fragment(R.layout.fragment_auth_signup_email), MviView<Action, SignupEmailState> {

    private val binder: SignupEmailBinder by viewModels()
    private val _actions by lazy {
        val email = login.clicks().map {
            SignupEmailAction.SignupWithEmail(
                emailText.text.toString(),
                passwordText.text.toString(),
                nameText.text.toString()
            )
        }

        listOf(email).asFlow().flattenMerge()
    }

    override val actions: Flow<Action>
        get() = _actions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.bind(this, lifecycleScope)
    }

    override fun render(state: SignupEmailState) {
        with(state) {
            if (isLoginSuccessful) {
                findNavController().navigate(R.id.action_signupEmailFragment_to_FirstFragment)
            }
        }
    }
}
