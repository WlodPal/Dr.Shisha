package com.palchukwlod.drshisha.data.entity.assistant

enum class LinesOfBrands(
    val lineName: String,
    val flavours: List<Flavours>
) {


    //Dark Side
    DARK_SIDE_XPERIENCE(
        lineName = "Dark Side XPERIENCE",
        listOf(Flavours.ORANGE)
    ),

    DARK_SIDE_SHOT(
        lineName = "Dark Side SHOT",
        listOf(Flavours.COLA)
    ),


    //Chabacco
    CHABACCO_EMOTIONS(
        lineName = "CHABACCO Emotions",
        listOf(Flavours.MINT, Flavours.COFFEE)
    )



}