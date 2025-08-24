package com.example.moviesta.Activity


import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesta.R



class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onLoginClick = {
                startActivity(Intent(this, MainActivity::class.java))
            })
        }
    }
}
@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen(onLoginClick = {})
}

@Composable
fun LoginScreen(onLoginClick:() ->Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.BlackBacground))
    ){
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column (
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ){
            Spacer(modifier = Modifier.height(128.dp))
            Text(text="Log in",
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier= Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.height(128.dp))
            GradientTextField(
                hint="Username",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            GradientTextField(
                hint="Password",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text="Forgot Password?",
                style = TextStyle(
                    color= colorResource(R.color.white),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(64.dp))
            Gradientbutton(
                text= "Login",
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            )
        }
    }
}
@Composable
fun Gradientbutton(
    text:String,
    modifier: Modifier = Modifier,
    onClick:()->Unit
){
    Button (onClick=onClick,
        modifier=modifier,
        shape=RoundedCornerShape(60.dp),
        border = BorderStroke
            (
            width=4.dp,
            brush= Brush.linearGradient(
                colors = listOf(colorResource(R.color.pink),colorResource(R.color.green)))
        ),
          colors = ButtonDefaults.buttonColors(contentColor = Color.White,containerColor= Color.Transparent)
        )
    {
        Text(text=text,fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradientTextField(
    hint:String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions=KeyboardOptions.Default,
){
      Box(
        modifier = modifier
            .height(60.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(colorResource(R.color.pink),colorResource(R.color.green))
                ),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(4.dp)
    ){
        OutlinedTextField(
            value="",
            onValueChange ={},
        placeholder = {
            Text(text=hint,
                color= Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        singleLine = true,
        textStyle = TextStyle(
            color = Color.White,
            textAlign = TextAlign.Center
        ),
            colors= TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
            ),
            keyboardOptions = keyboardOptions,
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = colorResource(R.color.black1),
                    shape = RoundedCornerShape(50.dp)
                )
                .align(Alignment.Center)
        )
    }
}