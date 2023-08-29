package com.example.passwordmanager

import android.R.attr.duration
import android.R.id.message
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//import `in`.arjsna.passcodeview.PassCodeView

class PinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        val but: Button = findViewById(R.id.enterbutton)
        val text: EditText = findViewById(R.id.pintext_enter)
        val sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val signup = sharedPreferences.getBoolean("signedUp", false)
        but.setOnClickListener {
            if (text.text.toString() == sharedPreferences.getString("pin", "").toString()) {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, Html.fromHtml("<font color='#07DA63'><b>" + "Welcome back!" + "</b></font>"), Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong PIN!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, Html.fromHtml("<font color='#E83845'><b>" + "Wrong PIN!" + "</b></font>"), Toast.LENGTH_SHORT).show()
                text.setText("")
            }
        }


    }
}