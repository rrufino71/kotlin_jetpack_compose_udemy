package com.example.cursoudemy.components.navigation.types

import android.net.Uri
import android.os.Build
import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.cursoudemy.components.navigation.examples.model.SettingModel
import kotlinx.serialization.json.Json

//inline es una funcion generica
//reified significa que la funcion se genera en tiempo de
//ejecucion no en tiempo de compilacion

inline fun <reified T: Parcelable> createNavType(): NavType<T> {
    return object: NavType<T>(isNullableAllowed = true){

        override fun put(bundle: SavedState, key: String, value: T) {
            bundle.putParcelable(key,value)
        }

        override fun get(bundle: SavedState, key: String ): T? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key,T::class.java)
            }else{
                bundle.getParcelable(key)
            }
        }

        //este metodo recibe un string y convierte al modelo de datos
        override fun parseValue(value: String): T {
            return Json.decodeFromString<T>(value)
        }

        //este metodo recibe un modelo y lo convierte a string
        override fun serializeAsValue(value: T): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}