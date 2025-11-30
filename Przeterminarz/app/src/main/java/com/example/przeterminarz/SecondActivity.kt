package com.example.przeterminarz

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.przeterminarz.databinding.ActivityMainBinding
import com.example.przeterminarz.databinding.SecondScreenBinding

class SecondActivity : AppCompatActivity(){


    lateinit var mainActivityBinding: ActivityMainBinding
    lateinit var thisScreenBinding: SecondScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        thisScreenBinding= SecondScreenBinding.inflate(layoutInflater)

        thisScreenBinding.secondScreenToMain.setOnClickListener {
            setContentView(mainActivityBinding.root)
        }

    }
}