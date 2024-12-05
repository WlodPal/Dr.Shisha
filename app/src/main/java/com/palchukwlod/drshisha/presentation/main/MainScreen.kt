package com.palchukwlod.drshisha.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.shishamixcompouse.util.AppBarState
import com.example.shishamixcompouse.util.RequestState
import com.palchukwlod.drshisha.data.entity.assistant.AssistantItems
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import com.palchukwlod.drshisha.navigation.AppNavGraph
import com.palchukwlod.drshisha.navigation.Screen
import com.palchukwlod.drshisha.navigation.rememberNavigationState
import com.palchukwlod.drshisha.presentation.assistant.AccessoriesContent
import com.palchukwlod.drshisha.presentation.assistant.BrandsWithFlavoursContent
import com.palchukwlod.drshisha.presentation.assistant.CharcoalContent
import com.palchukwlod.drshisha.presentation.assistant.heads.HeadsContent
import com.palchukwlod.drshisha.presentation.assistant.ListOfAssistantContent
import com.palchukwlod.drshisha.presentation.assistant.ShishaContent
import com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix.AddShishaMixContent
import com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix.AddingCustomMixViewModel
import com.palchukwlod.drshisha.presentation.customMixes.listOfMixes.ListOfMixesScreenContent
import com.palchukwlod.drshisha.presentation.customMixes.listOfMixes.ListOfMixesViewModel
import com.palchukwlod.drshisha.presentation.customMixes.partOfCustomMix.PartOfMixCard


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    listOfMixesViewModel: ListOfMixesViewModel,
    addingCustomMixViewModel: AddingCustomMixViewModel
) {

    val mixName: String by addingCustomMixViewModel.mixName
    val description: String by addingCustomMixViewModel.description
    val levelOfStrong: LevelOfStrong by addingCustomMixViewModel.levelOfStrong

    val navigationState = rememberNavigationState()
    val appBarState: AppBarState by listOfMixesViewModel.appBarState
    val searchTextState: String by listOfMixesViewModel.searchTextState
    val allMixes = listOfMixesViewModel.allCustomMixes.collectAsState()

    LaunchedEffect(key1 = true) {
        listOfMixesViewModel.getAllCustomMixes()
    }


    Scaffold(

        bottomBar = {
            BottomNavigationItems(navigationState = navigationState)
        }
    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            exploreMixesContent = {

            },
            customMixesContent = {
                ListOfMixesScreenContent(
                    customMixes = allMixes.value,
                    listOfMixesViewModel = listOfMixesViewModel,
                    appBarState = appBarState,
                    searchTextState = searchTextState,
                    navigationState = navigationState,
                    onShishaMixClicked = {}
                )
            },
            assistantContent = {
                ListOfAssistantContent {
                    when (it.listName) {
                        AssistantItems.BRANDS_WITH_FLAVOURS.listName -> {
                            navigationState.navigateToWithBackStack(Screen.BrandsWithFlavours.route)
                        }

                        AssistantItems.HEADS.listName -> {
                            navigationState.navigateToWithBackStack(Screen.Heads.route)
                        }

                        AssistantItems.SHISHA.listName -> {
                            navigationState.navigateToWithBackStack(Screen.Shisha.route)
                        }

                        AssistantItems.CHARCOAL.listName -> {
                            navigationState.navigateToWithBackStack(Screen.Charcoal.route)
                        }

                        AssistantItems.ACCESSORIES.listName -> {
                            navigationState.navigateToWithBackStack(Screen.Accessories.route)
                        }
                    }
                }
            },
            addPartOfMixContent = {

            },
            addingMixesContent = {
                AddShishaMixContent(
                    mixName = mixName,
                    onMixNameChange = {
                        addingCustomMixViewModel.mixName.value = it
                    },
                    description = description,
                    onDescriptionChange = {
                        addingCustomMixViewModel.description.value = it
                    },
                    levelOfStrong = levelOfStrong,
                    onLevelOfStrongSelected = {
                        addingCustomMixViewModel.levelOfStrong.value = it
                    },
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()
                    },
                    onSavedClicked = {
                        addingCustomMixViewModel.addCustomMix()
                        navigationState.navigateTo(Screen.ListCustomMixes.route)
                        addingCustomMixViewModel.mixName.value = ""
                        addingCustomMixViewModel.description.value = ""
                    },
                    onChooseLevelOfStrong = {
                        addingCustomMixViewModel.levelOfStrong.value = it
                    },
                    onAddPartOfMixClicked = {
                        navigationState.navigateToWithBackStack(Screen.AddPartOfMix.route)
                    },
                    addingCustomMixViewModel = addingCustomMixViewModel
                )
            },
            accessoriesContent = { AccessoriesContent() },
            brandsWithFlavoursContent = { BrandsWithFlavoursContent() },
            charcoalContent = { CharcoalContent() },
            shishaContent = { ShishaContent() },
            headsContent = { HeadsContent() }
        )
    }


}