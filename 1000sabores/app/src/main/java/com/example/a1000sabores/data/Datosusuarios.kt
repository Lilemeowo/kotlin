package com.example.a1000sabores.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore(name = "1000sabores-datos")

object Keys {
    val NOMBRE_USUARIO = stringPreferencesKey("nombre")
    val EMAIL_USUARIO = stringPreferencesKey("email_usuario")
    val DIRECCION_USUARIO = stringPreferencesKey("direccion_usuario")
    val CARRITO_IDS = stringPreferencesKey("carrito_ids")
    val ORDENES = stringPreferencesKey("ordenes_csv")
}

class DatosUsuario(private val context: Context) {

    val nombreUsuario: Flow<String> =
        context.dataStore.data.map { prefs -> prefs[Keys.NOMBRE_USUARIO] ?: "" }

    val emailUsuario: Flow<String> =
        context.dataStore.data.map { prefs -> prefs[Keys.EMAIL_USUARIO] ?: "" }

    val direccionUsuario: Flow<String> =
        context.dataStore.data.map { prefs -> prefs[Keys.DIRECCION_USUARIO] ?: "" }

    val carritoIds: Flow<String> =
        context.dataStore.data.map { prefs -> prefs[Keys.CARRITO_IDS] ?: "" }

    val ordenesCsv: Flow<String> =
        context.dataStore.data.map { prefs -> prefs[Keys.ORDENES] ?: "" }

    suspend fun guardarUsuario(nombre: String, email: String, direccion: String) {
        context.dataStore.edit { prefs ->
            prefs[Keys.NOMBRE_USUARIO] = nombre
            prefs[Keys.EMAIL_USUARIO] = email
            prefs[Keys.DIRECCION_USUARIO] = direccion
        }
    }

    suspend fun guardarCarrito(carritoIds: String) {
        context.dataStore.edit { prefs ->
            prefs[Keys.CARRITO_IDS] = carritoIds
        }
    }

    suspend fun agregarOrden(linea: String) {
        context.dataStore.edit { prefs ->
            val actual = prefs[Keys.ORDENES] ?: ""
            val nuevo = if (actual.isBlank()) linea else "$actual||$linea"
            prefs[Keys.ORDENES] = nuevo
        }
    }
}
