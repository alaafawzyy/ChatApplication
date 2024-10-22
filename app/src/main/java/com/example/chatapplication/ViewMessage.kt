package com.example.chatapplication

class ViewMessage(
    val message:String,
    val posActionName:String?=null,
    val posActionCallBack:(()->Unit)?=null,
    val negActionName:String?=null,
    val negActionCallBack:(()->Unit)?=null,
    val isDismissable:Boolean?=true

) {
}