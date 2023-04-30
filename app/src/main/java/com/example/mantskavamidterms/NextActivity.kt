package com.example.mantskavamidterms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NextActivity : AppCompatActivity() {

    private lateinit var numberText : TextView
    private lateinit var messageText : TextView
    private lateinit var clearButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        init()

        val myIntent = intent // gets the previously created intent

        val number = myIntent.getStringExtra("number")
        val message = myIntent.getStringExtra("message")

        numberText.text = (number.toString())
        messageText.text = (message.toString())

        clearButton.setOnClickListener {
            messageText.text = ""
        }
    }

    private fun init(){
        numberText = findViewById(R.id.numberText)
        messageText = findViewById(R.id.messageText)
        clearButton = findViewById(R.id.clearButton)
    }
}