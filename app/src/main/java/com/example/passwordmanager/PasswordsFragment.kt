package com.example.passwordmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordmanager.databinding.FragmentAddBinding
import com.example.passwordmanager.databinding.FragmentPasswordsBinding
import com.google.android.material.slider.Slider.OnChangeListener
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.lang.Exception

class PasswordsFragment : Fragment() {
    private val adapter = BlockAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_passwords, container, false)

        val RcView: RecyclerView = view.findViewById(R.id.rcView)
        RcView.layoutManager = LinearLayoutManager(view.context)
        RcView.setHasFixedSize(true)
        RcView.adapter = adapter


        val DB = MainDB.getDB(view.context)
        DB.getDao().getALlItems().asLiveData()
            .observe(this@PasswordsFragment.viewLifecycleOwner, Observer<List<Entity>>() { list ->
                list.forEach { it ->
                    val block = Block(it.id!!, it.service, it.log, it.password)
                    adapter.addBlock(block)
                }
            })

        RcView.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.slide_in))

        return view
    }
}