package com.example.flashify.Telas

// Rotas que são da classe rotas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.NavItem
import com.example.flashify.R
import com.example.flashify.Util.AppNavigation
import com.example.flashify.Util.BIBLIOTECA_SCREEN_ROUTE
import com.example.flashify.Util.CONFIGURATION_SCREEN_ROUTE
import com.example.flashify.Util.CREATE_FLASHCARD_ROUTE
import com.example.flashify.Util.MAIN_SCREEN_ROUTE
import com.example.flashify.Util.PROGRESSO_SCREEN_ROUTE
import com.example.flashify.ui.theme.FlashifyTheme
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent

// Essa classe é onde inicia a aplicação em mobile, chamando a função composable TelaPrincipal
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashifyTheme {
                AppNavigation()
            }
        }
    }
}


@Composable
fun TelaPrincipal(navController: NavController) {
    // Estado para controlar o item selecionado na barra de navegação
    var selectedItem by remember { mutableStateOf(0) }
    val navItems = listOf(
        NavItem("Início", Icons.Default.Home),
        NavItem("Biblioteca", Icons.Default.LibraryBooks),
        NavItem("Criar", Icons.Default.AddCircle),
        NavItem("Progresso", Icons.Default.TrendingUp),
        NavItem("Config", Icons.Default.Settings)
    )

    // 1. Encontrar o índice do item "Criar" de forma dinâmica.
    // Isso é mais seguro do que usar um número fixo como '2'.
    val createItemIndex = navItems.indexOfFirst { it.label == "Início" }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            SecaoTopo()
            AcaoBotoes(navController)
            SecaoStatus()
        }
    }
}

//Criação da seção de texto (Com imagem do FlashCards)
@Composable
fun SecaoTopo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.flashify),
            contentDescription = "Logo FlashCards",
            modifier = Modifier
                .size(60.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Flashify",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Aprenda de forma inteligente",
            fontSize = 16.sp,
            color = TextSecondary
        )
    }
}


// Criação da ação dos botões, onde vão ser direncionados para outras telas
@Composable
fun AcaoBotoes(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Botão Principal
        Button(
            onClick = { navController.navigate(CREATE_FLASHCARD_ROUTE) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = YellowAccent)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Criar Novos Conjuntos",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        // Botão Secundário
        OutlinedButton(
            onClick = { navController.navigate(BIBLIOTECA_SCREEN_ROUTE) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.surface)
        ) {
            Icon(
                imageVector = Icons.Default.LibraryBooks,
                contentDescription = null,
                tint = TextSecondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ver Biblioteca Completa", color = TextSecondary)
        }

        // Terceiro Botão
        OutlinedButton(
            onClick = { /* TODO: Ação conjuntos recentes */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.surface)
        ) {
            Icon(
                imageVector = Icons.Default.History,
                contentDescription = null,
                tint = TextSecondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Conjuntos Recentes", color = TextSecondary)
        }
    }
}


// Aqui vai ser a criação de layout para Seção de status das cartas
@Composable
fun SecaoStatus() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SecaoCartas(
            modifier = Modifier.weight(1f),
            count = "12",
            label = "Conjuntos"
        )
        SecaoCartas(
            modifier = Modifier.weight(1f),
            count = "248",
            label = "Cards"
        )
    }
}

@Composable
fun SecaoCartas(modifier: Modifier = Modifier, count: String, label: String) {
    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = count,
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

//Criação dos botões de navegação
@Composable
fun NavegacaoBotaoAbaixo(
    navItems: List<NavItem>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar( // Utilizando a função já criada do Android JetPack
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = TextSecondary
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = YellowAccent,
                    selectedTextColor = YellowAccent,
                    unselectedIconColor = TextSecondary,
                    unselectedTextColor = TextSecondary,
                    indicatorColor = MaterialTheme.colorScheme.surface // Cor de fundo do item selecionado
                )
            )
        }
    }
}

@Preview
@Composable
fun Teste() {
    FlashifyTheme {
        AppNavigation()
    }
}
