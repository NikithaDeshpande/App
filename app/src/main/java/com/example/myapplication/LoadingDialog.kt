package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Handler
import android.os.Looper

class LoadingDialog (private var activity: Activity){
    private lateinit var alterDialog:AlertDialog
   @SuppressLint("SuspiciousIndentation", "InflateParams")
   fun startDialog(b:Boolean) {
        val builder=AlertDialog.Builder(activity)
        val inflate =activity.layoutInflater
        builder.setView(inflate.inflate(R.layout.activity_progress_bar,null))
            .setCancelable(true)
      alterDialog=builder.create()
        alterDialog.show()
       val handler=Handler(Looper.getMainLooper())
       handler.postDelayed({
           alterDialog.dismiss()
           showDialogMessage(b)
       },2000)

    }

    private fun showDialogMessage(b: Boolean) {
        val message=if(b) "Success" else "Not success"
        val builder=AlertDialog.Builder(activity)
        builder.setMessage(message).setCancelable(false).setPositiveButton("Ok"){ _: DialogInterface?, _: Int ->
            redirectToLoginPage()}
        val r=builder.create()
        r.show()
    }

    private fun redirectToLoginPage() {
        val i=Intent(activity,LoginActivity::class.java)
        activity.startActivity(i)
       activity.finish()

    }

}