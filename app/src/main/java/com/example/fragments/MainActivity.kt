package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , Communicator {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.fragment1Button.setOnClickListener{
            fragmentChange(FirstFragment())
        }

        binding.fragment2Button.setOnClickListener{
            fragmentChange(SecondFragment())
        }

        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.inflateMenu(R.menu.menu_main)

        toolBar.setOnMenuItemClickListener{
            if(it.itemId == R.id.settings){
                Toast.makeText(this,"hey settings",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun fragmentChange(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            addToBackStack(null)
            .commit()
        }

    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("value", editTextInput)
        val secondFragmentInstance = SecondFragment()
        secondFragmentInstance.arguments = bundle


        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,secondFragmentInstance)
        transaction.commit()

    }
}