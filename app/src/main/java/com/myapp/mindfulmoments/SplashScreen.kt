package com.myapp.mindfulmoments

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashImg : ImageView = findViewById(R.id.splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()

        } , 0)
    }
}