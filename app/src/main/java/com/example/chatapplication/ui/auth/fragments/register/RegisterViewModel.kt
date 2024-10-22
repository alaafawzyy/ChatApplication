package com.example.chatapplication.ui.auth.fragments.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.ViewMessage
import com.example.chatapplication.base.baseViewModel
import com.example.chatapplication.database.Mydatabase
import com.example.chatapplication.database.User
import com.example.chatapplication.ui.auth.fragments.login.LoginViewEvent
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class RegisterViewModel:baseViewModel() {
    val userNameLiveData=MutableLiveData<String>()
    var userErorr=MutableLiveData<String?>()
    val emailLiveData=MutableLiveData<String>()
    var emailErorr=MutableLiveData<String?>()
    val passwordLiveData=MutableLiveData<String>()
    var passwordErorr=MutableLiveData<String?>()
    val passwordConfirmLiveData=MutableLiveData<String>()
    var passwordConfirmErorr=MutableLiveData<String?>()
    var isRegister=MutableLiveData(false)
    val authService=Firebase.auth
    val events=MutableLiveData<RegisterViewEvents>()

    fun register(){
        if(isRegister.value==true)return
        if(!validateInput())return
        isRegister.value=true

        authService.createUserWithEmailAndPassword(emailLiveData.value!!,passwordLiveData.value!!).addOnCompleteListener({task->
            if (task.isSuccessful) {
                isRegister.value=false
                val user=task.result.user
               registerUserInDB(user!!.uid)
            }else
                isRegister.value=false
                viewMessage.value=ViewMessage(
                    message =task.exception?.localizedMessage?:"somthing wrong"
                )
        })


    }

    private fun registerUserInDB(uid: String) {
     val user=User(
         uid,
         userNameLiveData.value!!,
         emailLiveData.value!!
     )
        Mydatabase.createUser(user){
            if(it.isSuccessful){
                events.postValue( RegisterViewEvents.NavigateToHome(user))

            }else{
                viewMessage.value=ViewMessage(
                    message = it.exception?.localizedMessage?:"",
                    posActionName = "OK"
                )
            }

        }

    }

    fun validateInput():Boolean{
        var isvalid=true
        if (userNameLiveData.value.isNullOrBlank()){
            userErorr.value="Please Enter Your UserName"
            isvalid=false
        }else{
          userErorr.value=null
        }

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

        if (passwordConfirmLiveData.value.isNullOrBlank()){
            passwordConfirmErorr.value="Please Enter Your UserName"
            isvalid=false
        }else if(passwordLiveData.value != passwordConfirmLiveData.value){
            passwordConfirmErorr.value="Password doesn't match"
            isvalid=false
        }
        else{
            passwordConfirmErorr.value=null
        }
     return isvalid
    }
}