package com.example.kotlinlesson2.view

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.kotlinlesson2.R
import com.example.kotlinlesson2.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    private val permissionResult =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            when {
                result -> getLocation()

                !ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) -> {

                    AlertDialog.Builder(this)
                        .setTitle("Доступ к геолокации")

                        .setMessage(
                            "Вы запретили доступ к геолокации! \n" +
                            "Ваше местоположение не ннайдено!\n" +
                            "Открыть доступ?"
                        )

                        .setPositiveButton("Открыть настройки") { _, _ ->
                            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)

                            val uri: Uri = Uri.fromParts("package", packageName, null)
                            intent.data = uri
                            startActivity(intent)
                        }
                        .setNegativeButton("Нет") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()

                }
                else -> Toast.makeText(this, "No access to permission", Toast.LENGTH_LONG).show()
            }
        }

    private fun getLocation() {

        AlertDialog.Builder(this)
            .setTitle("Геолокация открыта")

            .setMessage("Ваше местонахождение найдено \n")

            .setNegativeButton("ok!") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idHistory -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, HistoryFragment())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            R.id.getGeoPosition -> {
                permissionResult.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}