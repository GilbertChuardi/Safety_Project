package com.example.safetyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SensorTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_test)
    }

    fun Back(view: View) {
        val i = Intent(this, SensorAbout::class.java)
        startActivity(i)
        finish()
    }

    fun gotoHomepage(view: View) {
        finish()
    }
}