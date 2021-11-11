package com.example.android.siv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesquisaRegistro: Button = findViewById(R.id.pesquisaRegistro)
        val cdUser: EditText = findViewById(R.id.cdUser)
        val progress_bar: ProgressBar = findViewById(R.id.progress_bar)


        //-- Ao clicar no botão número busca-se o registro do usuario dentro da API
        pesquisaRegistro.setOnClickListener {

            progress_bar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getCodUser(cdUser.text.toString())

            call.enqueue(object : Callback<List<ClasseVacina>> {

                override fun onResponse(call: Call<List<ClasseVacina>>, response: Response<List<ClasseVacina>>) {

                    response.body()?.let {
                        Log.i("Vacina", it.toString())
                        Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
                        progress_bar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(this@MainActivity, "Registro não encontrado", Toast.LENGTH_LONG)
                        .show()

                }

                override fun onFailure(call: Call<List<ClasseVacina>>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progress_bar.visibility = View.INVISIBLE
                }

            })
        }

    }
}






























//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import android.widget.TextView
//import android.content.Intent
//
//
//
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//                // pegando o valor digitado no LoginActivity
//                val intent = intent
//                val text = intent.getStringExtra(Intent.EXTRA_TEXT)
//
//                val call = RetrofitFactory().retrofitService().getCodUser(text.toString())
//
//
//            call.enqueue(object : Callback<ClasseVacina> {
//
//                override fun onResponse(call: Call<ClasseVacina>, response: Response<ClasseVacina>) {
//
//                    //ACHO QUE AQUI EU NAO SEI OQ FAZER
//
//
//                }
//
//                override fun onFailure(call: Call<ClasseVacina>?, t: Throwable?) {
//                    t?.message?.let { it1 -> Log.e("Erro", it1) }
//                }
//            })
//        }
//    }
