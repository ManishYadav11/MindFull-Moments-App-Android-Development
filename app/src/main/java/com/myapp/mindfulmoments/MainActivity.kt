package com.myapp.mindfulmoments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var signupButton: ImageView
    private lateinit var editTxt1: EditText
    private lateinit var editTxt2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxt1 = findViewById(R.id.editTextLoginUsername)
        editTxt2 = findViewById(R.id.editTextLoginPassword)
        loginButton = findViewById(R.id.buttonLogin)
        signupButton = findViewById(R.id.signupGoogle)

        loginButton.setOnClickListener {
            login()
        }

        signupButton.setOnClickListener {
            openSignUpPage()
        }
    }

    private fun login() {
        val user = editTxt1.text.toString()
        val pass = editTxt2.text.toString()

        // Hardcoded login credentials for simplicity
        val hardcodedUsername = "user123"
        val hardcodedPassword = "password123"

        if (user == hardcodedUsername && pass == hardcodedPassword) {
            // Successful login
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

            // Proceed to the main activity
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish() // Finish the current activity
        } else {
            // Invalid credentials
            Toast.makeText(this, "Login failed! Please check your credentials.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openSignUpPage() {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }
}