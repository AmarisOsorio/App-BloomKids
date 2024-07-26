package bryan.amaris.bloomkids

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_datosPr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datos_pr)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TODO:Otra parte del companion object////

        //Mandar a traer en las variable globales
        val nombreGlobal = DetallesPaciente.variablesGlobales.nombrePaciente


        //Mandar a llamar lo que esta en esta pantalla
        val nombre = findViewById<TextView>(R.id.txtDPNombre)
        nombre.text =  nombreGlobal
    }
}