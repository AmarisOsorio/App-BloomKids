package DetallesPacienteHelper

import Modelo.DetallesPaciente
import androidx.recyclerview.widget.RecyclerView

abstract class DetallesPacientesAdaptador (private  var Datos: List<DetallesPaciente>): RecyclerView.Adapter<ViewHolderDetallesPacientes>(){

    /*fun ActualizarListaDespuesDeActualizarDatos(UUID_Paciente: String, NuevoNombrePaciente: String){
        val index = Datos.indexOfFirst { it.UUID_PACIENTE == UUID_Paciente }
        Datos[index].Nombres_Paciente = NuevoNombrePaciente

        notifyItemChanged(index)
    }*/

}