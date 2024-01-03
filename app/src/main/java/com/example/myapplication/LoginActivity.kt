package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    private lateinit var t7: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        t7 = findViewById(R.id.Login_Footer2)
        t7.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        val textView =
            findViewById<TextView>(R.id.Login_button) // Assuming Login_button is a TextView
        textView.setOnClickListener {
            val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

        val cardView = findViewById<CardView>(R.id.card1)
        val emailEditText = findViewById<TextInputEditText>(R.id.email)

        emailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                cardView.cardElevation = resources.getDimension(R.dimen.elevation_focused)
            } else {
                cardView.cardElevation = resources.getDimension(R.dimen.elevation_default)
            }
        }

        val cardView1 = findViewById<CardView>(R.id.card2)
        val emailEditText1 = findViewById<TextInputEditText>(R.id.password)

        emailEditText1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                cardView1.cardElevation = resources.getDimension(R.dimen.elevation_focused)
            } else {
                cardView1.cardElevation = resources.getDimension(R.dimen.elevation_default)
            }
        }
        val retrofit=RetrofitClass()
        retrofit.loginFunction(emailEditText.text.toString(),emailEditText1.text.toString())



    }
}
