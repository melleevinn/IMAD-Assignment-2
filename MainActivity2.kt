package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class SecondPage : AppCompatActivity() {

    private var petHealthy = 100
    private var petHungery = 50
    private var petCleanliness = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the buttons and text views
        val btnFeed = findViewById<Button>(R.id.button2)
        val btnClean = findViewById<Button>(R.id.button3)
        val btnHappy = findViewById<Button>(R.id.button4)
        val txtHunger = findViewById<EditText>(R.id.text1)
        val txtClean = findViewById<EditText>(R.id.text2)
        val txtHappy = findViewById<EditText>(R.id.text3)
        val petImage = findViewById<ImageView>(R.id.pet_image)

        // Set the initial text values
        txtHunger.setText(petHungery.toString())
        txtClean.setText(petCleanliness.toString())
        txtHappy.setText(petHealthy.toString())

        // Handle button clicks
        btnFeed.setOnClickListener {
            petHungery -= 10
            petHealthy += 10
            petHungery += 5
            txtHunger.setText(petHungery.toString())
            animateImageChange(petImage, R.drawable.lab_mac)
        }

        btnClean.setOnClickListener {
            petCleanliness += 10
            petHealthy += 10

            txtClean.setText(petCleanliness.toString())
            animateImageChange(petImage, R.drawable.maxresdefault)
        }

        btnHappy.setOnClickListener {
            petHealthy += 10
            petHungery += 5
            petCleanliness -= 5
            txtHappy.setText(petHealthy.toString())
            animateImageChange(petImage, R.drawable.maxresdefault)
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}