package com.example.chatapplication.ui.roomdetails

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatapplication.R
import com.example.chatapplication.ui.chat.ChatActivity
import com.example.chatapplication.databinding.ActivityRoomDetailsBinding

class RoomDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.joinBtn.setOnClickListener({ NavigateToChatActivity() })
    }


    private fun NavigateToChatActivity() {
       startActivity(Intent(this, ChatActivity::class.java))
        finish()
    }
}