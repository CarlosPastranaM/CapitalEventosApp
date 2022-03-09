package com.example.capitaleventosapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_contacto.*


class ContactoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var Menu1: CardView
    private lateinit var Menu2: CardView
    private lateinit var Menu3: CardView
    private lateinit var Menu4: CardView
    private lateinit var facebook: ImageButton
    private lateinit var twitter: ImageButton
    private lateinit var instagram: ImageButton
    private lateinit var enviar: Button
    private lateinit var marcar: Button

    private val REQUEST_ID_MULTIPLE_PERMISSIONS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        Menu1 = findViewById(R.id.cvMenu1)
        Menu2 = findViewById(R.id.cvMenu2)
        Menu3 = findViewById(R.id.cvMenu3)
        Menu4 = findViewById(R.id.cvMenu4)
        facebook = findViewById(R.id.facebook)
        twitter = findViewById(R.id.twitter)
        instagram = findViewById(R.id.instagram)
        enviar = findViewById(R.id.enviar)
        marcar = findViewById(R.id.marcar)

        Menu4.setOnClickListener {
            val intent = Intent(this@ContactoActivity, ContactoActivity::class.java)
            startActivity(intent)
        }

        Menu1.setOnClickListener(this)
        Menu2.setOnClickListener(this)
        Menu3.setOnClickListener(this)

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
        marcar.setOnClickListener {
            val tel = "tel:5564960903"
            if (revisarPermiso()) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse(tel))
                try {
                    startActivity(intent)
                } catch (se: SecurityException) {
                    Log.i("Dar permiso de LLAMADA", se.message.toString())
                }
            }
        }
        enviar.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val correo = txvCorreo.text.toString()
            val destino = "infocapitaleventos@gmail.com"
            val message = txvComent.text.toString().trim()
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(destino))
            intent.putExtra(Intent.EXTRA_TEXT, message)
            val chooser = Intent.createChooser(intent, "Send Email")

            startActivity(chooser)
        })

        //enviar.setOnClickListener {
          //  val comentario = txvComent.text.toString()
           // val mailTo = "infocapitaleventos@gmail.com"+
             //       "&body=" + Uri.encode(comentario)

          //  val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(mailTo))
          //  startActivity(intent)
       // }
    }

    private fun revisarPermiso(): Boolean {
        val tienePermiso = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        if(tienePermiso != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.cvMenu1 -> {
                val intent = Intent(this@ContactoActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.cvMenu2 -> {
                val intent = Intent(this@ContactoActivity, ServiciosActivity::class.java)
                startActivity(intent)
            }
            R.id.cvMenu3 -> {
                val intent = Intent(this@ContactoActivity, NosotrosActivity::class.java)
                startActivity(intent)
            }
        }
    }
}