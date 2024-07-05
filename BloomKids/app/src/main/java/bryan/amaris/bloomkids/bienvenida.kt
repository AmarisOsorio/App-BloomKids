package bryan.amaris.bloomkids

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation

class bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenida)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btncmAcceder = findViewById<Button>(R.id.btn_cmAcceder)
        //val txtcrear = findViewById<TextView>(R.id.txtcmCrearCuenta)
        //val imgcrearcuenta = findViewById<ImageView>(R.id.imgFlecha)

        btncmAcceder.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /*txtcrear.setOnClickListener(){
            startActivity(Intent(this,registro::class.java))
        }

        imgcrearcuenta.setOnClickListener(){
            startActivity(Intent(this,registro::class.java))
        }*/
    }
}