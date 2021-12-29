package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    private var data : String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        view.findViewById<Button>(R.id.materialFragment2TextView)

        val data = arguments?.getString("value")
        Log.i("log",data.toString())
        val text = view.findViewById<TextView>(R.id.materialFragment2TextView)
        text.setText(data.toString())
        return view
    }

}