package com.example.flashify.Telas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.NavItem
import com.example.flashify.Util.BIBLIOTECA_SCREEN_ROUTE
import com.example.flashify.Util.CONFIGURATION_SCREEN_ROUTE
import com.example.flashify.Util.CREATE_FLASHCARD_ROUTE
import com.example.flashify.Util.MAIN_SCREEN_ROUTE
import com.example.flashify.Util.PROGRESSO_SCREEN_ROUTE
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent


@Composable
fun TelaPrincipalConfiguracao(navController: NavController) {

    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(true) }
    var soundEnabled by remember { mutableStateOf(false) }

    val navItems = listOf(
        NavItem("Início", Icons.Default.Home),
        NavItem("Biblioteca", Icons.Default.LibraryBooks),
        NavItem("Criar", Icons.Default.AddCircle),
        NavItem("Progresso", Icons.Default.TrendingUp),
        NavItem("Config", Icons.Default.Settings)
    )
    val createItemIndex = navItems.indexOfFirst { it.label == "Configuração" }

    // Tela principal com barra de navegação
    Scaffold(
        // 4. ADICIONA A BARRA DE NAVEGAÇÃO INFERIOR
        bottomBar = {
            NavegacaoBotaoAbaixo(
                navItems = navItems,
                selectedItem = createItemIndex, // Deixa o item "Criar" sempre selecionado
                onItemSelected = { clickedIndex ->
                    // 5. Lógica para quando um item da barra é clicado
                    val destination = navItems[clickedIndex].label
                    if (destination == "Início") {
                        // Navega de volta para a tela principal
                        navController.navigate(MAIN_SCREEN_ROUTE) {
                            // Limpa a pilha de navegação para que o usuário não volte
                            // para a tela de criação ao apertar "voltar"
                            popUpTo(MAIN_SCREEN_ROUTE) { inclusive = true }
                        }
                    } else
                        if (destination == "Criar") {
                            navController.navigate(CREATE_FLASHCARD_ROUTE) {
                                // Limpando a pilha de navegação para que o usuário não volte
                                // Para tela de criação ao apertar "voltar"
                                popUpTo(CREATE_FLASHCARD_ROUTE) { inclusive = true }
                            }
                        } else
                            if (destination == "Biblioteca") {
                                navController.navigate(BIBLIOTECA_SCREEN_ROUTE) {

                                    popUpTo(BIBLIOTECA_SCREEN_ROUTE) { inclusive = true }
                                }

                            } else
                                if (destination == "Progresso") {
                                    navController.navigate(PROGRESSO_SCREEN_ROUTE) {
                                        //Limpando a pilha de navegação para que o usuário não volte
                                        //Para tela de criação ao apertar "voltar"
                                        popUpTo(PROGRESSO_SCREEN_ROUTE) { inclusive = true }
                                    }
                                } else
                                    if (destination == "Config") {
                                        navController.navigate(CONFIGURATION_SCREEN_ROUTE) {
                                            //Limpando a pilha de navegação para que o usuário não volte para tela anterior
                                            popUpTo(CONFIGURATION_SCREEN_ROUTE) { inclusive = true }
                                        }
                                    }
                    // Se clicar em "Criar", não faz nada pois já está na tela.
                    // Outras navegações (Biblioteca, etc.) podem ser adicionadas aqui.
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // --- Cabeçalho ---
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Configurações",
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "Configurações",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // --- Card de Perfil ---
            item {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(
                        Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Foto de Perfil",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape),
                                tint = YellowAccent
                            )
                            Column {
                                Text("João Silva", fontWeight = FontWeight.Bold)
                                Text("joao@email.com", color = TextSecondary, fontSize = 14.sp)
                            }
                        }
                        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                            Text("Editar Perfil")
                        }
                    }
                }
            }

            // --- Card de Preferências ---
            item {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(
                        Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("Preferências", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        ConfiguracaoSwitctItem(
                            icon = Icons.Default.Notifications,
                            text = "Notificações",
                            checked = notificationsEnabled,
                            onCheckedChange = { notificationsEnabled = it }
                        )
                        ConfiguracaoSwitctItem(
                            icon = Icons.Default.DarkMode,
                            text = "Modo Escuro",
                            checked = darkModeEnabled,
                            onCheckedChange = { darkModeEnabled = it }
                        )
                        ConfiguracaoSwitctItem(
                            icon = Icons.Default.VolumeUp,
                            text = "Som",
                            checked = soundEnabled,
                            onCheckedChange = { soundEnabled = it }
                        )
                    }
                }
            }

            // --- Card de Suporte ---
            item {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(
                        Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Suporte", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        ConfiguracaoClick(
                            icon = Icons.Default.HelpOutline,
                            text = "Central de Ajuda",
                            onClick = { /*TODO*/ }
                        )
                        Divider(color = Color.Gray.copy(alpha = 0.5f))
                        ConfiguracaoClick(
                            icon = Icons.Default.Description,
                            text = "Termos de Uso",
                            onClick = { /*TODO*/ }
                        )
                        Divider(color = Color.Gray.copy(alpha = 0.5f))
                        ConfiguracaoClick(
                            icon = Icons.Default.Shield,
                            text = "Política de Privacidade",
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ConfiguracaoSwitctItem(
    icon: ImageVector,
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = TextSecondary
            )
            Text(text)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedTrackColor = YellowAccent,
                checkedThumbColor = Color.White,
                uncheckedTrackColor = Color.Gray,
            )
        )
    }
}

@Composable
fun ConfiguracaoClick(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp), // Padding vertical para dar mais área de clique
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = TextSecondary)
        Text(text)
    }
}


@Preview
@Composable
fun TestTela() {
    TelaPrincipalConfiguracao(navController = NavController(LocalContext.current))
}