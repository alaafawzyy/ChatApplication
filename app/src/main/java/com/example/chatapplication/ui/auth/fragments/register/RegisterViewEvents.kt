package com.example.chatapplication.ui.auth.fragments.register

import com.example.chatapplication.database.User

sealed class RegisterViewEvents {
    data class NavigateToHome(val user: User):RegisterViewEvents()
}