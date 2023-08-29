package com.example.passwordmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.passwordmanager.SettingsBlocks.SecurityActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.ismaeldivita.chipnavigation.ChipNavigationBar.OnItemSelectedListener

class MainActivity : AppCompatActivity() {



    private lateinit var bottomNav: ChipNavigationBar
    lateinit var fragmentMngr : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //ThemeActivity().onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottom_menu)



        if (savedInstanceState == null) {
            bottomNav.setItemSelected(R.id.password_menu, true)
            fragmentMngr = supportFragmentManager
            val PasswordsFrgm = PasswordsFragment()
            fragmentMngr.beginTransaction().replace(R.id.FrameLayout, PasswordsFrgm).commit()
        }

        bottomNav.setOnItemSelectedListener { id ->
            var fragment = Fragment()
            when (id) {
                R.id.password_menu -> fragment = PasswordsFragment()
                R.id.add_menu -> fragment = AddFragment()
                R.id.settings_menu -> fragment = SettingsFragment()
            }
            if (fragment != null) {
                fragmentMngr = supportFragmentManager
                fragmentMngr.beginTransaction().replace(R.id.FrameLayout, fragment).commit()


            }
        }


    }
}
