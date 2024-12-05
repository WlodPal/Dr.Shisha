package com.palchukwlod.drshisha.presentation.main


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shishamixcompouse.presentation.ui.theme.BOTTOM_CLIP_SIZE
import com.example.shishamixcompouse.presentation.ui.theme.BOTTOM_ICON_SIZE
import com.palchukwlod.drshisha.navigation.NavigationState
import com.palchukwlod.drshisha.presentation.theme.fontFamily
import com.palchukwlod.drshisha.utils.Constants.SINGLE_LINE

@Composable
fun BottomNavigationItems(
    navigationState: NavigationState
) {

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(BOTTOM_CLIP_SIZE)),


    ) {

        val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

        val items = listOf(
            NavigationItem.ExploreMixes,
            NavigationItem.CustomMixes,
            NavigationItem.Assistant
        )

        items.forEach { item->

            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false

            NavigationBarItem(
                selected = selected,
                onClick = { if (!selected) {
                    navigationState.navigateTo(route = item.screen.route)
                } },
                icon = {
                    Icon(
                        modifier = Modifier.size(BOTTOM_ICON_SIZE),
                        painter = painterResource(id = item.icon),
                        contentDescription = item.contentDescription.toString()
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.titleResId),
                        fontFamily = fontFamily,
                        maxLines = SINGLE_LINE,
                        textAlign = TextAlign.Center,
                    )
                },

            )

        }
    }
}
