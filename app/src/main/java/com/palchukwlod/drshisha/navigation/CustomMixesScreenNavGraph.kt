package com.palchukwlod.drshisha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.customMixesScreenNavGraph(
    customMixesContent: @Composable () -> Unit,
    addingMixesContent: @Composable () -> Unit,
    addPartOfMixContent: @Composable () -> Unit,
) {

    navigation(
        startDestination = Screen.ListCustomMixes.route,
        route = Screen.CustomMixes.route
    ) {

        composable(Screen.ListCustomMixes.route){
            customMixesContent()
        }

        composable(Screen.AddingMixes.route) {
            addingMixesContent()
        }

        composable(Screen.AddPartOfMix.route) {
            addPartOfMixContent()
        }



//        composable(
//            route = Screen.InfoCustomMix.route,
//            arguments = listOf(
//                navArgument(Screen.KEY_SHISHA_MIX){
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            val shishaMixJson = it.arguments?.getString(Screen.KEY_SHISHA_MIX) ?: ""
//            val shishaMix = Gson().fromJson(shishaMixJson, ShishaMix::class.java)
//            infoCustomMixContent(shishaMix)
//        }
    }
}