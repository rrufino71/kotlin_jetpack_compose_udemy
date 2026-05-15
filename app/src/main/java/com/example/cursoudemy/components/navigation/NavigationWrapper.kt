package com.example.cursoudemy.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cursoudemy.components.navigation.examples.DetailScreen
import com.example.cursoudemy.components.navigation.examples.HomeScreen
import com.example.cursoudemy.components.navigation.examples.LoginScreen
import com.example.cursoudemy.components.navigation.examples.SettingScreen
import com.example.cursoudemy.components.navigation.examples.model.SettingModel
import com.example.cursoudemy.components.navigation.types.settingsModelType
import kotlin.reflect.typeOf

@Composable
fun  NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Login) {
       composable<Login> {
           LoginScreen(navigateToDetail = {navController.navigate(Home)})
       }
       composable<Home> {
           HomeScreen(
               navigateBack = {navController.popBackStack()},
               navigateToDetail = {id -> navController.navigate(Detail(id = id))}
           )
       }

       //recibimos los parametros en navBackStackEntry
       //solo tipos primitivos
       composable<Detail> {
           navBackStackEntry ->
           val detail: Detail = navBackStackEntry.toRoute()
           DetailScreen(id=detail.id, navigateToSettings = {navController.navigate(Settings(it))})
       }

       composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to settingsModelType)) {
           navBackStackEntry ->
           val setting:Settings = navBackStackEntry.toRoute<Settings>()
           SettingScreen(setting.settingModel)
       }

    }
}