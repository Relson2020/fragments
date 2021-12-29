package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private lateinit var communicator : Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        communicator = activity as Communicator

        val editText = view.findViewById<EditText>(R.id.materialFragment1EditText)
        val button = view.findViewById<Button>(R.id.materialFragment1Button)

        button.setOnClickListener{
            Log.i("log",editText.text.toString())
            communicator.passDataCom(editText.text.toString())
        }


        return view
    }

}