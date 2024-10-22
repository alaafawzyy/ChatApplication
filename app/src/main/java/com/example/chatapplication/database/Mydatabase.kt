package com.example.chatapplication.database

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore

object Mydatabase {
   const val userCollection="users"

    fun createUser(user: User,onCompleteListener: OnCompleteListener<Void>){
        Firebase.firestore.collection(userCollection)
            .document(user.uid?:"")
            .set(user)
            .addOnCompleteListener(onCompleteListener)

    }

    fun getUserFromDB(uid: String,onComplete:OnCompleteListener<DocumentSnapshot>) {
         Firebase.firestore.collection(userCollection)
             .document(uid)
             .get()
             .addOnCompleteListener(onComplete)
    }
}