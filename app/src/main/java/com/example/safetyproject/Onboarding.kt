package com.example.safetyproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity



class Onboarding : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var firstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        firstTime = sharedPreferences.getBoolean("firstTime", true)

        if (firstTime) {
            Handler().postDelayed(Runnable {
                val editor = sharedPreferences.edit()
                firstTime = false
                editor.putBoolean("firstTime", firstTime)
                editor.apply()
                val i = Intent(this, Permission::class.java)
                startActivity(i)
                finish()
            }, 600000)
        } else {
            val i = Intent(this, Permission::class.java)
            startActivity(i)
            finish()
        }
    }

    fun btnNextPageAbout(view: View) {
        val editor = sharedPreferences.edit()
        firstTime = false
        editor.putBoolean("firstTime", firstTime)
        editor.apply()
        val i = Intent(this, Permission::class.java)
        startActivity(i)
        finish()
    }
}