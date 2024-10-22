package com.example.chatapplication.ui.auth.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.chatapplication.R
import com.example.chatapplication.base.baseFragment
import com.example.chatapplication.database.User
import com.example.chatapplication.databinding.FragmentRegisterBinding
import com.example.chatapplication.ui.home.HomeFragment

class RegisterFragment : baseFragment<FragmentRegisterBinding,RegisterViewModel>() {


    override fun initViewModel(): RegisterViewModel {
      return ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun getLatoutId(): Int {
      return R.layout.fragment_register
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveDataa()
        initView()
    }

     fun observeLiveDataa() {
        viewModel.events.observe(viewLifecycleOwner,::onEventChange)
    }
    private fun onEventChange(event: RegisterViewEvents?){
          when(event){
             is RegisterViewEvents.NavigateToHome->{
                  navigateToHome(event.user)
            }

              null -> TODO()
          }

    }

    private fun navigateToHome(user: User) {
        val action=RegisterFragmentDirections.actionRegisterFragmentToHomeFragment2(user)
        findNavController().navigate(action)
    }

    private fun initView() {
        binding.vm=viewModel
        binding.lifecycleOwner=this
    }

}