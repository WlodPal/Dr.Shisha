package com.palchukwlod.drshisha.data.entity.customMix

import androidx.compose.ui.graphics.Color
import com.palchukwlod.drshisha.presentation.theme.LightMixColor
import com.palchukwlod.drshisha.presentation.theme.MediumMixColor
import com.palchukwlod.drshisha.presentation.theme.StrongMixColor

enum class LevelOfStrong(val color: Color) {

    STRONG(StrongMixColor),
    MEDIUM(MediumMixColor),
    LIGHT(LightMixColor)

}