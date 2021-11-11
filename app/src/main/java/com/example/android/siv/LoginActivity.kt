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

    fun buttonClickFunction(v: View?) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}