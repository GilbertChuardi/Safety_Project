package com.example.safetyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    fun Back(view: View) {
        finish()
    }
}