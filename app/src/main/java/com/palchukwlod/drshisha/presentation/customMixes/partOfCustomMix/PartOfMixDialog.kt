package com.palchukwlod.drshisha.presentation.customMixes.partOfCustomMix

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.shishamixcompouse.presentation.ui.theme.MEDIUM
import com.example.shishamixcompouse.presentation.ui.theme.SMALL
import com.palchukwlod.drshisha.presentation.customMixes.addingCustomMix.AddingCustomMixViewModel
import com.palchukwlod.drshisha.presentation.theme.fontFamily

@Composable
fun PartOfMixDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onConfirmedClicked: () -> Unit,
    addingCustomMixViewModel: AddingCustomMixViewModel
) {

    val startingValue = 0f
    var endValue by remember {
        mutableStateOf(100f)
    }


    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {

        Card(
            modifier = modifier
                .fillMaxWidth(0.95f),
            shape = RoundedCornerShape(15.dp),
        ) {

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(MEDIUM)
            ) {
                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(SMALL),
                    value = addingCustomMixViewModel.brandMame.value,
                    onValueChange = { addingCustomMixViewModel.brandMame.value = it },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Enter Brand Name",
                            fontFamily = fontFamily
                        )
                    }
                )

                Spacer(modifier = modifier.padding(top = 8.dp))

                OutlinedTextField(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(SMALL),
                    value = addingCustomMixViewModel.flavour.value,
                    onValueChange = { addingCustomMixViewModel.flavour.value = it },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Enter Your Flavour",
                            fontFamily = fontFamily
                        )
                    }
                )

                Spacer(modifier = modifier.height(5.dp))

                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "Choose Percentage: ${addingCustomMixViewModel.percentage.value}",
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )

                Spacer(modifier = modifier.height(5.dp))

                Slider(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    value = addingCustomMixViewModel.percentage.value.toFloat(),
                    onValueChange = {
                        addingCustomMixViewModel.percentage.value = it.toInt()
                    },
                    valueRange = startingValue..endValue,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Magenta,
                        activeTrackColor = Color.Cyan,
                        inactiveTrackColor = Color.Magenta.copy(alpha = 0.25f),
                    ),
                    steps = 3
                )


                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {


                    IconButton(
                        onClick = {
                            onConfirmedClicked()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Confirm",
                            tint = Color.Green
                        )
                    }

                    IconButton(
                        onClick = { onDismiss() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Cancel",
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }

}