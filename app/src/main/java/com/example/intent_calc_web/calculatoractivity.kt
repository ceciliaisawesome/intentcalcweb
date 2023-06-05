package com.example.intent_calc_web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class calculatoractivity : AppCompatActivity() {
    lateinit var Txanswer:TextView
    lateinit var edtfnum:EditText
    lateinit var edtsnum:EditText
    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttontimes:Button
    lateinit var buttondivide:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculatoractivity)
        Txanswer=findViewById(R.id.txtview_answer)
        edtfnum=findViewById(R.id.Edt_fnum)
        edtsnum=findViewById(R.id.Edt_snum)
        buttonadd=findViewById(R.id.Btn_add)
        buttonsub=findViewById(R.id.Btn_subtract)
        buttontimes=findViewById(R.id.Btn_times)
        buttondivide=findViewById(R.id.Btn_divide)

        buttonadd.setOnClickListener {
            val firstnum=edtfnum.text.toString()
            val secondnum=edtsnum.text.toString()
            if(firstnum.isEmpty()&& secondnum.isEmpty()){
                Txanswer.text="Please fill in all detail"
            }else{
                var answer=firstnum.toDouble()+secondnum.toDouble()
                Txanswer.text=answer.toString()
            }
        }
        buttonsub.setOnClickListener {
            val firstnum=edtfnum.text.toString()
            val secondnum=edtsnum.text.toString()
            if(firstnum.isEmpty()&& secondnum.isEmpty()){
                Txanswer.text="Please fill in all detail"
            }else{
                var answer=firstnum.toDouble()-secondnum.toDouble()
                Txanswer.text=answer.toString()
            }
        }
        buttontimes.setOnClickListener {
            val firstnum=edtfnum.text.toString()
            val secondnum=edtsnum.text.toString()
            if(firstnum.isEmpty()&& secondnum.isEmpty()){
                Txanswer.text="Please fill in all detail"
            }else{
                var answer=firstnum.toDouble()*secondnum.toDouble()
                Txanswer.text=answer.toString()
            }
        }
        buttondivide.setOnClickListener {
            val firstnum=edtfnum.text.toString()
            val secondnum=edtsnum.text.toString()
            if(firstnum.isEmpty()&& secondnum.isEmpty()){
                Txanswer.text="Please fill in all detail"
            }else{
                var answer=firstnum.toDouble()/secondnum.toDouble()
                Txanswer.text=answer.toString()
            }
        }
    }
}