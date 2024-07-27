package PacientesHelper

import Modelo.Conexion
import Modelo.Pacientes
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

import bryan.amaris.bloomkids.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PacientesAdaptador(private var Datos: List<Pacientes>) : RecyclerView.Adapter<ViewHolderPacientes>() {

    fun ActualizarListaDespuesDeActualizarDatos(UUID_Paciente: String, NuevoNombrePaciente: String){
        val index = Datos.indexOfFirst { it.UUID_PACIENTE == UUID_Paciente }
        Datos[index].Nombres_Paciente = NuevoNombrePaciente
        notifyItemChanged(index)
    }

    fun eliminarRegistro(NombrePaciente: String, posicion: Int){

        //Quitar el elemento de la lista
        val listaDatos= Datos.toMutableList()
        listaDatos.removeAt(posicion)

        //Quitar de la base de datos
        GlobalScope.launch(Dispatchers.IO){
            //1-Crear un objeto de clase conexion
            val objConexion = Conexion().cadenaConexio()
            val deletePaciente= objConexion?.prepareStatement("Delete tbPaciente where Nombres_Paciente = ?")!!
            deletePaciente.setString(1,NombrePaciente)
            deletePaciente.executeUpdate()


            val commit = objConexion.prepareStatement("commit")!!
            commit.executeUpdate()
        }
        Datos = listaDatos.toList()
        notifyItemRemoved(posicion)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPacientes {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card, parent, false)
        return ViewHolderPacientes(vista)    }


    override fun getItemCount() = Datos.size
    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolderPacientes, position: Int) {
        val producto = Datos[position]
        holder.txtViewPaciente.text = producto.Nombres_Paciente
        val item = Datos[position]
        holder.imgBorrar.setOnClickListener {

            //Creamos un alerta
            //Creamos el contexto
            val context = holder.itemView.context

            //Creo la alerta
            val builder = AlertDialog.Builder(context)

            //A mi alerta le pongo un titulo
            builder.setTitle("¿Estas seguro?")

            //Ponerle un mensaje
            builder.setMessage("¿Desea eliminar el Paciente?")

            //Paso final, agregamos los botones
            builder.setPositiveButton("SI") { dialog, wich ->
                eliminarRegistro(item.Nombres_Paciente, position)
            }

            builder.setNegativeButton("No"){dialog, wich ->
            }
            //Creamos la alerta
            val alertDialog = builder.create()
            //Mostramos la alerta
            alertDialog.show()
        }




    }
}