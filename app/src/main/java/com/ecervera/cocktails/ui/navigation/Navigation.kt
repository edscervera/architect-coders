package com.ecervera.cocktails.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecervera.cocktails.ui.presentation.cocktail.CocktailView
import com.ecervera.cocktails.ui.presentation.cocktails.CocktailsView

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.Cocktails.route
    ) {
        composable(NavItem.Cocktails) {
            CocktailsView { id ->
                navController.navigate(NavItem.Cocktail.createNavRoute(id))
            }
        }

        composable(NavItem.Cocktail) { backStackEntry ->
            CocktailView(id = backStackEntry.findArg(NavArg.Id)) {
                navController.popBackStack()
            }
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.getString(arg.key)
    requireNotNull(value)
    return value as T
}