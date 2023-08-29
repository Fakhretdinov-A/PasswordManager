package com.example.passwordmanager.SettingsBlocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.passwordmanager.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val but: ImageButton = findViewById(R.id.backabout)
        but.setOnClickListener {
            onBackPressed()
        }
    }
}