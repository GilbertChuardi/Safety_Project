package com.example.safetyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SensorAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_about)
    }

    fun Back(view: View) {
        finish()
    }

    fun gotoSensorTest(view: View) {
        val i = Intent(this, SensorTest::class.java)
        startActivity(i)
        finish()
    }
}