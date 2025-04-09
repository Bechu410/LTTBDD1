package com.example.bai2_tuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bai2_tuan3.ui.theme.Bai2_tuan3Theme
import com.example.bai2_tuan3.R
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.*
import kotlinx.coroutines.delay



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("screen1") { ScreenFirst(navController) }
        composable("screen2") { ScreenSecond(navController) }
        composable("screen3") { ScreenThird(navController) }
    }
}


@Composable
fun WelcomeScreen(navController: NavHostController){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("screen1")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.uthlogo),
            contentDescription = "uthlogo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "UTH SmartTasks",
            fontSize = 30.sp,
            color = Color(0xFF2196F3),
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ScreenFirst(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Row() {
//            Text(
//                text = "skip",
//
//            )
//        }
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp, top = 100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ptsecond),
                contentDescription = "anh2",
                modifier = Modifier.size(280.dp)
            )

            Text(
                text = "Easy Time Management",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(top = 16.dp, bottom = 16.dp)
            )

            Text(
                text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(start = 5.dp, end = 5.dp)
            )

            Button(
                onClick = {navController.navigate("screen2")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .padding(top = 200.dp, bottom = 20.dp)
                    .fillMaxWidth(0.9f)
                    .height(50.dp),


            ) {
                Text("Next")
            }
        }
    }
}


@Composable
fun ScreenSecond(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ptthird),
                contentDescription = "anh3",
                modifier = Modifier.size(280.dp)
            )

            Text(
                text = "Increase Work Effectiveness",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(top = 16.dp, bottom = 16.dp)
            )

            Text(
                text = "Time management and the determination of more important tasks will give your job statistics better and always improve ",
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(start = 5.dp, end = 5.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate("screen1") },
                    modifier = Modifier.size(45.dp), // Kích thước nút
                    shape = CircleShape, // Hình tròn
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)), // Màu nền xanh
                    contentPadding = PaddingValues(0.dp) // Loại bỏ padding mặc định
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp), // Đặt kích thước biểu tượng
                        tint = Color.White // Màu trắng
                    )
                }

                // Nút "Get Started" (dài hơn, bo tròn)
                Button(
                    onClick = { navController.navigate("screen3")},
                    modifier = Modifier
                        .weight(1f) // Nút chiếm hết phần còn lại của Row
                        .height(50.dp), // Chiều cao giống nút Back
                    shape = RoundedCornerShape(40.dp), // Bo tròn
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}



@Composable
fun ScreenThird(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ptfouth),
                contentDescription = "anh4",
                modifier = Modifier.size(280.dp)
            )

            Text(
                text = "Reminder Notification",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(top = 16.dp, bottom = 16.dp)
            )

            Text(
                text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set ",
                textAlign = TextAlign.Center,
                modifier = Modifier .padding(start = 5.dp, end = 5.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate("screen2")},
                    modifier = Modifier.size(45.dp), // Kích thước nút
                    shape = CircleShape, // Hình tròn
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)), // Màu nền xanh
                    contentPadding = PaddingValues(0.dp) // Loại bỏ padding mặc định
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp), // Đặt kích thước biểu tượng
                        tint = Color.White // Màu trắng
                    )
                }

                // Nút "Get Started" (dài hơn, bo tròn)
                Button(
                    onClick = { /* Xử lý khi bấm get started */ },
                    modifier = Modifier
                        .weight(1f) // Nút chiếm hết phần còn lại của Row
                        .height(50.dp), // Chiều cao giống nút Back
                    shape = RoundedCornerShape(45.dp), // Bo tròn
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    val navController = rememberNavController() // Khởi tạo navController giả lập
    WelcomeScreen(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenFirst() {
    val navController = rememberNavController()
    ScreenFirst(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenSecond() {
    val navController = rememberNavController()
    ScreenSecond(navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenThird() {
    val navController = rememberNavController()
    ScreenThird(navController)
}