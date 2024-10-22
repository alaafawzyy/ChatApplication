package com.example.chatapplication.ui.auth.fragments.register

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

 @BindingAdapter("app:error")
fun setErrorToTextInputLayout(
    textInputLayout:TextInputLayout,
    errorText:String?
){
         textInputLayout.error=errorText?:""
}