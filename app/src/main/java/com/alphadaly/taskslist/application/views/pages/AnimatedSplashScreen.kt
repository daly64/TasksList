package com.alphadaly.taskslist.application.views.pages

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alphadaly.taskslist.application.navigation.Screen
import com.alphadaly.taskslist.ui.theme.app_name
import com.alphadaly.taskslist.ui.theme.mainIcon
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.robotoBold
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(main_color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier
                    .size(150.dp)
                    .alpha(alpha = alpha),
                imageVector = mainIcon,
                contentDescription = "Logo Icon",
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .alpha(alpha = alpha),
                text = app_name,
                color = Color.White,
                fontFamily = robotoBold,
                fontSize = 40.sp
            )
        }

    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}
