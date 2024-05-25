package co.rita.handspeak.gesture

import androidx.annotation.DrawableRes

data class GestureResource(
    val letter: String,
    @DrawableRes val letterImg: Int,
    @DrawableRes val gestureImg: Int
)
