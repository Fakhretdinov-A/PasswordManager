package com.example.passwordmanager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import com.example.passwordmanager.SettingsBlocks.ProfileActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        val sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val signup = sharedPreferences.getBoolean("signedUp", false)

        if (signup) {
            val intent = Intent(this, PinActivity::class.java)
            super.onCreate(savedInstanceState)
            startActivity(intent)
        } else {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_up)

            var but: Button = findViewById(R.id.signupbutton)
            var email: EditText = findViewById(R.id.emailtext)
            var pass: EditText = findViewById(R.id.passwordtext)
            var pin: EditText = findViewById(R.id.pintext)
            but.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                GlobalClass().IsSignUp = true
                editor.putBoolean("signedUp", true)
                editor.putString("email", email.text.toString())
                editor.putString("password", pass.text.toString())
                editor.putString("pin", pin.text.toString())
                editor.apply()
                startActivity(intent)
            }
        }

    }
}