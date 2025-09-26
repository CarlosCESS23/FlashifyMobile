package com.example.flashify.Telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.Decks
import com.example.flashify.DataClass.NavItem
import com.example.flashify.Util.CONFIGURATION_SCREEN_ROUTE
import com.example.flashify.Util.CREATE_FLASHCARD_ROUTE
import com.example.flashify.Util.ESTUDO_SCREEN_ROUTE
import com.example.flashify.Util.MAIN_SCREEN_ROUTE
import com.example.flashify.Util.PROGRESSO_SCREEN_ROUTE
import com.example.flashify.Util.cartas
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent


@Composable
fun TelaPrincipalBiblioteca(navController: NavController) {

    //Variado de Itens da biblioteca usando a função de Objeto

    val decks = cartas()


    // Navegação:

    val navItems = listOf(
        NavItem("Início", Icons.Default.Home),
        NavItem("Biblioteca", Icons.Default.LibraryBooks),
        NavItem("Criar", Icons.Default.AddCircle),
        NavItem("Progresso", Icons.Default.TrendingUp),
        NavItem("Config", Icons.Default.Settings)
    )

    //Deixando o item "Biblioteca" selecionado
    val libraryItemIndex = navItems.indexOfFirst { it.label == "Biblioteca" }

    Scaffold(
        // 4. ADICIONA A BARRA DE NAVEGAÇÃO INFERIOR
        bottomBar = {
            NavegacaoBotaoAbaixo(
                navItems = navItems,
                selectedItem = libraryItemIndex, // Deixa o item "Criar" sempre selecionado
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
                            if (destination == "Progresso") {
                                navController.navigate(PROGRESSO_SCREEN_ROUTE) {
                                    //Limpando a pilha de navegação para que o usuário não volte
                                    //Para tela de criação ao apertar "voltar"
                                    popUpTo(PROGRESSO_SCREEN_ROUTE) { inclusive = true }
                                }
                            } else
                                if (destination == "Config") {
                                    navController.navigate(CONFIGURATION_SCREEN_ROUTE) {
                                        popUpTo(CONFIGURATION_SCREEN_ROUTE) { inclusive = true }
                                    }
                                }
                    // Se clicar em "Criar", não faz nada pois já está na tela.
                    // Outras navegações (Biblioteca, etc.) podem ser adicionadas aqui.
                }
            )
        }
    ) { innerPadding ->
        // O conteúdo da tela continua exatamente o mesmo
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Cabeçalho da tela:
            item {
                HeaderBiblioteca()
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(decks) { deck ->
                CartasDeck(navController = navController, deck = deck)
            }

        }
    }
}

@Composable
fun HeaderBiblioteca() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = "Biblioteca",
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = "Biblioteca",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CartasDeck(navController: NavController, deck: Decks) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Isso seria a linha superior: como Título e Menu
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = deck.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "${deck.cardCount} decks",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Mais opções",
                    tint = TextSecondary
                )
            }
            //Linha do meio: Barra do progresso
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LinearProgressIndicator(
                    progress = { deck.progress / 100f },
                    modifier = Modifier.weight(1f),
                    color = YellowAccent,
                    trackColor = Color.Gray.copy(alpha = 0.5f)
                )
                Text(
                    text = "${deck.progress}",
                    color = YellowAccent,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            // Linha Inferior (Botão Estudar)
            OutlinedButton(
                onClick = { navController.navigate(ESTUDO_SCREEN_ROUTE) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = TextSecondary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Iniciar estudo",
                    color = TextSecondary,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}


val carta = Decks(title = "Inglês Básico", cardCount = 25, progress = 80)

@Preview
@Composable
fun Testea() {

    TelaPrincipalBiblioteca(navController = NavController(LocalContext.current))
}
