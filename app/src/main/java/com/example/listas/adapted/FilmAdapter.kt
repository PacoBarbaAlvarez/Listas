package com.example.listas.adapted

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listas.Film
import com.example.listas.R

    class FilmAdapter(private var filmList:List<Film>): RecyclerView.Adapter<FilmViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return FilmViewHolder(layoutInflater.inflate(R.layout.item_film,parent,false))
        }

        override fun getItemCount(): Int {
            return filmList.size
        }

        override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
            val item = filmList[position]
            holder.render(item)
        }

        fun actualizarPelis(listapelis: List<Film>) {
            this.filmList = listapelis
            notifyDataSetChanged()
        }

    }
