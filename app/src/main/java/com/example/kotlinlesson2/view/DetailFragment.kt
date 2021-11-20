package com.example.kotlinlesson2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.DetailFragmentBinding
import com.example.kotlinlesson2.model.Film
import com.example.kotlinlesson2.model.FilmDTO
import com.example.kotlinlesson2.model.FilmLoader
import java.lang.StringBuilder

class DetailFragment : Fragment() {

    companion object {
        const val FILM_EXTRA = "FILM_EXTRA"

        fun newInstance(bundle: Bundle): DetailFragment {
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)

        _binding = DetailFragmentBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(FILM_EXTRA)
            ?.let { film ->

                FilmLoader(film.id, object : FilmLoader.FilmLoaderListener {
                    override fun onLoaded(filmDTO: FilmDTO) {
                        requireActivity().runOnUiThread { //так как мы не можем рисовать не из основного потока, переходим в основной
                            displayFilm(filmDTO)
                        }
                    }

                    override fun onFailed(throwable: Throwable) {
                        requireActivity().runOnUiThread {
                            Toast.makeText(
                                requireContext(),
                                throwable.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }

                }).goToInternet()

            }
    }

    private fun displayFilm(film: FilmDTO) {

        with(binding) {
            detailDate.text = film.release_date.toString()
            detailName.text = film.title
            detailGenre.text = getGenres(film.genres)
            description.text = film.overview
            // detailImg.setImageResource(film.imageIndex)
        }
    }

    private fun getGenres(genres: List<FilmDTO.GenresDTO?>): String {
        val genresString = StringBuilder()
        genres.forEach {
            genresString.append("${it?.name}, ") // добавить
        }
        return genresString.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}