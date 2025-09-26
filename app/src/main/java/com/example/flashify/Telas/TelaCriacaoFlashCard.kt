package com.example.flashify.Telas


import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashify.DataClass.Etapas
import com.example.flashify.DataClass.NavItem
import com.example.flashify.Util.BIBLIOTECA_SCREEN_ROUTE
import com.example.flashify.Util.CONFIGURATION_SCREEN_ROUTE
import com.example.flashify.Util.MAIN_SCREEN_ROUTE
import com.example.flashify.Util.PROGRESSO_SCREEN_ROUTE
import com.example.flashify.ui.theme.CardBackground
import com.example.flashify.ui.theme.TextSecondary
import com.example.flashify.ui.theme.YellowAccent
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCriacaoFlashCard(navController: NavController) { // 1. Recebe o NavController
    // --- STATE MANAGEMENT (Gerenciamento de Estado) ---
    // Gerencia a etapa atual do fluxo (1 a 4)
    var currentStep by remember { mutableStateOf(1) }

    // Armazena os dados coletados em cada etapa
    var deckName by remember { mutableStateOf("") }
    var contentText by remember { mutableStateOf("") }
    var flashcardQuantity by remember { mutableStateOf(10f) }
    var selectedDifficulty by remember { mutableStateOf("Fácil") }

    //Para armazenar o arquivo selecionado:

    var selectFileUri by remember { mutableStateOf<Uri?>(null) }

    // Define as etapas para o indicador de progresso
    val steps = listOf(
        Etapas(1, "Nome"),
        Etapas(2, "Conteúdo"),
        Etapas(3, "Quantidade"),
    )

    // --- LÓGICA DA BARRA DE NAVEGAÇÃO ---
    // 2. Define os itens da barra de navegação (os mesmos da TelaPrincipal)
    val navItems = listOf(
        NavItem("Início", Icons.Default.Home),
        NavItem("Biblioteca", Icons.Default.LibraryBooks),
        NavItem("Criar", Icons.Default.AddCircle),
        NavItem("Progresso", Icons.Default.TrendingUp),
        NavItem("Config", Icons.Default.Settings)
    )

    // 3. Encontra o índice do item "Criar" para mantê-lo selecionado
    val createItemIndex = navItems.indexOfFirst { it.label == "Criar" }


    // Determina se o botão "Próximo" deve estar habilitado
    val isNextEnabled = when (currentStep) {
        1 -> deckName.isNotBlank()
        2 -> contentText.isNotBlank() || selectFileUri != null
        else -> true // Habilitado para as outras etapas por padrão
    }

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
                    } else if (destination == "Biblioteca") {
                        navController.navigate(BIBLIOTECA_SCREEN_ROUTE) {
                            popUpTo(BIBLIOTECA_SCREEN_ROUTE) { inclusive = true }
                        }
                    }
                    // Se clicar em "Criar", não faz nada pois já está na tela.
                    // Outras navegações (Biblioteca, etc.) podem ser adicionadas aqui.
                    else
                        if (destination == "Progresso") {
                            navController.navigate(PROGRESSO_SCREEN_ROUTE) {
                                popUpTo(PROGRESSO_SCREEN_ROUTE) { inclusive = true }
                            }
                        } else
                            if (destination == "Config") {
                                navController.navigate(CONFIGURATION_SCREEN_ROUTE) {
                                    popUpTo(CONFIGURATION_SCREEN_ROUTE) { inclusive = true }
                                }
                            }
                }

            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- INDICADOR DE PROGRESSO ---
            StepIndicator(steps = steps, currentStep = currentStep)

            Spacer(modifier = Modifier.height(32.dp))

            // --- CONTEÚDO DA ETAPA ATUAL (Renderização Condicional) ---
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                when (currentStep) {
                    1 -> Step1_Name(deckName, onNameChange = { deckName = it })
                    2 -> Step2_Content(
                        contentText,
                        onContentChange = { contentText = it },
                        selectedFileUri = selectFileUri,
                        onFileSelected = { uri ->
                            selectFileUri = uri
                        }
                    )

                    3 -> Step3_Quantity(
                        flashcardQuantity,
                        onQuantityChange = { flashcardQuantity = it })
                }
            }

            // --- BOTÕES DE NAVEGAÇÃO (Voltar/Próximo) ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = if (currentStep > 1) Arrangement.SpaceBetween else Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentStep > 1) {
                    TextButton(onClick = { currentStep-- }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                        Spacer(Modifier.width(4.dp))
                        Text("Voltar")
                    }
                }

                Button(
                    onClick = {
                        if (currentStep < 4) currentStep++ else { /* TODO: Gerar Flashcards */
                        }
                    },
                    enabled = isNextEnabled,
                    modifier = Modifier.height(50.dp)
                ) {
                    val buttonText = if (currentStep == 4) "Gerar Flashcards!" else "Próximo"
                    Text(buttonText, fontWeight = FontWeight.Bold)
                    if (currentStep < 4) {
                        Icon(Icons.Default.ArrowForward, contentDescription = null)
                    } else {
                        Icon(
                            Icons.Default.AutoAwesome,
                            contentDescription = null,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

// Esse composable indica em que posição da Etapa está o usuário
@Composable
fun StepIndicator(steps: List<Etapas>, currentStep: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        steps.forEach { step ->
            val isActive = step.number == currentStep
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = if (isActive) YellowAccent else CardBackground
                    ),
                    modifier = Modifier.size(32.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "${step.number}",
                            color = if (isActive) Color.Black else TextSecondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = step.title,
                    color = if (isActive) YellowAccent else TextSecondary,
                    fontSize = 12.sp
                )
            }
        }
    }
}


