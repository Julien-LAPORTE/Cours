package fr.samneo.cours.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Theme(
    @DrawableRes val image: Int,
    @StringRes val themeText: Int,
    val numberOfCourses: Int = 0
)
