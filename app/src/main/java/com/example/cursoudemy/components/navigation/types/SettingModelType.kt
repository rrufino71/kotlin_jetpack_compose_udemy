package com.example.cursoudemy.components.navigation.types

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.cursoudemy.components.navigation.examples.model.SettingModel
import kotlinx.serialization.json.Json

//esto se utiliza porque el sistema al pasar por parametro
// el modelo lo convierte en string y luego denuevo en objeto

val settingsModelType = object : NavType<SettingModel>(isNullableAllowed = true) {

    override fun put(bundle: SavedState, key: String, value: SettingModel) {
        bundle.putParcelable(key,value)
    }

    override fun get(bundle: SavedState, key: String ): SettingModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key,SettingModel::class.java)
        }else{
            bundle.getParcelable(key)
        }
    }

    //este metodo recibe un string y convierte al modelo de datos
    override fun parseValue(value: String): SettingModel {
        return Json.decodeFromString<SettingModel>(value)
    }

    //este metodo recibe un modelo y lo convierte a string
    override fun serializeAsValue(value: SettingModel): String {
        return Uri.encode(Json.encodeToString(value))
    }


}