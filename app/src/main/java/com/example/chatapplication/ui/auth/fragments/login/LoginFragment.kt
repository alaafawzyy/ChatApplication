package com.example.chatapplication.ui.auth.fragments.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapplication.ui.auth.activity.AuthActivity
import com.example.chatapplication.R
import com.example.chatapplication.databinding.FragmentLoginBinding
import com.example.chatapplication.ui.home.HomeActivity


class LoginFragment : Fragment() {
lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateToRegisterBtn.setOnClickListener({NavigateToRegister()})
        binding.loginBtn.setOnClickListener({NavigateToHome()})
    }

    private fun NavigateToHome() {
        if(activity==null)return
          startActivity(Intent(requireContext(),HomeActivity::class.java))
        requireActivity().finish()
    }

    private fun NavigateToRegister() {
       if(activity==null)return
        (activity as AuthActivity).navController
            .navigate(R.id.action_loginFragment_to_registerFragment)
    }

}