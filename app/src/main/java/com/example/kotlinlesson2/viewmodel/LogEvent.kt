package com.example.kotlinlesson2.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.kotlinlesson2.services.LogsIntentService

private const val SERVICE_EXTRA = "MESSAGE_FOR_SERVICE"

class LogEvent {

    fun writeLog(messageToService: String, context: Context?) {

        val intent = Intent(context, LogsIntentService::class.java)
        intent.putExtra(SERVICE_EXTRA, messageToService)

        Log.d("fff", "intetn to service ${messageToService}")

        context?.startService(intent)
    }
}