package com.example.capitaleventosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ProgressBar

class SplashBienvenidoActivity : AppCompatActivity() {
    private val SPLASH_RETARDO: Long = 3000
    private lateinit var barraSplash: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_bienvenido)

        barraSplash = findViewById(R.id.barSplash)
        object: CountDownTimer(SPLASH_RETARDO, 400) {
            override fun onTick(millisUntilFinished: Long) {
                barraSplash.progress = ((SPLASH_RETARDO - millisUntilFinished)
                        * 100 / SPLASH_RETARDO).toInt()
            }
            override fun onFinish() {
                barraSplash.progress = 100
            }
        }.start()

        val handler = Handler()
        handler.postDelayed( {
            val intento = Intent()
            intento.setClass(this@SplashBienvenidoActivity, MainActivity::class.java)
            startActivity(intento)
            finish()
        }, SPLASH_RETARDO)

    }
}
