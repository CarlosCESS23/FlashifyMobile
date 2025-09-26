package com.example.flashify.Telas

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SentimentSatisfied
import androidx.compose.material.icons.filled.SentimentVeryDissatisfied
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.Flashcards
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent

@Composable
fun TelaEstudo(
    navController: NavController,
    flashcard: List<Flashcards>
) {
    var currentDeckIndex: Int by remember { mutableStateOf(0) }
    var isDeckFlipped by remember { mutableStateOf(false) }


    // Isso vai ser a animação quando virar a carta

    val rotation by animateFloatAsState(
        targetValue = if (isDeckFlipped) 180f else 0f,
        animationSpec = tween(500),
        label = "rotationAnimation"
    )

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Isso seria o cabeçalho com botão voltar

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                }
                Text(
                    text = "Voltar para a biblioteca",
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            // --- Flashcard ---
            FlashcardView(
                flashcard = flashcard[currentDeckIndex],
                isFlipped = isDeckFlipped,
                rotation = rotation
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- Contador de Cards ---
            Text(
                text = "${currentDeckIndex + 1} / ${flashcard.size}",
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Controles de Navegação (Avançar/Voltar) ---
            if (!isDeckFlipped) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedButton(
                        onClick = { if (currentDeckIndex > 0) currentDeckIndex-- },
                        enabled = currentDeckIndex > 0,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Anterior")
                    }
                    OutlinedButton(
                        onClick = { if (currentDeckIndex < flashcard.size - 1) currentDeckIndex++ },
                        enabled = currentDeckIndex < flashcard.size - 1,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Próximo")
                    }
                }
            } else {
                // --- Botões de Avaliação (Errei, Quase, Acertei) ---
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    EvaluationButton(
                        text = "Errei",
                        icon = Icons.Default.SentimentVeryDissatisfied,
                        color = Color.Red.copy(alpha = 0.7f),
                        onClick = { /* Lógica de avaliação */ }
                    )
                    EvaluationButton(
                        text = "Quase",
                        icon = Icons.Default.SentimentSatisfied,
                        color = YellowAccent.copy(alpha = 0.8f),
                        onClick = { /* Lógica de avaliação */ }
                    )
                    EvaluationButton(
                        text = "Acertei",
                        icon = Icons.Default.SentimentVerySatisfied,
                        color = Color.Green.copy(alpha = 0.7f),
                        onClick = { /* Lógica de avaliação */ }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- Botão Virar Card ---
            TextButton(onClick = { isDeckFlipped = !isDeckFlipped }) {
                Icon(Icons.Default.Refresh, contentDescription = "Virar Card")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    if (isDeckFlipped) "Ver Pergunta" else "Virar Card",
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun FlashcardView(flashcard: Flashcards, isFlipped: Boolean, rotation: Float) {
    // Usamos um Box para sobrepor a frente e o verso do card.
    // A animação de rotação será aplicada ao Box como um todo.
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            },
        contentAlignment = Alignment.Center
    ) {
        // --- Verso do Card ---
        Card(
            modifier = Modifier
                .fillMaxSize()
                // O verso só é visível quando a rotação passa de 90 graus.
                // Ele também é girado em 180 graus para não aparecer espelhado.
                .graphicsLayer {
                    alpha = if (rotation > 90f) 1f else 0f
                    rotationY = 180f
                },
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Conteúdo do verso
                Text(
                    text = flashcard.answer,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // --- Frente do Card ---
        Card(
            modifier = Modifier
                .fillMaxSize()
                // A frente só é visível até a rotação atingir 90 graus.
                .graphicsLayer {
                    alpha = if (rotation > 90f) 0f else 1f
                },
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Conteúdo da frente
                Card(
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
                ) {
                    Row(
                        Modifier.padding(vertical = 4.dp, horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.MenuBook,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(flashcard.type, fontSize = 12.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = flashcard.question,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun EvaluationButton(text: String, icon: ImageVector, color: Color, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, color),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
    ) {
        Icon(imageVector = icon, contentDescription = text)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}