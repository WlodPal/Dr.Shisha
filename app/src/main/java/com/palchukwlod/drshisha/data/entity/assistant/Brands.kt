package com.palchukwlod.drshisha.data.entity.assistant

import com.palchukwlod.drshisha.R

enum class Brands(
    val brandName: String,
    val brandLogo: Int,
    val linesOfBrands: List<LinesOfBrands>
) {

    DARK_SIDE(
        brandName = "Dark Side",
        brandLogo = R.drawable.darkside_logo,
        linesOfBrands = listOf(LinesOfBrands.DARK_SIDE_SHOT, LinesOfBrands.DARK_SIDE_XPERIENCE)
    ),

    CHABACCO(
        brandName = "Chabacco",
        brandLogo = R.drawable.chabacco_logo,
        linesOfBrands = listOf(LinesOfBrands.CHABACCO_EMOTIONS)
    )

}