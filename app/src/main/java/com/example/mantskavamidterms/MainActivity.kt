package com.example.mantskavamidterms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {

    private lateinit var NumberInput : EditText
    private lateinit var MessageInput : EditText
    private lateinit var SendButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        SendButton.setOnClickListener {

            val myIntent = Intent(this, NextActivity::class.java)
            val number = NumberInput.text.toString()
            val message = MessageInput.text.toString()

            if (number.isEmpty() || message.isEmpty() || message.length > 250 || !number.isDigitsOnly()){
                Toast.makeText(this, "Not good enough! try again", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            myIntent.putExtra("number", number)
            myIntent.putExtra("message", message)

            startActivity(myIntent)
        }
    }

    private fun init(){
        NumberInput = findViewById(R.id.NumberInput)
        MessageInput = findViewById(R.id.MessageInput)
        SendButton = findViewById(R.id.SendButton)
    }
}