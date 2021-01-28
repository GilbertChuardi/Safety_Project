package com.example.safetyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MedicalId : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_id)
    }

    fun Back(view: View) {
        finish()
    }
}