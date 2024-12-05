package com.palchukwlod.drshisha.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix.AddingCustomMixViewModel
import com.palchukwlod.drshisha.presentation.customMixes.listOfMixes.ListOfMixesViewModel
import com.palchukwlod.drshisha.presentation.theme.DrShishaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val listOfMixesViewModel: ListOfMixesViewModel by viewModels()
    private val addingCustomMixViewModel: AddingCustomMixViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrShishaTheme {
                MainScreen(
                    listOfMixesViewModel =  listOfMixesViewModel,
                    addingCustomMixViewModel = addingCustomMixViewModel
                )

            }
        }
    }
}
