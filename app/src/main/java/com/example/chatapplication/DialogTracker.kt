package com.example.chatapplication

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showDialog(
    context: Context?,
    message: String? = null,
    positiveButton: String? = "OK", // تعيين قيمة افتراضية
    postActionCallBack: (() -> Unit)? = null,
    negativeButton: String? = null
): AlertDialog {
    val alertDialog = AlertDialog.Builder(context ?: requireContext())
    alertDialog.setMessage(message)

    alertDialog.setPositiveButton(positiveButton) { dialogInterface, _ ->
        postActionCallBack?.invoke()
        dialogInterface.dismiss()
    }

    negativeButton?.let {
        alertDialog.setNegativeButton(it) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
    }

    return alertDialog.show()
}

fun Fragment.showDialog(
    viewMessage: ViewMessage
): AlertDialog {
    return showDialog(
        context = null,
        message = viewMessage.message,
        positiveButton = viewMessage.posActionName,
        postActionCallBack = viewMessage.posActionCallBack,
        negativeButton = viewMessage.negActionName
    )
}
