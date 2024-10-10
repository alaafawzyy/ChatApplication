package com.example.chatapplication.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityHomeBinding
import com.example.chatapplication.ui.home.adapter.RoomViewPagerAdapter
import com.example.chatapplication.ui.roomdetails.RoomDetailsActivity

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addRoomBtn.setOnClickListener({NavigateToRoomDetails()})
       initRoomViewPadger()
    }

    private fun NavigateToRoomDetails() {
        startActivity(Intent(this,RoomDetailsActivity::class.java))
    }

    private fun initRoomViewPadger() {
      val adapter=RoomViewPagerAdapter(supportFragmentManager)
        binding.pager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }
}