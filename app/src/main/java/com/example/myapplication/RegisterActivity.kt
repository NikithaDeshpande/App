package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout



class RegisterActivity : AppCompatActivity() {
    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var confirmInputLayout: TextInputLayout
    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var confirmEditText: TextInputEditText
    val namePattern = Regex("^[A-Za-z-' ]+\$")
    val passwordPattern=Regex("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$")

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val t = findViewById<TextView>(R.id.sign_in_footer2)
        val t1 = findViewById<TextView>(R.id.Sign_in_Toolbar)
        nameInputLayout = findViewById(R.id.Register_textview_Name)
        emailInputLayout = findViewById(R.id.Register_textview_email)
        passwordInputLayout = findViewById(R.id.Register_textview_password)
        confirmInputLayout = findViewById(R.id.Register_textview_confirm_password)
        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.Email)
        passwordEditText = findViewById(R.id.Password)
        confirmEditText = findViewById(R.id.ConfirmPassword)
        t.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        t1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val t2 = findViewById<TextView>(R.id.Register_button)

        var isValidName = false
        //Full name field validation
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    nameInputLayout.error = "Field can't be empty"

                } else if (!namePattern.matches(s.toString())) {
                    nameInputLayout.error = "Enter a valid full name"

                } else {
                    isValidName = true
                    nameInputLayout.error = null

                }
            }

        })
        var isValidEmail = false
        //email field validation
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    emailInputLayout.error = "Field can't be empty"

                } else if (!Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    emailInputLayout.error = "Enter a valid email address"

                } else {
                    isValidEmail = true
                    emailInputLayout.error = null

                }
            }
        })
        var isValidPassword = false
        //password field validation
        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    passwordInputLayout.error = "Field can't be empty"

                } else if (!passwordPattern.matches(s.toString())) {
                    passwordInputLayout.error = "Enter a valid password"

                } else {
                    isValidPassword = true
                    passwordInputLayout.error = null

                }
            }

        })
        var isValidConfirm = false
        //confirm password validation
        confirmEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required to implement
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required to implement
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    confirmInputLayout.error = "Field can't be empty"

                } else if (passwordEditText.text.toString() != confirmEditText.text.toString()) {
                    confirmInputLayout.error = "Password doesn't match"

                } else {
                    isValidConfirm = true
                    confirmInputLayout.error = null

                }
            }

        })
val l=LoadingDialog(this@RegisterActivity)
        t2.setOnClickListener {
            if (isValidName && isValidEmail && isValidPassword && isValidConfirm) {
                val name: String = nameEditText.text.toString()
                val email: String = emailEditText.text.toString()
                val password: String = passwordEditText.text.toString()
                val conPassword: String = confirmEditText.text.toString()
                val retrofit=RetrofitClass()
                val ans=retrofit.registerFunction(name, email, password, conPassword)
                l.startDialog(true)
            } else {
                Toast.makeText(this, "please enter all fields", Toast.LENGTH_LONG).show()
            }

        }
    }}

