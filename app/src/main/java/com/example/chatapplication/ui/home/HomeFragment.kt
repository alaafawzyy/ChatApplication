package com.example.chatapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.example.chatapplication.R
import com.example.chatapplication.base.baseFragment
import com.example.chatapplication.databinding.FragmentHomeBinding
import com.example.chatapplication.ui.home.adapter.RoomViewPagerAdapter
import com.example.chatapplication.ui.roomdetails.RoomDetailsActivity

class HomeFragment :baseFragment<FragmentHomeBinding,HomeViewModel>(){

   val args:HomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addRoomBtn.setOnClickListener({NavigateToRoomDetails()})
        initRoomViewPadger()
    }

    override fun initViewModel(): HomeViewModel {
      return  ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun getLatoutId(): Int {
        return R.layout.fragment_home
    }

    private fun NavigateToRoomDetails() {
        startActivity(Intent(requireContext(),RoomDetailsActivity::class.java))
    }

    private fun initRoomViewPadger() {
      val adapter=RoomViewPagerAdapter(childFragmentManager)
        binding.pager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }
}