package com.example.chatapplication.ui.home.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityAuthBinding

class HomeActivty : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
     lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavComponent()
    }

   fun initNavComponent(){
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.auth_nav_host_fragment) as NavHostFragment
       navController=navHostFragment.navController
    }
}