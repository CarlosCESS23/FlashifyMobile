# <img alt="Flashify Logo" height="45" style="vertical-align: middle; margin-right: 8px;" src="https://github.com/user-attachments/assets/6af903aa-cc5c-4bb5-8a60-af64c918de98" /> Flashify Mobile


<div align="center">

![Platform](https://img.shields.io/badge/Plataforma-Android-3DDC84?style=for-the-badge&logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![FastAPI](https://img.shields.io/badge/FastAPI-009688?style=for-the-badge&logo=fastapi&logoColor=white)

**O aplicativo móvel de flashcards inteligente que transforma seus estudos com o poder da Inteligência Artificial**

[Recursos](#-recursos-principais) • [Tecnologias](#-tecnologias) • [Instalação](#-instalação) • [Arquitetura](#-arquitetura) • [Screenshots](#-capturas-de-tela)

</div>

---

## 📖 Sobre o Projeto

O **Flashify** é um aplicativo Android nativo que revoluciona a forma como você estuda. Utilizando **Google Vertex AI (Gemini)**, o app é capaz de extrair conteúdo de documentos e gerar automaticamente flashcards e quizzes personalizados, economizando horas de preparação de material de estudo.

### 🎯 Diferenciais

- ✨ **Geração Automática com IA**: Transforme PDFs e textos em flashcards prontos
- 📚 **Estudo Offline**: Acesse todo seu conteúdo sem conexão
- 📊 **Acompanhamento Inteligente**: Estatísticas detalhadas e sistema de streak
- 🎨 **Interface Moderna**: Design Flat com Material Design 3 e Jetpack Compose
- 🔄 **Sincronização em Tempo Real**: Seus dados sempre atualizados
- 🌓 **Modo Claro/Escuro**: Tema adaptável com transições suaves

---

## 🚀 Recursos Principais

### 🧠 Inteligência Artificial

- **Geração Automática de Flashcards**
  - Upload de documentos (PDF, TXT, DOCX)
  - Extração inteligente de conceitos-chave
  - Criação de perguntas e respostas contextualizadas
  - Níveis de dificuldade personalizáveis (Fácil, Médio, Difícil)

- **Geração de Quizzes**
  - Perguntas de múltipla escolha geradas por IA
  - Explicações detalhadas para cada resposta
  - Validação em tempo real
  - Feedback imediato sobre acertos e erros

- **Sistema de Limite de Gerações**
  - Controle de uso diário da IA (10 gerações/dia)
  - Barra de progresso visual do consumo
  - Reset automático a cada 24 horas
  - Notificações quando próximo do limite

### 📚 Gestão de Conteúdo

- **Biblioteca Organizada**
  - Criação ilimitada de decks
  - Sistema de pastas hierárquico
  - Busca e filtros inteligentes
  - Movimentação drag-and-drop entre pastas
  - Edição e renomeação em tempo real

- **Flashcards Personalizáveis**
  - Criação manual ou automática
  - Edição inline de perguntas e respostas
  - Adição incremental com IA (até 20 cards por deck)
  - Animação de flip para revelação de respostas
  - Sistema de "Acertei/Errei" para tracking

### 🎮 Modos de Estudo

#### 📖 Modo Flashcard Clássico
- Interface minimalista focada no conteúdo
- Sistema de avaliação por card
- Progresso em tempo real
- Temporizador de sessão
- Estatísticas pós-estudo

#### 🎯 Modo Quiz
- Perguntas de múltipla escolha
- 4-5 alternativas por questão
- Sistema de pontuação
- Explicações detalhadas
- Histórico de tentativas

### 📊 Acompanhamento de Progresso

- **Dashboard Completo**
  - Precisão geral (flashcards e quizzes)
  - Streak de dias consecutivos
  - Cards estudados na semana
  - Gráfico de atividade semanal
  - Taxa de acerto por deck

- **Sistema de Conquistas**
  - Semana Completa (7 dias de streak)
  - Mestre da Consistência (30 dias)
  - Estudante Dedicado (50+ cards/semana)
  - Precisão Perfeita (90%+ de acertos)

- **Estatísticas Detalhadas**
  - Gráficos circulares de desempenho
  - Comparação flashcards vs quizzes
  - Evolução temporal
  - Cards dominados vs em revisão

### 🔄 Sincronização e Conectividade

- **Sistema de Sincronização Inteligente**
  - Detecção automática de conectividade
  - Banner visual de status (Online/Offline)
  - Indicador compacto na tela principal
  - Contagem de itens pendentes
  - Sincronização manual sob demanda

- **Modo Offline Completo**
  - Banco de dados local (Room)
  - Acesso total sem internet
  - Cache de todos os decks
  - Sincronização automática ao reconectar

- **Gerenciamento de Conflitos**
  - Last-write-wins
  - Badges de status de sincronização
  - Retry automático em caso de falha

### 🎨 Interface e Experiência

- **Design System Consistente**
  - Material Design 3
  - Componentes reutilizáveis
  - Animações fluidas (Jetpack Compose)
  - Transições de página suaves

- **Temas Adaptativos**
  - Modo Claro com gradiente amarelo suave
  - Modo Escuro profundo
  - Transição suave entre temas
  - Persistência de preferência

- **Navegação Intuitiva**
  - Bottom Navigation com 5 abas
  - Indicadores visuais de seleção
  - Ícones animados
  - Feedback tátil

### 🛡️ Autenticação e Segurança

- **Múltiplos Métodos de Login**
  - Email e senha
  - Google OAuth 2.0
  - Validação de força de senha
  - Recovery de senha

- **Gerenciamento de Sessão**
  - Tokens JWT seguros
  - Refresh automático
  - Logout em todos os dispositivos
  - Proteção contra CSRF

### 💬 Suporte e Feedback

- **Central de Ajuda Integrada**
  - Relatório de bugs com categorização
  - Formulário de experiência do usuário
  - Sistema de sugestões de melhorias
  - Envio direto para Discord via webhooks

- **Manual do Usuário**
  - Guias passo-a-passo
  - Tutoriais interativos
  - FAQ integrado
  - Seção de consumo de IA

---

## 🛠️ Tecnologias

### 📱 Frontend (Android)

#### **Core**
- **Kotlin** 1.9+ - Linguagem principal
- **Jetpack Compose** - UI declarativa moderna
- **Material Design 3** - Design system

#### **Arquitetura**
- **MVVM** - Separação de responsabilidades
- **Clean Architecture** - Camadas bem definidas
- **Hilt** - Injeção de dependências
- **Coroutines + Flow** - Programação assíncrona reativa

#### **Persistência**
- **Room** 2.6+ - Banco de dados SQLite
- **DataStore** - Armazenamento de preferências
- **SharedPreferences** - Cache de configurações

#### **Networking**
- **Retrofit** 2.9+ - Cliente HTTP
- **OkHttp** - Interceptors e logging
- **Gson** - Serialização JSON
- **Coil** - Carregamento de imagens

#### **Navegação**
- **Compose Navigation** - Navegação declarativa
- **Deep Links** - Navegação por URL

#### **Monitoramento**
- **Timber** - Logging estruturado
- **LeakCanary** - Detecção de memory leaks

### ⚙️ Backend (API)

#### **Core**
- **Python 3.10+** - Linguagem principal
- **FastAPI** - Framework web assíncrono
- **Uvicorn** - Servidor ASGI
- **Pydantic** - Validação de dados

#### **Banco de Dados**
- **PostgreSQL** 14+ - Database principal
- **SQLAlchemy** - ORM
- **Alembic** - Migrations

#### **Autenticação**
- **JWT** - Tokens de autenticação
- **Passlib** - Hash de senhas
- **Python-Jose** - Manipulação de JWT
- **OAuth2** - Login social

#### **Inteligência Artificial**
- **Google Vertex AI** - Plataforma de IA
- **Gemini Pro** - Modelo de linguagem
- **LangChain** - Orquestração de LLMs
- **PyPDF2** - Extração de texto de PDFs
- **Pytesseract** - OCR para imagens

#### **Processamento Assíncrono**
- **Celery** 5.3+ - Task queue
- **Redis** - Message broker
- **Flower** - Monitoramento de tasks

#### **Infraestrutura**
- **Docker** - Containerização
- **Docker Compose** - Orquestração
- **Nginx** - Reverse proxy
- **Gunicorn** - WSGI server

#### **Monitoring & Logging**
- **Prometheus** - Métricas
- **Grafana** - Dashboards
- **Sentry** - Error tracking
- **ELK Stack** - Logs centralizados

---

## 📂 Estrutura do Projeto
```
flashify-mobile/
│
├── 📁 front/                      # Aplicativo Android
│   ├── 📁 app/
│   │   ├── 📁 src/
│   │   │   ├── 📁 main/
│   │   │   │   ├── 📁 java/com/example/flashify/
│   │   │   │   │   │
│   │   │   │   │   ├── 📁 model/              # Camada de Dados
│   │   │   │   │   │   ├── 📁 data/           # DTOs e Models
│   │   │   │   │   │   │   ├── User.kt
│   │   │   │   │   │   │   ├── Deck.kt
│   │   │   │   │   │   │   ├── Flashcard.kt
│   │   │   │   │   │   │   └── Quiz.kt
│   │   │   │   │   │   │
│   │   │   │   │   │   ├── 📁 database/       # Room Database
│   │   │   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   │   │   ├── DeckDao.kt
│   │   │   │   │   │   │   └── FlashcardDao.kt
│   │   │   │   │   │   │
│   │   │   │   │   │   ├── 📁 network/        # Retrofit API
│   │   │   │   │   │   │   ├── ApiService.kt
│   │   │   │   │   │   │   └── NetworkModule.kt
│   │   │   │   │   │   │
│   │   │   │   │   │   ├── 📁 manager/        # Gerenciadores
│   │   │   │   │   │   │   ├── TokenManager.kt
│   │   │   │   │   │   │   ├── ThemeManager.kt
│   │   │   │   │   │   │   └── SyncManager.kt
│   │   │   │   │   │   │
│   │   │   │   │   │   └── 📁 util/           # Utilitários
│   │   │   │   │   │       ├── Constants.kt
│   │   │   │   │   │       └── Rotas.kt
│   │   │   │   │   │
│   │   │   │   │   ├── 📁 view/               # Camada de UI
│   │   │   │   │   │   ├── 📁 ui/
│   │   │   │   │   │   │   ├── 📁 components/ # Componentes Reutilizáveis
│   │   │   │   │   │   │   │   ├── NavBar.kt
│   │   │   │   │   │   │   │   ├── AddContentDialog.kt
│   │   │   │   │   │   │   │   ├── ConnectivityIndicator.kt
│   │   │   │   │   │   │   │   └── GenerationLimitBar.kt
│   │   │   │   │   │   │   │
│   │   │   │   │   │   │   ├── 📁 screen/     # Telas
│   │   │   │   │   │   │   │   ├── 📁 login/
│   │   │   │   │   │   │   │   │   ├── TelaLogin.kt
│   │   │   │   │   │   │   │   │   ├── TelaRegistro.kt
│   │   │   │   │   │   │   │   │   └── AuthComponents.kt
│   │   │   │   │   │   │   │   │
│   │   │   │   │   │   │   │   ├── 📁 principal/
│   │   │   │   │   │   │   │   │   ├── TelaPrincipal.kt
│   │   │   │   │   │   │   │   │   ├── TelaBiblioteca.kt
│   │   │   │   │   │   │   │   │   ├── TelaCriacaoFlashCard.kt
│   │   │   │   │   │   │   │   │   ├── TelaEstudo.kt
│   │   │   │   │   │   │   │   │   ├── TelaQuiz.kt
│   │   │   │   │   │   │   │   │   ├── TelaProgresso.kt
│   │   │   │   │   │   │   │   │   └── TelaConfiguracao.kt
│   │   │   │   │   │   │   │   │
│   │   │   │   │   │   │   │   └── 📁 suporte/
│   │   │   │   │   │   │   │       ├── TelaCentralAjuda.kt
│   │   │   │   │   │   │   │       ├── BugReportForm.kt
│   │   │   │   │   │   │   │       ├── ExperienceForm.kt
│   │   │   │   │   │   │   │       └── SuggestionForm.kt
│   │   │   │   │   │   │   │
│   │   │   │   │   │   │   └── 📁 theme/      # Tema
│   │   │   │   │   │   │       ├── Color.kt
│   │   │   │   │   │   │       ├── Theme.kt
│   │   │   │   │   │   │       └── Type.kt
│   │   │   │   │   │
│   │   │   │   │   └── 📁 viewmodel/          # ViewModels
│   │   │   │   │       ├── DeckViewModel.kt
│   │   │   │   │       ├── StudyViewModel.kt
│   │   │   │   │       ├── QuizViewModel.kt
│   │   │   │   │       ├── HomeViewModel.kt
│   │   │   │   │       └── SettingsViewModel.kt
│   │   │   │   │
│   │   │   │   ├── 📁 res/                    # Recursos
│   │   │   │   │   ├── 📁 drawable/           # Imagens e ícones
│   │   │   │   │   ├── 📁 values/             # Strings, cores, estilos
│   │   │   │   │   └── 📁 font/               # Fontes customizadas
│   │   │   │   │
│   │   │   │   └── AndroidManifest.xml
│   │   │   │
│   │   │   ├── 📁 androidTest/                # Testes Instrumentados
│   │   │   └── 📁 test/                       # Testes Unitários
│   │   │
│   │   ├── build.gradle.kts                   # Configurações do módulo
│   │   └── proguard-rules.pro                 # Regras de ofuscação
│   │
│   ├── 📁 gradle/                             # Gradle Wrapper
│   ├── build.gradle.kts                       # Configurações do projeto
│   ├── settings.gradle.kts                    # Módulos do projeto
│   ├── gradle.properties                      # Propriedades do Gradle
│   └── local.properties                       # Configurações locais (gitignored)
│
└── 📁 back/                                   # Backend API
    ├── 📁 app/
    │   ├── 📁 api/                           # Endpoints
    │   ├── 📁 core/                          # Configurações
    │   ├── 📁 models/                        # Models do BD
    │   ├── 📁 schemas/                       # Schemas Pydantic
    │   ├── 📁 services/                      # Lógica de negócio
    │   ├── 📁 worker/                        # Celery tasks
    │   └── main.py                           # Entry point
    │
    ├── 📁 tests/                             # Testes
    ├── 📁 alembic/                           # Migrations
    ├── Dockerfile                            # Container da API
    ├── docker-compose.yml                    # Orquestração
    ├── requirements.txt                      # Dependências Python
    ├── .env.example                          # Exemplo de variáveis
    └── gcp-credentials.json                  # Credenciais GCP (gitignored)
```

---

## 🚀 Instalação

### Pré-requisitos

- **Android Studio** Hedgehog (2023.1.1) ou superior
- **JDK** 17+
- **Python** 3.10+
- **Docker** & **Docker Compose**
- **PostgreSQL** 14+ (ou via Docker)
- **Redis** 6+ (ou via Docker)
- Conta **Google Cloud** com Vertex AI habilitado

### 1️⃣ Configurando o Backend
```bash
# Clone o repositório
git clone https://github.com/seu-usuario/flashify-mobile.git
cd flashify-mobile/back

# Crie e configure o arquivo .env
cp .env.example .env
nano .env  # Configure suas variáveis

# Adicione suas credenciais do Google Cloud
# Baixe o arquivo JSON do GCP e salve como gcp-credentials.json

# Suba os containers (PostgreSQL, Redis e API)
docker-compose up -d --build

# Verifique os logs
docker-compose logs -f app

# A API estará rodando em http://localhost:8000
# Documentação interativa em http://localhost:8000/docs
```

#### Variáveis de Ambiente Necessárias (.env)
```env
# Database
DATABASE_URL=postgresql://user:password@localhost:5432/flashify_db

# JWT
SECRET_KEY=sua-chave-secreta-super-segura
ALGORITHM=HS256
ACCESS_TOKEN_EXPIRE_MINUTES=30

# Google Cloud
GOOGLE_APPLICATION_CREDENTIALS=./gcp-credentials.json
GCP_PROJECT_ID=seu-projeto-gcp

# Redis
REDIS_URL=redis://localhost:6379/0

# Celery
CELERY_BROKER_URL=redis://localhost:6379/0
CELERY_RESULT_BACKEND=redis://localhost:6379/0

# Limites
MAX_FLASHCARDS_PER_DECK=20
MAX_QUESTIONS_PER_QUIZ=15
DAILY_GENERATION_LIMIT=10
```

### 2️⃣ Configurando o Frontend (Android)
```bash
# Entre na pasta do projeto Android
cd ../front

# Abra o projeto no Android Studio
# File > Open > Selecione a pasta 'front'

# Aguarde o Gradle sincronizar

# Configure o endereço da API
# Edite: app/src/main/java/com/example/flashify/model/network/ApiService.kt
```

**Importante**: Configure a `BASE_URL` no `ApiService.kt`:
```kotlin
// Para emulador Android
private const val BASE_URL = "http://10.0.2.2:8000/"

// Para dispositivo físico (substitua pelo IP da sua máquina)
private const val BASE_URL = "http://192.168.0.10:8000/"
```

### 3️⃣ Executando o App

1. No Android Studio, clique em **Run** ▶
2. Selecione um emulador ou dispositivo físico
3. Aguarde a instalação e inicialização
4. Faça o cadastro ou login
5. Pronto! Comece a criar seus decks 🎉

---

## 🏗️ Arquitetura

### Frontend (MVVM + Clean Architecture)
```
┌─────────────────────────────────────────────────────────┐
│                        UI LAYER                         │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐      │
│  │  Screens    │  │ Components  │  │   Theme     │      │
│  │  (Compose)  │  │  (Reusable) │  │  (Colors)   │      │ 
│  └──────┬──────┘  └─────────────┘  └─────────────┘      │
│         │                                               │
└─────────┼───────────────────────────────────────────────┘
          │
          ▼
┌─────────────────────────────────────────────────────────┐
│                    VIEWMODEL LAYER                      │
│  ┌─────────────────────────────────────────────────┐    │
│  │  ViewModels (State Management + Business Logic) │    │
│  │  • DeckViewModel • StudyViewModel • etc         │    │
│  └──────────────────┬──────────────────────────────┘    │
│                     │                                   │
└─────────────────────┼───────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────┐
│                     MODEL LAYER                         │
│  ┌──────────┐  ┌──────────┐  ┌──────────────────┐       │
│  │   Room   │  │ Retrofit │  │    Managers      │       │
│  │ Database │◄─┤   API    │  │ (Token, Theme,   │       │
│  │  (Local) │  │ (Remote) │  │  Sync, etc)      │       │
│  └──────────┘  └──────────┘  └──────────────────┘       │
└─────────────────────────────────────────────────────────┘
```

### Backend (Layered Architecture)
```
┌─────────────────────────────────────────────────────────┐
│                      API LAYER                          │
│  ┌──────────────────────────────────────────────────┐   │
│  │  FastAPI Endpoints (REST)                        │   │
│  │  /auth, /decks, /flashcards, /quizzes, etc       │   │
│  └───────────────────┬──────────────────────────────┘   │
│                      │                                  │
└──────────────────────┼──────────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────────┐
│                   SERVICE LAYER                         │
│  ┌──────────────────────────────────────────────────┐   │
│  │  Business Logic Services                         │   │
│  │  • DeckService • FlashcardService • AIService    │   │
│  └───────────────────┬──────────────────────────────┘   │
│                      │                                  │
└──────────────────────┼──────────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────────┐
│                  REPOSITORY LAYER                       │
│  ┌────────────┐  ┌────────────┐  ┌──────────────────┐   │
│  │ PostgreSQL │  │   Celery   │  │   Vertex AI      │   │
│  │    (ORM)   │  │   Tasks    │  │   (Gemini)       │   │
│  └────────────┘  └────────────┘  └──────────────────┘   │
└─────────────────────────────────────────────────────────┘
```

---

## 🔒 Segurança

- ✅ Autenticação JWT com refresh tokens
- ✅ Hash de senhas com bcrypt
- ✅ Proteção contra SQL Injection (ORM)
- ✅ Rate limiting na API
- ✅ HTTPS obrigatório em produção
- ✅ Validação de entrada com Pydantic
- ✅ Sanitização de dados do usuário
- ✅ Tokens armazenados de forma segura (KeyStore)

---

## 📊 Métricas e Monitoramento

### KPIs Principais

- **Tempo de geração de flashcards**: ~5-10 segundos
- **Taxa de sucesso de sincronização**: >99%
- **Tempo de resposta da API**: <200ms (p95)
- **Consumo de bateria**: Otimizado para <5%/hora
- **Taxa de crash**: <0.1%

### Ferramentas de Monitoramento

- **Firebase Crashlytics** - Crash reporting
- **Firebase Analytics** - User analytics
- **Prometheus + Grafana** - Métricas do backend
- **Sentry** - Error tracking

---
## 👥 Equipe

Desenvolvido por:

- **Gabriel Fernandes** - *Full Stack Developer* - [GitHub](https://github.com/g-f307) | [LinkedIn](https://www.linkedin.com/in/gabriel-fernandes-7684b4220/)
- **Carlos Eduardo Souza** - *Front-end Developer* -[GitHub](https://github.com/CarlosCESS23) | [LinkedIn](https://www.linkedin.com/in/carlos-souza-5843b11bb/)
- **Rebecca Souza Xavier** - *UX/UI Designer*
- **Yasmim Pessoa da Frota** - *UX/UI Designer*

---

[⬆ Voltar ao topo](#-flashify-mobile)

</div>
