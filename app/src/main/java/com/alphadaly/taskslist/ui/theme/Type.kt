package com.alphadaly.taskslist.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.R

// Set of Material typography styles to start with
/*val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )*/
/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
//)

//fonts
val robotoRegular = FontFamily(Font(R.font.roboto_regular, weight = FontWeight.Normal))
val robotoBold = FontFamily(Font(R.font.roboto_bold, weight = FontWeight.Bold))
val robotoMedium = FontFamily(Font(R.font.roboto_medium, weight = FontWeight.Medium))

//text styles
val splash_screen_text =
    TextStyle(fontFamily = robotoBold, fontSize = 40.sp, color = background_color)
val card_title = TextStyle(fontFamily = robotoRegular, fontSize = 18.sp, color = text_color1)
val card_title_strikethrough = TextStyle(
    fontFamily = robotoRegular,
    fontSize = 18.sp,
    color = text_color2,
    textDecoration = TextDecoration.LineThrough
)
val body_text = TextStyle(fontFamily = robotoRegular, fontSize = 18.sp, color = text_color2)
val app_title_text = TextStyle(
    fontFamily = robotoMedium,
    fontSize = 20.sp,
    color = text_color1,
)
val button_text = TextStyle(fontFamily = robotoMedium, fontSize = 14.sp, color = main_color)
val caption = TextStyle(
    fontFamily = robotoMedium,
    color = text_color1,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
)

val Typography = Typography(
    defaultFontFamily = robotoRegular,

    )
