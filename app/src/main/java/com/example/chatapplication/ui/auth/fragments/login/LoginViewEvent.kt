package com.example.chatapplication.ui.auth.fragments.login

import com.example.chatapplication.database.User

sealed class LoginViewEvent {
    object NavigateToRegister:LoginViewEvent()
    class  NavigateToHomme(val user: User):LoginViewEvent()

}