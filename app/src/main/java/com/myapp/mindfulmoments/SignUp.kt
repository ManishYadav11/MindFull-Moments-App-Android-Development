package com.myapp.mindfulmoments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

    private lateinit var signUpUsernameEdit: EditText
    private lateinit var signUpPasswordEdit: EditText
    private lateinit var btnSignUp: Button
    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpUsernameEdit = findViewById(R.id.signUpUsername)
        signUpPasswordEdit = findViewById(R.id.signUpPassword)
        btnSignUp = findViewById(R.id.btnSignup)
        btnSignIn = findViewById(R.id.btnSignIn)

        btnSignUp.setOnClickListener {
            signUpToHome()
        }

        btnSignIn.setOnClickListener {
            navigateToSignIn()
        }
    }

    private fun signUpToHome() {
        val username = signUpUsernameEdit.text.toString()
        val password = signUpPasswordEdit.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
        } else {
            // Perform sign-up logic and navigate to the main activity
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}