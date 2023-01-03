package com.ayousuf.playcompose.ui.compose.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayousuf.playcompose.R
import com.ayousuf.playcompose.ui.theme.Purple500
import com.ayousuf.playcompose.util.showToast


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  3/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */

@Preview(showBackground = true)
@Composable
fun CreateSimpleText() {
    Text(
        text = stringResource(id = R.string.hello_compose),
        color = Color.Blue,
        fontSize = 25.sp,
        fontStyle = FontStyle.Italic
    )
}

@Preview(showBackground = true)
@Composable
fun CreateCenterText() {
    Text(
        text = stringResource(id = R.string.hello_compose),
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(180.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateTextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = stringResource(id = R.string.hello_compose),
        style = TextStyle(
            fontSize = 30.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CreateTextWithDifferentFonts() {
    Column {
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = FontFamily.Serif)
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = FontFamily.SansSerif)
    }
}

@Preview(showBackground = true)
@Composable
fun CreateTextWithCustomFont() {
    val ubuntuFamily = FontFamily(
        Font(R.font.ubuntu_light, FontWeight.Light),
        Font(R.font.ubuntu_regular, FontWeight.Normal),
        Font(R.font.ubuntu_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.ubuntu_medium, FontWeight.Medium),
        Font(R.font.ubuntu_bold, FontWeight.Bold)
    )

    Column {
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = ubuntuFamily, fontWeight = FontWeight.Light)
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = ubuntuFamily, fontWeight = FontWeight.Normal)
        Text(
            stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = ubuntuFamily, fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic
        )
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = ubuntuFamily, fontWeight = FontWeight.Medium)
        Text(stringResource(id = R.string.hello_compose), fontSize = 25.sp, fontFamily = ubuntuFamily, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun CreateMultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("Com")
            }
            append("pose!")
        },
        fontSize = 25.sp
    )
}

@Preview(showBackground = true)
@Composable
fun CreateOverflowedText() {
    Text(
        stringResource(id = R.string.hello_compose).repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        fontSize = 25.sp
    )
}

@OptIn(ExperimentalTextApi::class)
@Preview(showBackground = true)
@Composable
fun CreateTextStyleWithBrush() {
    val gradientColors = listOf(Cyan, Blue, Purple500)

    Text(
        text = "Compose Text ❤️",
        style = TextStyle(
            brush = Brush.linearGradient(colors = gradientColors)
            //brush = SolidColor(Cyan)

        ),
        fontSize = 25.sp
    )
}

@OptIn(ExperimentalTextApi::class)
@Preview(showBackground = true)
@Composable
fun CreateTextFieldWithBrush() {
    val red = Color(0xFFDA034E)
    val orange = Color(0xFFFF9800)
    val yellow = Color(0xFFFFEB3B)
    val green = Color(0xFF4CAF50)
    val blue = Color(0xFF2196F3)
    val indigo = Color(0xFF3F51B5)
    val violet = Color(0xFF9C27B0)

    val rainbowColors = listOf(red, orange, yellow, green, blue, indigo, violet)
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(brush = brush, fontSize = 25.sp)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateSelectableText() {
    SelectionContainer {
        Text("This text is selectable", fontSize = 25.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePartiallySelectableText() {
    SelectionContainer {
        Column {
            Text("This text is selectable", fontSize = 25.sp)
            Text("This one too", fontSize = 25.sp)
            Text("This one as well", fontSize = 25.sp)
            DisableSelection {
                Text("But not this one", fontSize = 25.sp)
                Text("Neither this one", fontSize = 25.sp)
            }
            Text("But again, you can select this one", fontSize = 25.sp)
            Text("And this one too", fontSize = 25.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateSimpleClickableTextWithPosition() {
    val context = LocalContext.current
    ClickableText(
        text = AnnotatedString("Please Click Me"),
        style = TextStyle(fontSize = 25.sp),
        onClick = { offset ->
            context.showToast("$offset-th character clicked")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CreateSimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Preview(showBackground = true)
@Composable
fun CreateSimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Preview(showBackground = true)
@Composable
fun CreatePasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}