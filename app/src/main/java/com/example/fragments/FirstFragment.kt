package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.fragmentToolBar)

        button.setOnClickListener{
            Log.i("log",editText.text.toString())
            communicator.passDataCom(editText.text.toString())
        }

        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener{
            if(it.itemId == R.id.settings){
                Toast.makeText(context,"hey fragment",Toast.LENGTH_SHORT).show()
            }
            true
        }
        return view
    }

}