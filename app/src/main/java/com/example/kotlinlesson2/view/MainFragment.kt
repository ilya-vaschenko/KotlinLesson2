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
import com.example.kotlinlesson2.databinding.MainFragmentBinding
import com.example.kotlinlesson2.viewmodel.AppState
import com.example.kotlinlesson2.viewmodel.LogEvent
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

    private val log = LogEvent()

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
        log.writeLog("onCreateView", context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmAdapter.listener =
            FilmAdapter.OnItemViewClickListener { film ->
                log.writeLog("Зашли посмотреть на фильм ${film.name}", context)

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

            log.writeLog("Нажали на кнопку, чтоб изменить страну", context)

            if (isRus) {
                binding.buttonLang.setImageResource(R.drawable.russ)
            } else {
                binding.buttonLang.setImageResource(R.drawable.euro)
            }
            viewModel.getFilmFromLocalSource(isRus)
        }

        button.setOnClickListener {
            log.writeLog("нажали на поиск фильмов", context)
            viewModel.liveData.observe(viewLifecycleOwner)
            { state ->
                renderData(state)
            }
            viewModel.getFilmFromLocalSource(isRus)
        }
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Loading -> binding.loadingLayout.show()

            is AppState.Success -> {
                binding.loadingLayout.hide()

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
                    { viewModel.getFilmFromLocalSource() }
                )

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}