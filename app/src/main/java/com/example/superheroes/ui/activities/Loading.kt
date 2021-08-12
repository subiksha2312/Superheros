package com.example.superheroes.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.R
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.ActionBar


class Loading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val actionbar: ActionBar? = supportActionBar
        actionbar?.hide()

        val backgroundtag: ImageView = findViewById(R.id.imageView)
        val slide = AnimationUtils.loadAnimation(this, R.anim.slide)
        backgroundtag.startAnimation(slide)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },5000)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this, MainActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, 5000)
    }
}