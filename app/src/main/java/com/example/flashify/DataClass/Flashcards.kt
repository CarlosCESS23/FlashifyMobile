package com.example.flashify.DataClass


// Dataclass de flashcard para utiliza no momento que o usário clica em algum flashcard na biblioteca:
data class Flashcards(
    val type: String,
    val question: String,
    val answer: String
)

