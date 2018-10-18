package com.kotlin.views.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.kotlin.views.views.model.Persona
import com.kotlin.views.views.model.PersonaListAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private var adapter: PersonaListAdapter?=null
    private var personaList: ArrayList<Persona>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        personaList = ArrayList<Persona>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonaListAdapter(personaList!!, this)

        rcView.layoutManager = layoutManager
        rcView.adapter = adapter

        var nombreList: Array<String> = arrayOf("Sting", "Christian", "Jose",
                "Wildor", "Davis", "Eslis", "Erison",
                "Giancarlo", "Miguel")

        var apellidoList: Array<String> = arrayOf("Lucana", "Vela", "Paucar", "Mostacero",
                "Acuña", "Aquino", "Mostacero", "Barreto", "Vasquez")

        for(i in 0..nombreList.size - 1){
            var persona = Persona()
            persona.nombres = nombreList[i]
            persona.apellidos = apellidoList[i]
            personaList?.add(persona)
        }

        adapter!!.notifyDataSetChanged()
    }


}
