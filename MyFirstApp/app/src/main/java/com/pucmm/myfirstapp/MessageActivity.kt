package com.pucmm.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val form = intent.getSerializableExtra("form");
        var message = findViewById<TextView>(R.id.Message);
        message.text = form.toString();
    }
}