package bryan.amaris.bloomkids

import Modelo.Conexion
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class Pacientes : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root =  inflater.inflate(R.layout.fragment_pacientes, container, false)
        val NombrePaciente = root.findViewById<EditText>(R.id.txtNombrePaciente)
        val ApellidoPaciente = root.findViewById<EditText>(R.id.txtApellidoPaciente)
        val EdadaPaciente = root.findViewById<EditText>(R.id.txtEdadPaciente)
        val btnAgregarPaciente = root.findViewById<Button>(R.id.btnAgregarPaciente)

        btnAgregarPaciente.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val objConexion = Conexion().cadenaConexio()
                val PacienteAgregado = objConexion?.prepareStatement("Insert into tbPaciente (UUID_PACIENTE, Nombres_Paciente, Apellidos_Paciente, Edad )  values (?,?,?,?)")!!

                PacienteAgregado.setString(1,UUID.randomUUID().toString())
                PacienteAgregado.setString(2, NombrePaciente.text.toString())
                PacienteAgregado.setString(3,ApellidoPaciente.text.toString())
                PacienteAgregado.setString(4,EdadaPaciente.text.toString())
                PacienteAgregado.executeUpdate()
            }

        }



        return root
    }



}