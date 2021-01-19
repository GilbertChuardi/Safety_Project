package com.example.safetyproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class Permission : AppCompatActivity() {

    lateinit var sharedPreferences1: SharedPreferences
    var firstTime1: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        sharedPreferences1 = getSharedPreferences("MyPrefs1", MODE_PRIVATE)
        firstTime1 = sharedPreferences1.getBoolean("firstTime1", true)

        if (firstTime1) {
            Handler().postDelayed(Runnable {
                val editor1 = sharedPreferences1.edit()
                firstTime1 = false
                editor1.putBoolean("firstTime1", firstTime1)
                editor1.apply()
                val i = Intent(this, Identity::class.java)
                startActivity(i)
                finish()
            }, 600000)
        } else {
            val i = Intent(this, Identity::class.java)
            startActivity(i)
            finish()
        }
    }

    fun radioBtnShowPermission(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioBtnPermission ->
                    if (checked) {
                        var play = findViewById(R.id.btnNextPagePermission) as Button
                        play.isClickable=true
                        play.visibility= View.VISIBLE
                    }
            }
        }
    }

    fun btnNextPermission(view:View) {
        val editor1 = sharedPreferences1.edit()
        firstTime1 = false
        editor1.putBoolean("firstTime1", firstTime1)
        editor1.apply()
        val i = Intent(this, Identity::class.java)
        startActivity(i)
        finish()
    }
}