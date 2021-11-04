 package com.example.kotlinlesson2.view

 import androidx.appcompat.app.AppCompatActivity
 import android.os.Bundle
 import com.example.kotlinlesson2.R


 class MainActivity : AppCompatActivity() {



     private  val binding: MainActivityBinding by lazy {
         MainActivityBinding.inflate(layoutInflater) }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         binding = MainActivityBinding.inflate(layoutInflater)
         setContentView(binding.root)
         if (savedInstanceState == null) {
             supportFragmentManager.beginTransaction()
                 .replace(R.id.container, MainFragment.newInstance())
                 .commitNow()
         }
     }
 }