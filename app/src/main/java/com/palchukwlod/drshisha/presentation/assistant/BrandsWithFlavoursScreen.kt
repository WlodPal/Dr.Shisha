package com.palchukwlod.drshisha.presentation.assistant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shishamixcompouse.presentation.ui.theme.LARGE

@Composable
fun BrandsWithFlavoursContent() {

    Scaffold {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(LARGE)) {

            Text(
                text = "Here will be text about BrandsWithFlavours"
            )

        }

    }

}