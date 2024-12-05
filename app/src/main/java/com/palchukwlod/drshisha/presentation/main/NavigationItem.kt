package com.palchukwlod.drshisha.presentation.main

import com.palchukwlod.drshisha.R
import com.palchukwlod.drshisha.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: Int,
    val contentDescription: Int
) {

    object ExploreMixes : NavigationItem(
        screen = Screen.ExploreMixes,
        titleResId = R.string.explore_mixes,
        icon = R.drawable.explore_icon,
        contentDescription = R.string.explore_mixes
    )

    object CustomMixes: NavigationItem(
        screen = Screen.ListCustomMixes,
        titleResId = R.string.custom_mixes,
        icon = R.drawable.slideshow_line_icon,
        contentDescription = R.string.custom_mixes
    )

    object Assistant: NavigationItem(
        screen = Screen.Assistant,
        titleResId = R.string.assistant,
        icon = R.drawable.person_icon,
        contentDescription = R.string.assistant
    )


}