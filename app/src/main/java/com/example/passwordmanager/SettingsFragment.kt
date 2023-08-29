package com.example.passwordmanager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.passwordmanager.SettingsBlocks.AboutActivity
import com.example.passwordmanager.SettingsBlocks.LanguageActivity
import com.example.passwordmanager.SettingsBlocks.ProfileActivity
import com.example.passwordmanager.SettingsBlocks.SecurityActivity

import com.ismaeldivita.chipnavigation.ChipNavigationBar

class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        val gotoProf: Button = view.findViewById(R.id.button_profile)
        val gotoSec: Button = view.findViewById(R.id.button_security)
        val gotoLang: Button = view.findViewById(R.id.button_language)
        val gotoAbout: Button = view.findViewById(R.id.button_about)

        gotoProf.setOnClickListener {
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }
        gotoSec.setOnClickListener {
            val intent = Intent(context, SecurityActivity::class.java)
            startActivity(intent)
        }

        gotoLang.setOnClickListener {
            val intent = Intent(context, LanguageActivity::class.java)
            startActivity(intent)
        }
        gotoAbout.setOnClickListener {
            val intent = Intent(context, AboutActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}