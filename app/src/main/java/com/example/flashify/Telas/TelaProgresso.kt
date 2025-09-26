package com.example.flashify.Telas

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.Conquista
import com.example.flashify.DataClass.NavItem
import com.example.flashify.Util.BIBLIOTECA_SCREEN_ROUTE
import com.example.flashify.Util.CONFIGURATION_SCREEN_ROUTE
import com.example.flashify.Util.CREATE_FLASHCARD_ROUTE
import com.example.flashify.Util.MAIN_SCREEN_ROUTE
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent

@Composable
fun TelaPrincipalProgresso(navController: NavController) {

    // Exemplos de dados:

    val conquistas = listOf(
        Conquista(Icons.Default.WorkspacePremium, "Estudante Dedicado", "7 dias consecutivos"),
        Conquista(
            Icons.Default.Person,
            "Mestre dos decks",
            "Complete 100 cards",
            currentProgress = 78,
            targetProgress = 100
        ),
        Conquista(
            icon = Icons.Default.Person,
            "Mestre dos Cards",
            "Estude 100 cards no total",
            currentProgress = 78,
            targetProgress = 100
        ),
        Conquista(
            icon = Icons.Default.DoneAll,
            title = "Finalizador",
            "Complete 5 conjuntos de estudo (100%)"
        ),
        Conquista(
            icon = Icons.Default.Timer,
            title = "Maratonista de Estudos",
            "Acumule 10 horas de estudo",
            currentProgress = 4,
            targetProgress = 10
        ),
        Conquista(
            icon = Icons.Default.NoteAdd,
            title = "Criador Prolífico",
            "Crie 10 conjuntos de flashcards",
            currentProgress = 3,
            targetProgress = 10
        ),
        Conquista(
            icon = Icons.Default.School,
            title = "Polímata",
            "Estude em 5 categorias diferentes",
            currentProgress = 0,
            targetProgress = 5
        )

    )

// Navegação:
    val navItems = listOf(
        NavItem("Início", Icons.Default.Home),
        NavItem("Biblioteca", Icons.Default.LibraryBooks),
        NavItem("Criar", Icons.Default.AddCircle),
        NavItem("Progresso", Icons.Default.TrendingUp),
        NavItem("Config", Icons.Default.Settings)
    )
    val createItemIndex = navItems.indexOfFirst { it.label == "Progresso" }

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
                                if (destination == "Config") {
                                    navController.navigate(CONFIGURATION_SCREEN_ROUTE) {
                                        //Limpando a pilha de navegação para que o usuário não volte
                                        //Para tela de criação ao apertar "voltar"
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

            // Decks de estatística Principais
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    StatusDeck(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.CalendarToday,
                        value = "7",
                        label = "Dias de Sequência"
                    )
                    StatusDeck(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.TrackChanges,
                        value = "89%",
                        label = "Taxa de acerto"
                    )
                }
            }
            // Decks de desta semana:
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            "Esta Semana",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Divider(
                            color = Color.Gray.copy(alpha = 0.5f)
                        )
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Cards Estudados", color = TextSecondary)
                            Text("156", fontWeight = FontWeight.Bold)
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Tempo Total", color = TextSecondary)
                            Text("2h 30m", fontWeight = FontWeight.Bold)
                        }
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Conjuntos Concluídos", color = TextSecondary)
                            Text("3", fontWeight = FontWeight.Bold)
                        }

                    }
                }
            }
            item {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    Column(
                        Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("Conquistas", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Divider(color = Color.Gray.copy(alpha = 0.5f))
                        conquistas.forEach { achievements ->
                            ListasDeConquista(conquista = achievements)
                        }
                    }
                }
            }
        }
    }
}


// Decks para as estatísticas princpais ( Que tem Sequências e Acerto)

@Composable
fun StatusDeck(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
    label: String
) {
    Card(
        modifier = modifier.height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = YellowAccent
            )
            Text(
                text = value,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = label,
                fontSize = 14.sp,
                color = TextSecondary
            )

        }
    }
}

@Composable
fun ListasDeConquista(conquista: Conquista) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Icon(
            imageVector = conquista.icon,
            contentDescription = conquista.title,
            tint = TextSecondary,
            modifier = Modifier.size(32.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = conquista.title,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            // Isso é a lógica para exibir a descrição ou o progresso

            val descriptionText = if (conquista.currentProgress != null &&
                conquista.targetProgress != null
            ) {
                "${conquista.decription} (${conquista.currentProgress}/${conquista.targetProgress}"
            } else {
                conquista.decription
            }
            Text(
                text = descriptionText,
                fontSize = 14.sp,
                color = TextSecondary
            )

            // Mostra a barra de progresso se houver valores para ela:

            if (conquista.currentProgress != null && conquista.targetProgress != null) {
                Spacer(modifier = Modifier.height(4.dp))
                LinearProgressIndicator(
                    progress = { conquista.currentProgress.toFloat() / conquista.targetProgress.toFloat() },
                    color = YellowAccent,
                    trackColor = Color.Gray.copy(alpha = 0.5f)
                )
            }
        }
    }
}


@Preview
@Composable
fun TestePrincipal() {
    TelaPrincipalProgresso(navController = NavController(LocalContext.current))
}

