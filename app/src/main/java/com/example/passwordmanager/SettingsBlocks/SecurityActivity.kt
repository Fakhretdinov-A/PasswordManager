package com.example.passwordmanager.SettingsBlocks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.passwordmanager.Block
import com.example.passwordmanager.Entity
import com.example.passwordmanager.MainDB
import com.example.passwordmanager.R
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.observeOn

class SecurityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_security)

        val butChangePIN: Button = findViewById(R.id.changepinbut)
        val new_pin: EditText = findViewById(R.id.newpin)
        val butDeleteDB: Button = findViewById(R.id.deleteallDB)
        val sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val DB = MainDB.getDB(this)

        butChangePIN.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to change your PIN?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    editor.putString("pin", new_pin.text.toString())
                    new_pin.setText("")
                    editor.apply()
                    Toast.makeText(this, Html.fromHtml("<font color='#07DA63'><b>" + "PIN is changed!" + "</b></font>"), Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }

        butDeleteDB.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to delete all data?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    Thread {
                        DB.getDao().delete()
                    }.start()
                    //DB.getDao().getALlItems().asLiveData()
                        //.observe(this, Observer<List<Entity>>() { list ->
                            //list.forEach { it ->
                                //DB.getDao().deletebyID(it.id!!)
                            //}
                        //})
                    Toast.makeText(this, Html.fromHtml("<font color='#07DA63'><b>" + "Database is deleted" + "</b></font>"), Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()


        }

        val but1: ImageButton = findViewById(R.id.backsec)
        but1.setOnClickListener {
            onBackPressed()
        }
    }
}