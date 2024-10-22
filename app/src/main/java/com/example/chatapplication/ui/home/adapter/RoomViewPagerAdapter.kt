package com.example.chatapplication.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.chatapplication.ui.home.fragments.allroms.AllRoomsFragment
import com.example.chatapplication.ui.home.fragments.myroom.MyRoomFragment

class RoomViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MyRoomFragment()
            else -> AllRoomsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "MyRoomFragment"
            else -> "AllRoomsFragment"
        }
    }
}
