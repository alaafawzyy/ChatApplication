package com.example.chatapplication.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chatapplication.ui.home.fragments.allroms.AllRoomsFragment
import com.example.chatapplication.ui.home.fragments.myroom.MyRoomFragment

class RoomViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


    override fun getCount(): Int =2

    override fun getItem(position: Int): Fragment {
            val fragment = when(position){
                 0->   MyRoomFragment()
               else -> AllRoomsFragment()
            }
            return fragment
        }

    override fun getPageTitle(position: Int): CharSequence? {

        val title = when(position){
            0->   "MyRoomFragment"
            else -> "AllRoomsFragment"
        }
        return title
    }
    }
