package com.example.capitaleventosapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var Menu1: CardView
    private lateinit var Menu2: CardView
    private lateinit var Menu3: CardView
    private lateinit var Menu4: CardView
    private lateinit var facebook: ImageButton
    private lateinit var twitter: ImageButton
    private lateinit var instagram: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Menu1 = findViewById(R.id.cvMenu1)
        Menu2 = findViewById(R.id.cvMenu2)
        Menu3 = findViewById(R.id.cvMenu3)
        Menu4 = findViewById(R.id.cvMenu4)
        facebook = findViewById(R.id.facebook)
        twitter = findViewById(R.id.twitter)
        instagram = findViewById(R.id.instagram)

        Menu1.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }

        Menu2.setOnClickListener(this)
        Menu3.setOnClickListener(this)
        Menu4.setOnClickListener(this)

        facebook.setOnClickListener {
            val url = "https://www.facebook.com/EventosCapital/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        twitter.setOnClickListener {
            val url = "https://twitter.com/Eventos_Capital"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        instagram.setOnClickListener {
            val url = "https://www.instagram.com/capital_eventosmex/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.cvMenu2 -> {
                val intent = Intent(this@MainActivity, ServiciosActivity::class.java)
                startActivity(intent)
            }
            R.id.cvMenu3 -> {
                val intent = Intent(this@MainActivity, NosotrosActivity::class.java)
                startActivity(intent)
            }
            R.id.cvMenu4 -> {
                val intent = Intent(this@MainActivity, ContactoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
