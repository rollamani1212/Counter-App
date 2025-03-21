package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var counter=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val incr=findViewById<Button>(R.id.increment)
        val decr=findViewById<Button>(R.id.decrement)
        val reset=findViewById<Button>(R.id.reset)
        val te=findViewById<TextView>(R.id.display)
        incr.setOnClickListener{
            counter++
            te.text=counter.toString()
        }
        decr.setOnClickListener{
            counter--
            te.text=counter.toString()
        }
        reset.setOnClickListener{
            counter=0
            te.text=counter.toString()
        }
    }
}