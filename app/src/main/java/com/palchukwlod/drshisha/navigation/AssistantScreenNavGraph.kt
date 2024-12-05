package com.palchukwlod.drshisha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.assistantScreenNavGraph(
    assistantListContent: @Composable () -> Unit,
    brandsWithFlavoursContent: @Composable () -> Unit,
    headsContent: @Composable () -> Unit,
    shishaContent: @Composable () -> Unit,
    charcoalContent: @Composable () -> Unit,
    accessoriesContent: @Composable () -> Unit
) {

    navigation(
        startDestination = Screen.Assistant.route,
        route = Screen.ListOfAssistant.route
    ){

        composable(Screen.Assistant.route){
            assistantListContent()
        }
        composable(Screen.BrandsWithFlavours.route){
            brandsWithFlavoursContent()
        }
        composable(Screen.Heads.route){
            headsContent()
        }
        composable(Screen.Shisha.route){
            shishaContent()
        }
        composable(Screen.Charcoal.route){
            charcoalContent()
        }
        composable(Screen.Accessories.route){
            accessoriesContent()
        }


    }

}