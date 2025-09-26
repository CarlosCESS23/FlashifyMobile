package com.example.flashify.Util

import com.example.flashify.DataClass.Decks
import com.example.flashify.DataClass.Flashcards


fun cartas(): List<Decks> {

    return listOf(
        Decks(title = "Inglês Básico", cardCount = 25, progress = 80),
        Decks(title = "Matemática Financeira", cardCount = 40, progress = 60),
        Decks(title = "História do Brasil", cardCount = 30, progress = 45),
        Decks(title = "Química Orgânica", cardCount = 55, progress = 20),
        Decks(title = "Biologia Celular", cardCount = 60, progress = 95),
        Decks(title = "Geografia Mundial", cardCount = 15, progress = 10),
        Decks(title = "Física Quântica", cardCount = 75, progress = 5),
        Decks(title = "Primeiros Socorros", cardCount = 20, progress = 100),
        Decks(title = "Culinária Italiana", cardCount = 10, progress = 70)
    )
}

fun EnglishFlascard(): List<Flashcards> {
    return listOf(
        Flashcards("Conceito", "Como se diz a maçã em inglês?", "Apple"),
        Flashcards("Tradução", "O que significa 'Hello, World!'?", "Olá, Mundo!"),
        Flashcards("Gramática", "Qual o passado do verbo 'to go'?", "Went"),
        Flashcards("Vocabulário", "O que é um 'book'?", "Livro"),
        Flashcards("Frase", "Traduza: 'The book is on the table.'", "O livro está sobre a mesa.")
    )
}