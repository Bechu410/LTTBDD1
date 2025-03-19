package com.example.bai1_tuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai1_tuan3.ui.theme.Bai1_tuan3Theme
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items









class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigator()
        }
    }
}


@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen { navController.navigate("componentsList") }
        }
        composable("componentsList") {
            ComponentsListScreen { navController.navigate("textDetail") } // <-- Kiểm tra dấu {}
        }

        composable("textDetail") {
            TextDetailScreen { navController.popBackStack() }
        }
    }
}


@Composable
fun WelcomeScreen(onGetStartedClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach",
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = onGetStartedClick,
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0C0303))
        ) {
            Text("I'm ready", fontSize = 16.sp)
        }
    }
}


@Composable
fun ComponentsListScreen(onTextClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "UI Components List",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(30.dp))
        }


        item {
            SectionTitle(title = "Display")
            ComponentCard(title = "Text", description = "Displays text", onClick = onTextClick)
            ComponentCard(title = "Image", description = "Displays an image")
        }


        item {
            SectionTitle(title = "Input")
            ComponentCard(title = "TextField", description = "Input field for text")
            ComponentCard(title = "PasswordField", description = "Input field for passwords")
        }

        
        item {
            SectionTitle(title = "Layout")
            ComponentCard(title = "Column", description = "Arranges elements vertically")
            ComponentCard(title = "Row", description = "Arranges elements horizontally")
        }
    }
}


@Composable
fun SectionTitle(title: String) {
    Spacer(modifier = Modifier.height(30.dp))
    Text(
        text = title,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(bottom = 5.dp)
    )
}


@Composable
fun ComponentCard(title: String, description: String, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFABDBFF))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(text = description, color = Color.Black)
        }
    }
}





@Composable
fun TextDetailScreen(onBackPress: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            IconButton(onClick = onBackPress) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint =  Color(0xFF2196F3),
                )
            }
            Text(
                text = "Text Detail",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buildAnnotatedString {
                    append("The ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append("quick ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFF9C6615), fontWeight = FontWeight.Bold)) {
                        append("Brown ")
                    }
                    append("\nfox j u m p s ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("over ")
                    }
                    append("\n")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("the ")
                    }
                    withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                        append("lazy ")
                    }
                    append("dog.")
                },
                fontSize = 30.sp
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen {}
}

@Preview(showBackground = true)
@Composable
fun PreviewComponentListScreen() {
    ComponentsListScreen {}
}

@Preview(showBackground = true)
@Composable
fun PreviewTextDetailScreen() {
    TextDetailScreen {}
}



