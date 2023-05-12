package com.example.imageslogger.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imageslogger.ImagesViewModel


@Composable
fun NavGraph(navController: NavHostController, viewModel: ImagesViewModel){

    NavHost(navController = navController,
        startDestination = "home_page" )
    {
        composable(
            route = "home_page"
        ){
            HomePage(navController = navController, viewModel = viewModel)
        }
        composable(
            route = "images_page"
        ){
            ImagesPage(navController = navController, viewModel = viewModel)
        }

    }

}