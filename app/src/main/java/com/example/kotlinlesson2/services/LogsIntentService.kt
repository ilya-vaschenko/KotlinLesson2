package com.example.kotlinlesson2.services

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.io.File

private const val SERVICE_EXTRA = "MESSAGE_FOR_SERVICE"

class LogsIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
        Log.d("fff", "onCreate service")
    }

    override fun onHandleIntent(intent: Intent?) {
        val message = intent?.getStringExtra(SERVICE_EXTRA)

        createFile(message)

    }

    private fun write(message: String?, path: String) {
        Log.d("fff", message.toString())

        File(path).appendText("${message.toString()}\n")
    }

    private fun createFile(message: String?) {
        val path = this.externalMediaDirs.firstOrNull()?.absolutePath + "/"
        val name = "Logs.txt"

        val file = File(path + name)
        file.parentFile?.mkdirs()
        file.createNewFile()
        write(message, path + name)
    }
}