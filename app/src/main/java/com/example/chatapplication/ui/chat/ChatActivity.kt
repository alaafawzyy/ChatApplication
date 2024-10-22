package com.example.chatapplication.ui.chat

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatapplication.R
import com.example.chatapplication.ui.chat.createroom.CreateRoomActivity
import com.example.chatapplication.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    lateinit var binding:ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendBtn.setOnClickListener({NavigateToCreateRoomActivity()})

    }

    private fun NavigateToCreateRoomActivity() {
        startActivity(Intent(this, CreateRoomActivity::class.java))
        finish()
    }
}