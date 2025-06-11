package com.andrea_murillo.involucrate.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("involucrate_prefs", Context.MODE_PRIVATE)

    fun saveSession(userId: Long, esOng: Boolean) {
        prefs.edit().apply {
            putLong("usuario_id", userId)
            putBoolean("es_ong", esOng)
            apply()
        }
    }

    fun getUserId(): Long = prefs.getLong("usuario_id", -1)
    fun isOng(): Boolean = prefs.getBoolean("es_ong", false)
    fun clearSession() = prefs.edit().clear().apply()
}
