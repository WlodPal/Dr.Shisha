package com.palchukwlod.drshisha.data.entity.assistant

import com.palchukwlod.drshisha.R

enum class AssistantItems(

    val listName: Int,
    val list: List<Any>,
    val picture: Int
) {

    BRANDS_WITH_FLAVOURS(
        listName =  R.string.brands_with_flavours,
        list = listOf(Brands.DARK_SIDE, Brands.CHABACCO),
        picture =  R.drawable.tabacco_picures
    ),
    HEADS(
        listName =  R.string.heads,
        listOf(),
        picture = R.drawable.heads_picture
    ),
    SHISHA(
        listName =  R.string.shisha,
        listOf(),
        picture = R.drawable.shisha_picure
    ),
    CHARCOAL(
        listName =  R.string.charcoal,
        listOf(),
        picture = R.drawable.charcole_picture
    ),
    ACCESSORIES(
        listName =  R.string.accessories,
        listOf(),
        picture = R.drawable.assesories_picure
    )
}