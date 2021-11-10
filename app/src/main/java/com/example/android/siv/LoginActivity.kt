package com.example.android.siv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    // "Go to Second Activity" button click
    fun buttonClickFunction(v: View?) {

        // get the text to pass
        val editText = findViewById<View>(R.id.til_usuario) as EditText
        val textToPass = editText.text.toString()

        // start the SecondActivity
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, textToPass)
        startActivity(intent)
    }
}


//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//    }
//
//    fun buttonClickFunction(v: View?) {
//        val intent = Intent(applicationContext, MainActivity::class.java)
//        startActivity(intent)
//    }
//}