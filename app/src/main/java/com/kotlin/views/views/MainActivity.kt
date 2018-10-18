package com.kotlin.views.views

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombres: Array<String> = arrayOf("Sting", "Christian", "Jose",
                "Wildor", "Davis", "Eslis", "Erison",
                "Giancarlo", "Miguel")

        var nombreAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombres)

        lstNombres.adapter = nombreAdapter
    }

    fun verDetalle(view: View){
        var myIntent = Intent(this, RecyclerActivity::class.java)
        startActivity(myIntent)
    }

    fun mostrarInformacion(view: View){
        var mostrarAlert = AlertDialog.Builder(this)
        mostrarAlert.setTitle("Alerta")
        mostrarAlert.setMessage("¿Esta seguro que no desea asistir a clase mañana?")

        mostrarAlert.setPositiveButton("Si"){
            dialog: DialogInterface?, i: Int ->  Toast.makeText(applicationContext,
                "Usted no desea asistir", Toast.LENGTH_SHORT).show()
        }

        mostrarAlert.setNegativeButton("No"){
            dialog: DialogInterface?, i: Int ->  Toast.makeText(applicationContext,
                "Usted si desea asistir", Toast.LENGTH_SHORT).show()
        }

        mostrarAlert.setNeutralButton("Recuerdame Luego"){
            dialog: DialogInterface?, i: Int ->  Toast.makeText(applicationContext,
                "Recordar.. Recordar", Toast.LENGTH_SHORT).show()
        }

        mostrarAlert.show()
    }
}
