package com.tatiana.rodionova.wish.auth.selector

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tatiana.rodionova.wish.R
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthSelectorFragment : Fragment(R.layout.fragment_auth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authEmail.setOnClickListener {
            findNavController().navigate(R.id.action_authSelectorFragment_to_authEmailFragment)
        }
        authPhone.setOnClickListener {
            //TODO
        }
    }
}