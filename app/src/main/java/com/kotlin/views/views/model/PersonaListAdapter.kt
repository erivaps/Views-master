package com.kotlin.views.views.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.kotlin.views.views.R
import kotlinx.android.synthetic.main.activity_card_view.view.*

class PersonaListAdapter(private val list: ArrayList<Persona>,
                         private val context: Context):
    RecyclerView.Adapter<PersonaListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_card_view,
                parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(persona: Persona){
            var nombres = itemView.findViewById(R.id.txtNombres) as TextView
            var apellidos = itemView.findViewById(R.id.txtApellidos) as TextView
            nombres.setText(persona.nombres)
            apellidos.setText(persona.apellidos)

            itemView.setOnClickListener{
                Toast.makeText(context, nombres.text, Toast.LENGTH_LONG).show()
            }
        }
    }


}