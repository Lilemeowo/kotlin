package com.example.a1000sabores.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.a1000sabores.data.Sucursal

@Composable
fun SucursalCard(sucursal: Sucursal) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = sucursal.nombre, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = "Dirección: ${sucursal.direccion}")
            Text(text = "Horario: ${sucursal.horario}")
            Text(text = "Teléfono: ${sucursal.telefono}")

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {
                    val mapIntent = Intent(Intent.ACTION_VIEW, "geo:0,0?q=${Uri.encode(sucursal.direccion)}".toUri())
                    context.startActivity(mapIntent)
                }) {
                    Text("Ver mapa")
                }

                OutlinedButton(onClick = {
                    val callIntent = Intent(Intent.ACTION_DIAL, "tel:${sucursal.telefono}".toUri())
                    context.startActivity(callIntent)
                }) {
                    Text("Llamar")
                }
            }
        }
    }
}
