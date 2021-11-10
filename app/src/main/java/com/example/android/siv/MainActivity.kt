package com.example.android.siv


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.TextView
import android.content.Intent




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                // pegando o valor digitado no LoginActivity
                val intent = intent
                val text = intent.getStringExtra(Intent.EXTRA_TEXT)

                val call = RetrofitFactory().retrofitService().getCodUser(text.toString())


            call.enqueue(object : Callback<ClasseVacina> {

                override fun onResponse(call: Call<ClasseVacina>, response: Response<ClasseVacina>) {

                    //ACHO QUE AQUI EU NAO SEI OQ FAZER


                }

                override fun onFailure(call: Call<ClasseVacina>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }
            })
        }
    }
