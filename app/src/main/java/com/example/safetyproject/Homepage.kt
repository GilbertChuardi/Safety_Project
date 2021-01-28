package com.example.safetyproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private val FILE_NAME = "Username.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        Username()


        /* //viewpager
        var imgs = listOf<Int>(R.drawable.homepageimage1,R.drawable.homepageimage2,R.drawable.homepageimage3)
        var adapter = Adapter(imgs,this)
        viewpager.adapter = adapter
         */
    }

    fun Username() {
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput(FILE_NAME)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(text)
        }
        //Displaying data on EditText
        textViewUsername.setText("Hi, " + stringBuilder.toString() + "!").toString()
    }

    fun ExitApplication(view: View) {
        finish()
        System.exit(0)
    }

    fun gotoMedical(view: View) {
        val i = Intent(this, MedicalId::class.java)
        startActivity(i)
    }

    fun gotoContact(view: View) {
        val i = Intent(this, Contact::class.java)
        startActivity(i)
    }

    fun gotoSensor(view: View) {
        val i = Intent(this, SensorAbout::class.java)
        startActivity(i)
    }




}