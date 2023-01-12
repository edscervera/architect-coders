package com.ecervera.cocktails.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem (
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList()
) {
    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

    object Cocktails : NavItem("home")
    object Cocktail : NavItem("cocktail", listOf(NavArg.Id)) {
        fun createNavRoute(id: String) = "$baseRoute/$id"
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    Id("id", NavType.StringType)
}
