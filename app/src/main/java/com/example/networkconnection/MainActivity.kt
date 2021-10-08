package com.example.networkconnection

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.netWorkStatus)

        LiveNetworkStatus.init(this)
//        if (!isNetworkAvailable(this)) {
//            AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Internet Connection Alert")
//                .setMessage("Please Check Your Internet Connection")
//                .setPositiveButton("Close") { dialogInterface, _->
//                    dialogInterface.dismiss()
//                }.show()
//        } else if (isNetworkAvailable(this)) {
//            Toast.makeText(
//                this@MainActivity,
//                "Welcome", Toast.LENGTH_LONG
//            ).show()
//        }

        LiveNetworkStatus.observe(this,{
            if(it) textView.text = "Connected"
            if(it == false) textView.text =   "Not Connected"

        })
    }



}