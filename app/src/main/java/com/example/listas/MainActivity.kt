package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapted.FilmAdapter
import com.example.listas.databinding.ActivityMainBinding
import androidx.core.widget.addTextChangedListener

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("ListadoPelis")
        //setContentView(R.layout.activity_main)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FilmProvider.filmList[2].title

        //binding.recicler.layoutManager = GridLayoutManager(this, 2)
        binding.recicler.layoutManager = LinearLayoutManager(this)
        var adapter = FilmAdapter(FilmProvider.filmList)
        binding.recicler.adapter=adapter

        binding.Filtro.addTextChangedListener {filtro ->
            val filtroPeli = FilmProvider.filmList.filter { Film ->
                Film.title.lowercase().contains(filtro.toString().lowercase())  }
            adapter.actualizarPelis(filtroPeli)

        }
        //binding.recicler.addItemDecoration(decoration)
    }
}