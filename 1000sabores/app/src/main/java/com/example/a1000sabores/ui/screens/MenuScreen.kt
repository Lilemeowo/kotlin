package com.example.a1000sabores.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a1000sabores.ui.components.BotonMenu
import com.example.a1000sabores.ui.navigation.NavRoutes
import com.example.a1000sabores.ui.theme.TextPrimary
import com.example.a1000sabores.ui.theme.TextSecondary
import com.example.a1000sabores.ui.viewmodel.AppViewModel
import androidx.compose.material.icons.filled.Store
import com.example.a1000sabores.ui.theme.CardBlack
import com.example.a1000sabores.ui.theme.SecondaryBlue
import androidx.compose.material.icons.filled.Logout



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(onNavigate: (String) -> Unit) {
    val vm: AppViewModel = viewModel()
    val name by vm.nombreUsuario.collectAsState()
    val email by vm.emailUsuario.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Pastelería 1000 Sabores — Menú") },
                actions = {
                    IconButton(onClick = { vm.logout() }) {
                        Icon(Icons.Default.Logout, contentDescription = "Salir")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardBlack, contentColor = TextPrimary),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(

                        "Bienvenido, $name ",
                        style = MaterialTheme.typography.titleLarge,
                        color = SecondaryBlue
                    )
                    Text(
                        email,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }

            BotonMenu("Productos / Tienda", Icons.Filled.Store) { onNavigate(NavRoutes.Productos) }
            BotonMenu("Carrito", Icons.Filled.ShoppingCart) { onNavigate(NavRoutes.Carrito) }
            BotonMenu("Perfil", Icons.Filled.Person) { onNavigate(NavRoutes.Perfil) }
            BotonMenu("Sucursales", Icons.Filled.LocationOn) { onNavigate(NavRoutes.Sucursales) }
        }
    }
}
