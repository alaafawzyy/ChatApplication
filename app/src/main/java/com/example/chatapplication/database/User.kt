package com.example.chatapplication.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User (
    val uid: String?=null,
    val uname: String?=null,
    val uemail: String?=null,
):Parcelable {

}