// --- COMPONENTES PARA CADA ETAPA ---

@Composable
fun Step1_Name(name: String, onNameChange: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth() // Usa fillMaxWidth em vez de fillMaxHeight para melhor alinhamento
    ) {
        // Ícone corrigido, vindo de Icons.Filled
        Icon(
            imageVector = Icons.Filled.Build,
            contentDescription = null,
            tint = YellowAccent,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Vamos começar!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Dê um nome para o seu novo conjunto de estudos.",
            color = TextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp) // Adiciona padding para o texto não tocar as bordas
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Campo de texto corrigido, usando TextFieldDefaults do Material 3
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Ex: Biologia - Fotossíntese") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = YellowAccent, // <-- Correct parameter name
                cursorColor = YellowAccent,
                focusedLabelColor = YellowAccent
            )
        )
    }
}

@Composable
fun Step2_Content(
    content: String,
    onContentChange: (String) -> Unit,

    // Novos parametros:
    selectedFileUri: Uri?,
    onFileSelected: (Uri?) -> Unit
) {
    // PEga o contexto atual, necessário para obter o nome do arquivo
    val context = LocalContext.current

    // 1. Cria o launcher para atividade de seleção de arquivo

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {

            // 2. Callback que é executado quando o usuário seleciona um arquivo (ou cancela)
                uri: Uri? ->
            onFileSelected(uri)
        }
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top, // Alinhado ao topo para dar espaço ao TextField
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Forneça o Conteúdo", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(
            "Escolha como inserir o seu material de estudo.",
            color = TextSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // Adicionar lógica para alternar entre texto e upload
            Button(onClick = { /*TODO*/ }) { Text("Digitar Texto") }

            //Lógica para pegar os arquivos:
            OutlinedButton(onClick = {
                // 3. AÇÃO: É aqui onde vai ficar as ações dos arquivos:
                filePickerLauncher.launch("*/*") //Significado : */* -> Pode pegar qualquer tipo de arquivo selecionado

            }) { Text("Upload de Arquivo") }
        }

        Spacer(modifier = Modifier.height(16.dp))


        // 4. EXIBIÇÃO DO ARQUIVO SELECIONADO: mostra o nome do arquivo, se houver

        if (selectedFileUri != null) {
            Text(
                text = "Arquivo Selecionado: ${getFileName(context, selectedFileUri)}",
                color = YellowAccent,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)

            )
        } else {
            OutlinedTextField(
                value = content,
                onValueChange = onContentChange,
                label = { Text("Cole aqui o texto...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Ocupa o espaço restante
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = YellowAccent, // <-- Correct parameter name
                    cursorColor = YellowAccent,
                    focusedLabelColor = YellowAccent
                )
            )
        }
    }
}

fun getFileName(context: Context, uri: Uri): String {
    var fileName: String? = null
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        if (it.moveToFirst()) {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1) {
                fileName = it.getString(nameIndex)
            }
        }
    }
    return fileName ?: "Desconhecido"
}

@Composable
fun Step3_Quantity(quantity: Float, onQuantityChange: (Float) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Icon(
            Icons.Default.FormatListBulleted,
            contentDescription = null,
            tint = YellowAccent,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Quantidade de Flashcards", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(
            "Escolha quantos flashcards você quer gerar.",
            color = TextSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = quantity.roundToInt().toString(),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = YellowAccent
        )

        Slider(
            value = quantity,
            onValueChange = onQuantityChange,
            valueRange = 5f..20f,
            steps = 14, // (20-5)-1 = 14 steps para valores inteiros
            modifier = Modifier.padding(horizontal = 16.dp),
            colors = SliderDefaults.colors(
                thumbColor = YellowAccent,
                activeTrackColor = YellowAccent
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("5", color = TextSecondary)
            Text("20", color = TextSecondary)
        }
    }
}


@Composable
fun DifficultyCard(title: String, description: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, if (isSelected) YellowAccent else Color.Transparent),
        colors = CardDefaults.cardColors(containerColor = CardBackground)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isSelected) {
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = YellowAccent)
            } else {
                Icon(
                    Icons.Default.RadioButtonUnchecked,
                    contentDescription = null,
                    tint = TextSecondary
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) YellowAccent else Color.White
                )
                Text(description, fontSize = 14.sp, color = TextSecondary)
            }
        }
    }
}

@Preview
@Composable
fun teste() {
    TelaCriacaoFlashCard(navController = NavController(LocalContext.current))
}

