package com.example.kotlinlesson2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.model.Film
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    var filmList: List<Film> = ArrayList()

    var listener: OnItemViewClickListener? = null

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(film: Film) {
            itemView.apply {
                title.text = film.name
                genre.text = film.genre
                date.text = film.date.toString()
                imageView.setImageResource(film.imageIndex)
                setOnClickListener {
                    listener?.onItemClick(film)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int = filmList.size

    internal fun setFilmList(filmList: List<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
    }

    fun interface OnItemViewClickListener {
        fun onItemClick(film: Film)
    }
}