package com.palchukwlod.drshisha.navigation

import android.net.Uri

sealed class Screen(
    val route: String
) {

    //Bottom Nav Items
    object ExploreMixes: Screen(ROUTE_EXPLORE_MIXES)

    object ListCustomMixes: Screen(ROUTE_LIST_CUSTOM_MIXES)

    object Assistant: Screen(ROUTE_ASSISTANT)


    //Assistant
    object ListOfAssistant: Screen(ROUTE_LIST_OF_ASSISTANT)

    object BrandsWithFlavours: Screen(ROUTE_BRANDS_WITH_FLAVOURS)

    object Heads: Screen(ROUTE_HEADS)

    object Shisha: Screen(ROUTE_SHISHA)

    object Charcoal: Screen(ROUTE_CHARCOAL)

    object Accessories: Screen(ROUTE_ACCESSORIES)


    //Custom Mixes
    object CustomMixes: Screen(ROUTE_CUSTOM_MIXES)

    object AddingMixes: Screen(ROUTE_ADDING_MIXES)

    object AddPartOfMix: Screen(ROUTE_ADD_PART_OF_MIX)

    companion object {

        //Bottom Navigation Screens
        const val ROUTE_EXPLORE_MIXES = "explore_mixes"
        const val ROUTE_LIST_CUSTOM_MIXES = "list_custom_mixes"
        const val ROUTE_ASSISTANT = "assistant"

        //Assistant Items
        const val ROUTE_LIST_OF_ASSISTANT = "list_of_assistant"
        const val ROUTE_BRANDS_WITH_FLAVOURS = "brands_with_flavours"
        const val ROUTE_HEADS = "heads"
        const val ROUTE_SHISHA = "shisha"
        const val ROUTE_CHARCOAL = "charcoal"
        const val ROUTE_ACCESSORIES = "accessories"

        //Custom Mixes
        const val ROUTE_ADD_PART_OF_MIX = "add_part_of_mix"
        const val ROUTE_ADDING_MIXES = "adding_mixes"
        const val ROUTE_CUSTOM_MIXES = "custom_mixes"

    }

}

fun String.encode():String{
    return Uri.encode(this)
}