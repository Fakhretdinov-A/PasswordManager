package com.example.passwordmanager.SettingsBlocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.passwordmanager.R

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        val but1: ImageButton = findViewById(R.id.backlang)
        but1.setOnClickListener {
            onBackPressed()
        }
    }
}