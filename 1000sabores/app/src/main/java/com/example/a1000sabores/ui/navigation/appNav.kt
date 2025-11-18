package com.example.a1000sabores.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a1000sabores.ui.screens.CarritoScreen
import com.example.a1000sabores.ui.screens.MenuScreen
import com.example.a1000sabores.ui.screens.PerfilScreen
import com.example.a1000sabores.ui.screens.ProductosScreen
import com.example.a1000sabores.ui.screens.SucursalesScreen
import com.example.a1000sabores.ui.viewmodel.AppViewModel

@Composable
fun AppNav() {
    val nav = rememberNavController()
    val vm: AppViewModel = viewModel()
    val estaLogueado by vm.estaLogueado.collectAsState()

    NavHost(
        navController = nav,
        startDestination = NavRoutes.Menu
    ) {
        composable(NavRoutes.Menu) {
            MenuScreen(onNavigate = { route -> nav.navigate(route) })
        }
        composable(NavRoutes.Productos) {
            ProductosScreen(
                onBack = { nav.popBackStack() },
                onNavigate = { route -> nav.navigate(route) }
            )
        }
        composable(NavRoutes.Carrito) {
            CarritoScreen(onBack = { nav.popBackStack() })
        }
        composable(NavRoutes.Perfil) {
            PerfilScreen(onBack = { nav.popBackStack() })
        }
        composable(NavRoutes.Sucursales) {
            SucursalesScreen(onBack = { nav.popBackStack() })
        }
    }
}
