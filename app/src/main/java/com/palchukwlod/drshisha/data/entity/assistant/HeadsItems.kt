package com.palchukwlod.drshisha.data.entity.assistant

import com.palchukwlod.drshisha.R

enum class HeadsItems (
    val headName: Int,
    val description: Int,
    val strongAndWeekSides: Int,
    val image: Int
) {

    CLAY_BOWLS(
        headName = R.string.clay_hookah_bowls,
        strongAndWeekSides = R.string.strong_and_week_sides_clay_bow,
        description = R.string.clay_desc,
        image = R.drawable.clay_bowl
    ),

    CERAMIC_BOWLS(
        headName = R.string.ceramic_bowls,
        strongAndWeekSides = R.string.strong_and_week_sides_ceramic,
        description = R.string.clay_desc,
        image = R.drawable.ceramic_bowl
    ),

    FAIENCE_BOWLS(
        headName = R.string.faience_bowls,
        strongAndWeekSides = R.string.strong_and_week_sides_ceramic,
        description = R.string.clay_desc,
        image = R.drawable.fiance_bowl
    ),
    SILICONE_BOWLS(
        headName = R.string.silicone_bowls,
        strongAndWeekSides = R.string.strong_and_week_sides_ceramic,
        description = R.string.clay_desc,
        image = R.drawable.silicone_bowl
    ),
    STONE_BOWLS(
        headName = R.string.stone_bowls,
        strongAndWeekSides = R.string.empty,
        description = R.string.clay_desc,
        image = R.drawable.stone_bowl
    ),
    FRUIT_BOWLS(
        headName = R.string.fruit_bowls,
        strongAndWeekSides = R.string.empty,
        description = R.string.clay_desc,
        image = R.drawable.fruit_bowl
    )





}