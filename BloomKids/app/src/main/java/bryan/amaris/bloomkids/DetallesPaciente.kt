package bryan.amaris.bloomkids

import Modelo.Conexion
import Modelo.Pacientes
import Modelo.tbCamas
import Modelo.tbEnfermedades
import Modelo.tbHabitaciones
import Modelo.tbMedicamentos
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetallesPaciente.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetallesPaciente : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_detalles_paciente, container, false)
        val spPaciente = root.findViewById<Spinner>(R.id.spPaciente)
        val spMedicamento = root.findViewById<Spinner>(R.id.spMedicamentos)
        val spEnfermedades = root.findViewById<Spinner>(R.id.spEnfermedades)
        val spHabitacion = root.findViewById<Spinner>(R.id.spHabitacion)
        val spCama = root.findViewById<Spinner>(R.id.spCama)
        val txtHoraAplicacion = root.findViewById<EditText>(R.id.txtHoraAplicacion)
        val btnGuardarDetalles= root.findViewById<Button>(R.id.btnGuardarDetalles)


        //Funcion para hacer el select de los nombres de los doctores que voy a mostrar en el Spinner

        fun obtenerPacientes(): List<Pacientes>{
            //Crear un objeto de la clase conexion
            val objConexion= Conexion().cadenaConexio()

            //crepo un Statement que me ejecutara el Select
            val Statement = objConexion?.createStatement()

            val resulset = Statement?.executeQuery("Select * from tbPacientes")!!

            val listadoPacientes= mutableListOf<Pacientes>()

            while (resulset.next()){
                val uuid_Paciente = resulset.getString("UUID_Paciente")
                val nombrePaciente = resulset.getString("Nombres_Paciente")
                val Apellidos = resulset.getString("Apellidos_Paciente")
                val Edad = resulset.getInt("Edad")
                val unPacienteCompleto = Pacientes(uuid_Paciente, nombrePaciente, Apellidos, Edad)

                listadoPacientes.add(unPacienteCompleto)
            }

            return listadoPacientes
        }
        //Programar Spinner para que muestre datos del select

        CoroutineScope(Dispatchers.IO).launch {
            //Obtengo los datos
            val listadoDeDoctores = obtenerPacientes()
            val nombreDoctores = listadoDeDoctores.map { it.Nombres_Paciente }

            withContext(Dispatchers.Main){
                //2-Crear y modificar el adaptador
                val miAdaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, nombreDoctores)

                spPaciente.adapter = miAdaptador
                }
    }

        //Spinner de Medicamentos
        fun obtenerMedicamentos(): List<tbMedicamentos>{
            val objConexion= Conexion().cadenaConexio()
            val Statement = objConexion?.createStatement()
            val resulset = Statement?.executeQuery("Select * from tbMedicamentos")!!
            val listadoMedicamentos= mutableListOf<tbMedicamentos>()
            while (resulset.next()){
                val uuid_Medicamento = resulset.getString("UUID_Medicamentos")
                val nombreMedicamento = resulset.getString("Nombre_Medicamento")
                val unMedicamentoCompleto = tbMedicamentos(uuid_Medicamento, nombreMedicamento)
                listadoMedicamentos.add(unMedicamentoCompleto)
            }

            return listadoMedicamentos
        }
        //Programar Spinner para que muestre datos del select

        CoroutineScope(Dispatchers.IO).launch {
            //Obtengo los datos
            val ListadoMedicamentos = obtenerMedicamentos()
            val nombreMedicamento = ListadoMedicamentos.map { it.Nombre_Medicamento }

            withContext(Dispatchers.Main){
                //2-Crear y modificar el adaptador
                val miAdaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, nombreMedicamento)

                spMedicamento.adapter = miAdaptador
            }
        }
        //Spinner de Habitaciones
        fun obtenerHabitaciones(): List<tbHabitaciones>{
            val objConexion= Conexion().cadenaConexio()
            val Statement = objConexion?.createStatement()
            val resulset = Statement?.executeQuery("Select * from tbHabitaciones")!!
            val listadoHabitaciones= mutableListOf<tbHabitaciones>()
            while (resulset.next()){
                val UUID_numHabitaciones = resulset.getString("UUID_numHabitaciones")
                val numeroHabitacion = resulset.getInt("numeroHabitacion")
                val unaHabitacionCompleta = tbHabitaciones(UUID_numHabitaciones, numeroHabitacion)
                listadoHabitaciones.add(unaHabitacionCompleta)
            }

            return listadoHabitaciones
        }
        //Programar Spinner para que muestre datos del select

        CoroutineScope(Dispatchers.IO).launch {
            //Obtengo los datos
            val ListadoHabitaciones = obtenerHabitaciones()
            val NumeroHabitacion = ListadoHabitaciones.map { it.numeroHabitacion }

            withContext(Dispatchers.Main){
                //2-Crear y modificar el adaptador
                val miAdaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, NumeroHabitacion)

                spHabitacion.adapter = miAdaptador
            }
        }
        //Spinner de Camaas
        fun obtenerCamas(): List<tbCamas>{
            val objConexion= Conexion().cadenaConexio()
            val Statement = objConexion?.createStatement()
            val resulset = Statement?.executeQuery("Select * from tbEnfermedades")!!
            val listadoCamas= mutableListOf<tbCamas>()
            while (resulset.next()){
                val UUID_NUMEROCAMA = resulset.getString("UUID_NUMEROCAMA")
                val NumeroCama = resulset.getInt("NumeroCama")
                val unaCamaCompleta = tbCamas(UUID_NUMEROCAMA, NumeroCama)
                listadoCamas.add(unaCamaCompleta)
            }

            return listadoCamas
        }
        //Programar Spinner para que muestre datos del select

        CoroutineScope(Dispatchers.IO).launch {
            //Obtengo los datos
            val ListadoCamas = obtenerCamas()
            val numeroCamas = ListadoCamas.map { it.NumeroCama }

            withContext(Dispatchers.Main){
                //2-Crear y modificar el adaptador
                val miAdaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, numeroCamas)

                spCama.adapter = miAdaptador
            }
        }
        //Spinner de eNFERMEDADES
        fun obtenerEnfermedades(): List<tbEnfermedades>{
            val objConexion= Conexion().cadenaConexio()
            val Statement = objConexion?.createStatement()
            val resulset = Statement?.executeQuery("Select * from tbEnfermedades")!!
            val listadoEnfermedades= mutableListOf<tbEnfermedades>()
            while (resulset.next()){
                val UUId_Enfermedad = resulset.getString("UUId_Enfermedad")
                val Nombre_Enfermedad = resulset.getString("Nombre_Enfermedad")
                val unaEnfermedadCompleta = tbEnfermedades(UUId_Enfermedad, Nombre_Enfermedad)
                listadoEnfermedades.add(unaEnfermedadCompleta)
            }

            return listadoEnfermedades
        }
        //Programar Spinner para que muestre datos del select

        CoroutineScope(Dispatchers.IO).launch {
            //Obtengo los datos
            val ListadoEnfermedades = obtenerEnfermedades()
            val nombreEnfermedades = ListadoEnfermedades.map { it.Nombre_Enfermedad }

            withContext(Dispatchers.Main){
                //2-Crear y modificar el adaptador
                val miAdaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, nombreEnfermedades)

                spEnfermedades.adapter = miAdaptador
            }
        }
        btnGuardarDetalles.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val objConexion = Conexion().cadenaConexio()

                val paciente = obtenerPacientes()
                val medicamentos= obtenerMedicamentos()
                val enfermedad = obtenerEnfermedades()
                val habitacion = obtenerHabitaciones()
                val cama = obtenerCamas()

                //2- Creo una variable que contenga un PrepareStatement
                val addPaciente = objConexion?.prepareStatement("insert into tbDetallesPaciente(UUID_Detalles, UUID_PACIENTE, UUID_MEDICAMENTOS, UUId_Enfermedad, UUID_numHabitaciones, UUID_NUMEROCAMA, Hora_Aplicacion_Medicamento) values(?, ?, ?, ?, ?, ?, ?)")!!
                addPaciente.setString(1, UUID.randomUUID().toString())
                addPaciente.setString(2, paciente[spPaciente.selectedItemPosition].UUID_PACIENTE)
                addPaciente.setString(3, medicamentos[spMedicamento.selectedItemPosition].UUID_MEDICAMENTOS)
                addPaciente.setString(4, enfermedad[spEnfermedades.selectedItemPosition].UUId_Enfermedad)
                addPaciente.setString(5, habitacion[spHabitacion.selectedItemPosition].UUID_numHabitaciones)
                addPaciente.setString(6, cama[spCama.selectedItemPosition].UUID_NUMEROCAMA)
                addPaciente.setString(7,txtHoraAplicacion.text.toString())
                addPaciente.executeUpdate()
            }
        }

        return root



    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetallesPaciente().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}