package bryan.amaris.bloomkids

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class crearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_cuenta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgAtras = findViewById<ImageView>(R.id.imgAtrasLg)
        val btningresar = findViewById<Button>(R.id.btnAcceder)

        imgAtras.setOnClickListener(){
            startActivity(Intent(this,bienvenida::class.java))
        }

        //btningresar.setOnClickListener(){
            //startActivity(Intent(this,MainActivity::class.java))
       //}

    }
}