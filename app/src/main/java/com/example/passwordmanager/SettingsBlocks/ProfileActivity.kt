package com.example.passwordmanager.SettingsBlocks

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.passwordmanager.MainActivity
import com.example.passwordmanager.R
import com.example.passwordmanager.SignUpActivity
import com.example.passwordmanager.databinding.ActivityProfileBinding
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)

        val textpass: TextInputEditText = findViewById(R.id.profile_password)
        val textemail: TextInputEditText = findViewById(R.id.profile_email)
        textpass.setText(sharedPreferences.getString("password", ""))
        textemail.setText(sharedPreferences.getString("email", ""))

        val but: Button = findViewById(R.id.profile_logout)
        but.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("signedUp", false)
            val intent = Intent(this, SignUpActivity::class.java)
            editor.apply()
            startActivity(intent)

        }
        val but1: ImageButton = findViewById(R.id.backprof)
        but1.setOnClickListener {
            onBackPressed()
        }
    }
}