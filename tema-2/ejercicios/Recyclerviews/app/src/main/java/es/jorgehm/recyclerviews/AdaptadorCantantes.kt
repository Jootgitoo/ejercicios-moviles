package es.jorgehm.recyclerviews

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.color
import androidx.recyclerview.widget.RecyclerView


class AdaptadorCantantes(private val cantantes: ArrayList<String>) : RecyclerView.Adapter<CantanteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CantanteViewHolder {
        // Inflamos el layout de cada elemento
        val layoutInflater = LayoutInflater.from(parent.context)
        return CantanteViewHolder(layoutInflater.inflate(R.layout.activity_item_cantante, parent, false))
    }
    override fun onBindViewHolder(holder: CantanteViewHolder, position: Int) {
        // Inicializamos la lista de cantantes
        val cantante = cantantes[position]
        holder.textView.text = cantante

        // Al hacer clic, el fondo del ítem cambia de color
        holder.itemView.setOnClickListener {
            if (holder.isBackgroundColorChanged) {
                holder.itemView.setBackgroundColor(Color.TRANSPARENT) // Or your default color
                holder.isBackgroundColorChanged = false
            } else {
                holder.itemView.setBackgroundColor(Color.LTGRAY)
                holder.isBackgroundColorChanged = true
            }
        }

        // Al dejar pulsado, se elimina el ítem de la lista
        holder.itemView.setOnLongClickListener {
            cantantes.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cantantes.size)
            true
        }
    }
    override fun getItemCount(): Int {
        return cantantes.size
    }

}

