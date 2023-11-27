package com.example.listas
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

open class ActivityWithMenus: AppCompatActivity() {

    companion object{
        var actividadActual = 0;

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Relacionamos la clas con el layout del menu que hemos creado

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_pelis, menu)

        for(i in 0  until  menu.size()){

            if(i== actividadActual)menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.peliculas -> {
                actividadActual = 0;
                //Hacemos que se abra la pantalla del listado de pelis:
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.editar -> {
                actividadActual = 1;
                val intent = Intent(this, Editar_pelicula::class.java)
                startActivity(intent)
                true
            }

            R.id.app -> {
                actividadActual = 2;
                val intent = Intent(this, Info::class.java)
                startActivity(intent)
                true
            }

            R.id.buscar ->{
                actividadActual = 3;
                if (R.id.Filtro== View.VISIBLE) {
                    R.id.Filtro= View.INVISIBLE
                } else {
                    R.id.Filtro = View.VISIBLE
                }
                true
            }
            R.id.salir ->{
                actividadActual = 4;
                //Hacemos que al seleccionar exit, nos muestre un mensaje de si quermos salir de la app o no
                var miDialogo = AlertDialog.Builder(this)
                AlertDialog.Builder(this)
                    .setTitle("Salir")
                    .setMessage("¿Desea Salir de la Aplicacion?")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        finish()
                    })
                    .setNegativeButton(android.R.string.cancel,  { dialog, which ->
                    })
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}