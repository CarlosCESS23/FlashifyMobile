package com.example.flashify.DataClass

import androidx.compose.ui.graphics.vector.ImageVector

// Classe ara adicionar as consquistas individuais

data class Conquista(
    val icon: ImageVector,
    val title: String,
    val decription: String,
    val currentProgress: Int? = null, // Seria o progresso atual da conquista
    val targetProgress: Int? = null // Objetivos

)
