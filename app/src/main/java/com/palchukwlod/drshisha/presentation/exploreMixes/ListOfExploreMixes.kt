package com.palchukwlod.drshisha.presentation.exploreMixes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.palchukwlod.drshisha.presentation.customMixes.CustomMixesAppBar

@Composable
fun ListOfExploreMixesScreen(

) {

    Scaffold(
        topBar = {
            CustomMixesAppBar()
        },


        ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {



        }



    }
}