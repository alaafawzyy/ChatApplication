package com.example.chatapplication.ui.auth.fragments.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.ViewMessage
import com.example.chatapplication.base.baseViewModel
import com.example.chatapplication.database.Mydatabase
import com.example.chatapplication.database.User
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginViewModel:baseViewModel(){
    val emailLiveData=MutableLiveData<String>()
    var emailErorr=MutableLiveData<String?>()
    val passwordLiveData=MutableLiveData<String>()
    var passwordErorr=MutableLiveData<String?>()
    var isLoading=MutableLiveData(false)
    val authService=Firebase.auth
    val events=MutableLiveData<LoginViewEvent>()


    fun register(){
        if(isLoading.value==true)return
        if(!validateInput())return

        isLoading.value=true
        Log.d("alaa","alaa")
        authService.signInWithEmailAndPassword(emailLiveData.value!!,passwordLiveData.value!!).addOnCompleteListener({task->
            Log.d("alaa2","alaa2")
            if (task.isSuccessful) {
                val user=task.result.user
             getUserFromDataBase(user!!.uid)

            }else
                isLoading.value=false
                viewMessage.value=ViewMessage(
                    message =task.exception?.localizedMessage?:"somthing wrong"
                )
        })

    }

    private fun getUserFromDataBase(uid: String) {
        Mydatabase.getUserFromDB(uid) {
            isLoading.value = false
            val user = it.result.toObject(User::class.java)
            if (it.isSuccessful && user != null) {
                Log.d("alaa4","alaa4")
                events.postValue(LoginViewEvent.NavigateToHomme(user!!))

            } else
                viewMessage.postValue(
                    ViewMessage(
                        message = it.exception?.localizedMessage ?: "",
                        posActionName = "ok"

                    )
                )
        }
    }

    fun onGoToRegisterClick(){
        events.postValue(LoginViewEvent.NavigateToRegister)
    }

    fun validateInput():Boolean{
        var isvalid=true

        if (emailLiveData.value.isNullOrBlank()){
            emailErorr.value="Please Enter Your Email"
            isvalid=false
        }else{
           emailErorr.value=null
        }

        if (passwordLiveData.value.isNullOrBlank()){
            passwordErorr.value="Please Enter Your UserName"
            isvalid=false
        }else{
            passwordErorr.value=null
        }
     return isvalid
    }
}