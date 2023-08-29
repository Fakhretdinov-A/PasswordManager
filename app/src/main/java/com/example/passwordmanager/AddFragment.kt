package com.example.passwordmanager

import android.annotation.SuppressLint
import android.content.Context
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.passwordmanager.databinding.FragmentAddBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.FileNotFoundException
import java.io.FileOutputStream

class AddFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_add, container, false)
        val but: Button = view.findViewById(R.id.Addbutton)
        val DB = MainDB.getDB(view.context)
        val service: TextInputEditText = view.findViewById(R.id.ServiceInp)
        val login: TextInputEditText = view.findViewById(R.id.LoginInp)
        val password: TextInputEditText = view.findViewById(R.id.PasswordInp)


        but.setOnClickListener {
            val item =
                Entity(
                    null,
                    service.text.toString(),
                    login.text.toString(),
                    password.text.toString()
                )
            Thread {
                DB.getDao().insertItem(item)
            }.start()
            service.text!!.clear()
            login.text!!.clear()
            password.text!!.clear()
            Toast.makeText(view.context, "Added new account", Toast.LENGTH_SHORT).show()
        }


        val checker: CheckBox = view.findViewById(R.id.RandomizerCheck)
        val lo: LinearLayout = view.findViewById(R.id.RandomizerLO)
        checker.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                lo.visibility = View.VISIBLE
                password.isEnabled = false
            } else {
                lo.visibility = View.INVISIBLE
                password.isEnabled = true
            }
        }

        val passBar: SeekBar = view.findViewById(R.id.PassLenBar)
        val passText: TextView = view.findViewById(R.id.PassLenText)
        passBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                passText.text = "Password length: " + progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        val generateButton: Button = view.findViewById(R.id.generate_pass)
        val symbChecker: CheckBox = view.findViewById(R.id.symbolsChecker)
        generateButton.setOnClickListener {
            val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
            val specialSymb: List<Char> = listOf('!', '@', '#', '$', '%', '*')
            if (symbChecker.isChecked) {
                password.setText(List(passBar.progress) { (alphabet + specialSymb).random() }.joinToString(""))
            } else {
                password.setText(List(passBar.progress) { alphabet.random() }.joinToString(""))
            }
        }

        return view

    }

}