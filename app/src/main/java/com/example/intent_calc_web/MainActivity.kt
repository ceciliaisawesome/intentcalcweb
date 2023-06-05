package com.example.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {
    lateinit var calculator: Button
    lateinit var intent: Button
    lateinit var btnweb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculator=findViewById(R.id.Btn_calc)
        intent=findViewById(R.id.Btn_intent)
        btnweb=findViewById(R.id.Btn_web)

        calculator.setOnClickListener{
            val intent=Intent(this, calculatoractivity::class.java)
            startActivity(intent)
        }
        intent.setOnClickListener {
            val intent=Intent(this,intentactivity::class.java)
            startActivity(intent)
        }
        btnweb.setOnClickListener {
            val intent=Intent(this,webactivity::class.java)
            startActivity(intent)
        }
    }
}