package com.example.chatapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.ViewMessage

open class baseViewModel :ViewModel(){
    val viewMessage= MutableLiveData<ViewMessage>()

}