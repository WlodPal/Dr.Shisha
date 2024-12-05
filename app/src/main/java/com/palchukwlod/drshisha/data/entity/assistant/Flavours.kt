package com.palchukwlod.drshisha.data.entity.assistant

import com.palchukwlod.drshisha.R

enum class Flavours(
    val flavour: String,
    val image: Int
) {

    ORANGE(
        flavour = "Orange",
        image = R.drawable.list_icon
    ),

    MINT(
        flavour = "Mint",
        image = R.drawable.list_icon
    ),

    COLA(
        flavour = "Cola",
        image = R.drawable.list_icon
    ),

    COFFEE(
        flavour = "Coffee",
        image = R.drawable.list_icon
    )

}