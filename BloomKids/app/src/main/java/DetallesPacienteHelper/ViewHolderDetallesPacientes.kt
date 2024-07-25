package DetallesPacienteHelper

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bryan.amaris.bloomkids.R

class ViewHolderDetallesPacientes (view: View) : RecyclerView.ViewHolder(view){
    val imgBorrar: ImageView = view.findViewById(R.id.imgBorrar)
    val txtViewPaciente: TextView = view.findViewById(R.id.txtPacienteDato)
    val imEditar: ImageView= view.findViewById(R.id.imgEditar)

}