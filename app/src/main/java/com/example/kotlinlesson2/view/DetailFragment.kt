package com.example.kotlinlesson2.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.DetailFragmentBinding
import com.example.kotlinlesson2.modl.Film

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
                with(binding) {
                    detailDate.text = film.date.toString()
                    detailName.text = film.name
                    detailGenre.text = film.genre
                    description.text = film.description
                    detailImg.setImageResource(film.imageIndex)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}