package com.example.projectfoodtracker.presentation.ui.fragments.authorized

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val binding by viewBinding(FragmentSignInBinding::bind)
    private val viewModel by viewModels<SignInViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.isAuthorized()){
            findNavController().navigate(R.id.clearBackStackSignIn)
        }

        binding.btnEnter.setOnClickListener{
            if (binding.etName.text.isEmpty()){
                binding.etName.error = "Cannot be blank"
            }else {
                viewModel.saveUserInfo(username = binding.etName.text.toString())
                findNavController().navigate(R.id.mainFragment)
                viewModel.authorized(boolean = true)
            }

        }
    }
}