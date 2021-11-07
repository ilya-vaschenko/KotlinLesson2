package com.example.kotlinlesson2.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.DetailFragmentBinding
import com.example.kotlinlesson2.databinding.MainFragmentBinding
import com.example.kotlinlesson2.modl.Film
import com.example.kotlinlesson2.modl.Repository
import com.example.kotlinlesson2.modl.RepositoryImpl
import com.example.kotlinlesson2.viewmodel.AppState
import com.example.kotlinlesson2.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*

class DetailFragment : Fragment() {

    companion object {
        const val FILM_EXTRA = "FILM_EXTRA"

        fun newInstance(bundle: Bundle): DetailFragment{
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val filmAdapter: FilmAdapter by lazy {
        FilmAdapter()
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

        val film = arguments?.getParcelable<Film>(FILM_EXTRA)

        if(film != null){
            binding.detailDate.text = film.date.toString()
            binding.detailName.text = film.name
            binding.detailGenre.text = film.genre
            binding.detailDescription.text = film.description
            binding.detailImg.setImageResource(film.imageIndex)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}