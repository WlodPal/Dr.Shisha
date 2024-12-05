package com.palchukwlod.drshisha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    exploreMixesContent: @Composable () -> Unit,
    customMixesContent: @Composable () -> Unit,
    assistantContent: @Composable () -> Unit,
    addingMixesContent: @Composable () -> Unit,
    addPartOfMixContent: @Composable () -> Unit,
    brandsWithFlavoursContent: @Composable () -> Unit,
    headsContent: @Composable () -> Unit,
    shishaContent: @Composable () -> Unit,
    charcoalContent: @Composable () -> Unit,
    accessoriesContent: @Composable () -> Unit

    ) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ExploreMixes.route
    ) {


        composable(Screen.ExploreMixes.route) {
            exploreMixesContent()
        }

        customMixesScreenNavGraph(
            customMixesContent = customMixesContent,
            addingMixesContent = addingMixesContent,
            addPartOfMixContent = addPartOfMixContent

        )

        assistantScreenNavGraph(
            assistantListContent = assistantContent,
            brandsWithFlavoursContent = brandsWithFlavoursContent,
            headsContent = headsContent,
            shishaContent = shishaContent,
            charcoalContent = charcoalContent,
            accessoriesContent = accessoriesContent
        )

//        composable(Screen.Assistant.route) {
//            assistantContent()
//        }


//        composable(Screen.AddingMixes.route){
//            addingMixesContent()
//
//        }
//        composable(Screen.PrerecordedMixes.route){
//            prerecordedMixesContent()
//        }
//
//        composable(Screen.AddPartOfMix.route) {
//            addPartOfMixContent()
//        }
    }
}