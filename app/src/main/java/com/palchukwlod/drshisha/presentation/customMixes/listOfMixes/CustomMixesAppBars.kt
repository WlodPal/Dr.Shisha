package com.palchukwlod.drshisha.presentation.customMixes.listOfMixes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.example.shishamixcompouse.presentation.ui.theme.TOP_APP_BAR_PADDING
import com.example.shishamixcompouse.util.AppBarState
import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.components.LevelOfStrongItem
import com.palchukwlod.drshisha.data.entity.customMix.LevelOfStrong
import com.palchukwlod.drshisha.presentation.theme.fontFamily
import com.palchukwlod.drshisha.utils.TrailingIconState

@Composable
fun CustomMixAppBar(
    appBarState: AppBarState,
    searchTextState: String,
    listOfMixesViewModel: ListOfMixesViewModel
) {
    when (appBarState) {
        AppBarState.CLOSED -> {
            DefaultMixAppBar(
                onSearchClicked = {
                    listOfMixesViewModel.appBarState.value = AppBarState.OPENED
                },
                onSortClicked = {}
            )
        }
        else -> {
            SearchMixesAppBar(
                searchText = searchTextState,
                onTextChange = {
                    listOfMixesViewModel.searchTextState.value = it
                },
                onCloseClicked = {
                    listOfMixesViewModel.appBarState.value = AppBarState.CLOSED
                    listOfMixesViewModel.searchTextState.value = ""
                },
                onSearchMixClicked = {}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultMixAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (LevelOfStrong) -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = fontFamily
            )
        },
        actions = {
            MixAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Composable
fun MixAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (LevelOfStrong) -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = { onSearchClicked() }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (LevelOfStrong) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription = stringResource(R.string.sort_mixes),
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                text = { LevelOfStrongItem(levelOfStrong = LevelOfStrong.LIGHT) },
                onClick = {
                    expanded = false
                    onSortClicked(LevelOfStrong.LIGHT)
                }
            )
            DropdownMenuItem(
                text = { LevelOfStrongItem(levelOfStrong = LevelOfStrong.MEDIUM) },
                onClick = {
                    expanded = false
                    onSortClicked(LevelOfStrong.MEDIUM)
                }
            )
            DropdownMenuItem(
                text = { LevelOfStrongItem(levelOfStrong = LevelOfStrong.STRONG) },
                onClick = {
                    expanded = false
                    onSortClicked(LevelOfStrong.STRONG)
                }
            )
        }
    }
}


@Composable
fun SearchMixesAppBar(
    searchText: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchMixClicked: (String) -> Unit
) {
    var trailingIconState by remember { mutableStateOf(TrailingIconState.READY_TO_DELETE) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_PADDING),
        color = Color.Transparent
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchText,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Start
                )
            },
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimary),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_action),
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        when (trailingIconState) {
                            TrailingIconState.READY_TO_DELETE -> {
                                onTextChange("")
                                trailingIconState = TrailingIconState.READY_TO_CLOSE
                            }
                            TrailingIconState.READY_TO_CLOSE -> {
                                if (searchText.isNotEmpty()) {
                                    onTextChange("")
                                } else {
                                    onCloseClicked()
                                    trailingIconState = TrailingIconState.READY_TO_DELETE
                                }
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_search_button),
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearchMixClicked(searchText) }),

        )
    }
}
