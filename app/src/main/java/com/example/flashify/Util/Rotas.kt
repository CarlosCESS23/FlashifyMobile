package com.example.flashify.Util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flashify.Telas.TelaCriacaoFlashCard
import com.example.flashify.Telas.TelaEstudo
import com.example.flashify.Telas.TelaPrincipal
import com.example.flashify.Telas.TelaPrincipalBiblioteca
import com.example.flashify.Telas.TelaPrincipalConfiguracao
import com.example.flashify.Telas.TelaPrincipalProgresso


// Rota para a tela principal
const val MAIN_SCREEN_ROUTE = "main_screen"

// Rota para a tela de criação
const val CREATE_FLASHCARD_ROUTE = "create_flashcard_screen"
// Rota para a tela de Opção

const val BIBLIOTECA_SCREEN_ROUTE = "config_screen"

//Rota para a tela de progresso

const val PROGRESSO_SCREEN_ROUTE = "progresso_screen"

const val CONFIGURATION_SCREEN_ROUTE = "configuration_screen"

const val ESTUDO_SCREEN_ROUTE = "estudo_screen"


@Composable
fun AppNavigation() {
    // 1. Cria o controlador de navegação. Ele é o "cérebro" que gerencia as telas.
    val navController = rememberNavController()

    // 2. Cria o NavHost, que é o container que exibirá as telas
    NavHost(navController = navController, startDestination = MAIN_SCREEN_ROUTE) {
        // 3. Define a tela principal
        composable(route = MAIN_SCREEN_ROUTE) {
            TelaPrincipal(navController = navController) // Passa o navController para a tela
        }

        // 4. Define a tela de criação de flashcards
        composable(route = CREATE_FLASHCARD_ROUTE) {
            TelaCriacaoFlashCard(navController) // A tela de criação não precisa do navController por enquanto
        }
        // 5. Define a tela de biblioteca
        composable(route = BIBLIOTECA_SCREEN_ROUTE) {
            TelaPrincipalBiblioteca(navController)
        }
        // 6. Define a tela de progresso
        composable(route = PROGRESSO_SCREEN_ROUTE) {
            TelaPrincipalProgresso(navController)
        }
        //7. Define a tela de configurações
        composable(route = CONFIGURATION_SCREEN_ROUTE) {
            TelaPrincipalConfiguracao(navController)
        }
        composable(route = ESTUDO_SCREEN_ROUTE) {
            TelaEstudo(navController, flashcard = EnglishFlascard())
        }
    }
}