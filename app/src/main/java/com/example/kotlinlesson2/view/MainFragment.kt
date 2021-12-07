package com.example.kotlinlesson2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.MainFragmentBinding
import com.example.kotlinlesson2.viewmodel.AppState
import com.example.kotlinlesson2.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val filmAdapter: FilmAdapter by lazy {
        FilmAdapter()
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private var isRus: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.main_fragment, container,
            false
        )

        _binding = MainFragmentBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmAdapter.listener =
            FilmAdapter.OnItemViewClickListener { film ->
                activity?.supportFragmentManager?.let {
                    it.beginTransaction()
                        .replace(R.id.container, DetailFragment.newInstance(Bundle().apply {
                            putParcelable(
                                DetailFragment.FILM_EXTRA,
                                film
                            )
                        }))
                        .addToBackStack("")
                        .commit()
                }
            }

        binding.buttonLang.setOnClickListener {
            isRus = !isRus
            if (isRus) {
                binding.buttonLang.setImageResource(R.drawable.russ)
            } else {
                binding.buttonLang.setImageResource(R.drawable.euro)
            }
            viewModel.getFilmFromRemoteDataSource()
        }

        button.setOnClickListener {
            viewModel.liveData.observe(viewLifecycleOwner)
            { state ->
                Log.d("fff", "$state")

                renderData(state)
            }
            viewModel.getFilmFromRemoteDataSource()
        }
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Loading -> {
                Log.d("fff", "loading")
                binding.loadingLayout.show()
            }

            is AppState.Success -> {
                binding.loadingLayout.hide()
                Log.d("fff", "success")

                filmAdapter.filmList = state.filmsList

                filmAdapter.let {
                    val layoutManager = LinearLayoutManager(view?.context)
                    recycler_view_lines.layoutManager =
                        layoutManager
                    recycler_view_lines.adapter = it
                    recycler_view_lines.addItemDecoration(
                        DividerItemDecoration(
                            view?.context,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                    it.notifyDataSetChanged()
                }
            }
            is AppState.Error -> {
                binding.loadingLayout.hide()
                binding.FABButton.showSnackBar(
                    "ERROR",
                    "Reload",
                    { viewModel.getFilmFromRemoteDataSource() }
                )

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}