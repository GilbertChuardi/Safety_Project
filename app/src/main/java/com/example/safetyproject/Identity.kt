package com.example.safetyproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_identity.*
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class Identity : AppCompatActivity() {

    //ini yang first time(tutorial)
    lateinit var sharedPreferences2: SharedPreferences
    var firstTime2: Boolean = true

    //ini untuk show button setelah edit text nya diisi
    lateinit var editTextUsername: EditText

    // save nama di file nama Username.txt
    private val FILE_NAME = "Username.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identity)

        //ini yang first time(tutorial)
        sharedPreferences2 = getSharedPreferences("MyPrefs2", MODE_PRIVATE)
        firstTime2 = sharedPreferences2.getBoolean("firstTime2", true)

        if (firstTime2) {
            Handler().postDelayed(Runnable {
                val editor2 = sharedPreferences2.edit()
                firstTime2 = false
                editor2.putBoolean("firstTime1", firstTime2)
                editor2.apply()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }, 600000)
        } else {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        //ini untuk show button setelah edittext nya diisi
        editTextUsername = findViewById(R.id.inputIdentity)
        editTextUsername.addTextChangedListener(loginTextWatcher)

    }

    fun btnNextIdentity(view: View) {
        val fileData = findViewById<EditText>(R.id.inputIdentity)
        val data:String = fileData.text.toString()
        val fileOutputStream:FileOutputStream
        try {
            fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: FileNotFoundException){
            e.printStackTrace()
        }catch (e: NumberFormatException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }catch (e: Exception){
            e.printStackTrace()
        }

    val editor2 = sharedPreferences2.edit()
        firstTime2 = false
        editor2.putBoolean("firstTime2", firstTime2)
        editor2.apply()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    //ini untuk show button setelah edittext nya diisi
    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = editTextUsername.text.toString().trim { it <= ' ' }
            if (!usernameInput.isEmpty()) {
                val play = findViewById(R.id.btnNextPageIdentity) as Button
                play.isClickable = true
                play.visibility = View.VISIBLE
            }
            else{
                val play = findViewById(R.id.btnNextPageIdentity) as Button
                play.isClickable = false
                play.visibility = View.INVISIBLE
            }
        }
        override fun afterTextChanged(s: Editable) {}
    }
}