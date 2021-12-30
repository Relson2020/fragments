package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val button =  view.findViewById<Button>(R.id.materialButton)

        val data = arguments?.getString("value")
        val text = view.findViewById<TextView>(R.id.materialFragment2TextView)
        text.setText(data.toString())

        button.setOnClickListener{
            val dialogInstance = DialogFragment()
            dialogInstance.show(childFragmentManager,"MyFragment")
        }
        return view
    }

}