package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AffirmationModel(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)