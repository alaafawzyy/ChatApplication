package com.example.chatapplication.ui.auth.fragments.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.chatapplication.ui.home.activity.HomeActivty
import com.example.chatapplication.R
import com.example.chatapplication.base.baseFragment
import com.example.chatapplication.database.User
import com.example.chatapplication.databinding.FragmentLoginBinding
import com.example.chatapplication.ui.home.HomeFragment


class LoginFragment : baseFragment<FragmentLoginBinding,LoginViewModel>(){

    override fun initViewModel(): LoginViewModel {
         return ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun getLatoutId(): Int {
        return R.layout.fragment_login
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        observeLiveDataa()
       // binding.navigateToRegisterBtn.setOnClickListener({NavigateToRegister()})
    }

       fun observeLiveDataa() {
        viewModel.events.observe(viewLifecycleOwner){
            when(it){
                is LoginViewEvent.NavigateToRegister ->{
                    NavigateToRegister()
                }
                is LoginViewEvent.NavigateToHomme ->{
                    NavigateToHome(it.user)
                }
            }
        }
    }

    private fun initViews() {
        binding.vm= viewModel
        binding.lifecycleOwner=this
    }

    private fun NavigateToHome(user: User) {
        val action=LoginFragmentDirections.actionLoginFragmentToHomeFragment2(user)
        findNavController().navigate(action)
    }

    private fun NavigateToRegister() {

       findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

}