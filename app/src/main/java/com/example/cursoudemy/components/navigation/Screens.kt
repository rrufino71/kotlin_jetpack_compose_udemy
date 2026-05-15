package com.example.cursoudemy.components.navigation

import com.example.cursoudemy.components.navigation.examples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

//esto es lo mismo que lo anterior
//solo que si pasamos parametros (solo primitivos)
//la screen se define como un data class
@Serializable
data class Detail(val id:String)

@Serializable
data class Settings(val settingModel: SettingModel)