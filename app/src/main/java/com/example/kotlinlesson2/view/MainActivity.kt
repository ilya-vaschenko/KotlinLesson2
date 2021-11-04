package com.example.kotlinlesson2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {


    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}