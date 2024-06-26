@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.loginscreen.UiHome

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.loginscreen.Event.UserEvent
import com.example.loginscreen.R
import com.example.loginscreen.ViewModel.UserState

@Preview
@Composable
fun Login(
    state:UserState,
    Onclick:(UserEvent) -> Unit,
){
    var passwrd by remember {
        mutableStateOf("")
    }

    var logID by remember {
        mutableStateOf("")
    }
    var showPassword by remember { mutableStateOf(value = false) }

   Column(
       modifier = Modifier
           .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Spacer(modifier = Modifier.weight(1.2f))
           AsyncImage(
               model = "https://cdn.pixabay.com/photo/2017/01/31/13/14/animal-2023924_1280.png",
               contentDescription ="Logo",
               placeholder = painterResource(id = R.drawable.ic_launcher_background),
//               error = painterResource(id = R.drawable.ic_launcher_background),
               alignment = Alignment.Center,
               modifier = Modifier
                   .width(100.dp)
                   .height(100.dp)
           )

       Spacer(modifier = Modifier.weight(0.3f))

       OutlinedTextField(
           value = logID,
           onValueChange ={id->
               logID = id
           },label = {
               Text(text = "LoginId")
           },
           modifier = Modifier.width(330.dp),
           singleLine = true,
           shape = RoundedCornerShape(15.dp),
           textStyle = TextStyle(color = Color.Black)
       )

       Spacer(modifier = Modifier.weight(0.1f))

       OutlinedTextField(
           value = passwrd,
           onValueChange ={PD ->
               passwrd = PD

           },label = {
               Text(text = "Password")
           },
           modifier = Modifier.width(330.dp),
           singleLine = true,
           shape = RoundedCornerShape(15.dp),
           textStyle = TextStyle(color = Color.Black),
           visualTransformation = if (showPassword){
               VisualTransformation.None
           }else{
               PasswordVisualTransformation()
           },keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
           trailingIcon = {
               if (showPassword) {
                   IconButton(onClick = { showPassword = false }) {
                       Icon(
                           imageVector = Icons.Filled.Visibility,
                           contentDescription = "hide_password"
                       )
                   }
               } else {
                   IconButton(
                       onClick = { showPassword = true }) {
                       Icon(
                           imageVector = Icons.Filled.VisibilityOff,
                           contentDescription = "hide_password"
                       )
                   }
               }
           }
       )


       Spacer(modifier = Modifier.weight(0.1f))

       Button(
           onClick = {
               Log.d(passwrd,"password")
               Log.d(logID,"logid")
           },
           modifier = Modifier
               .width(330.dp)
               .height(40.dp),
           shape = RoundedCornerShape(30.dp)

       ) {
           Text(
               text = "Log In",
               fontWeight = FontWeight.Bold
           )

       }

       Spacer(modifier = Modifier.weight(0.1f))

       Text(
           text ="Forget Password?",
           fontSize = 14.sp
           )

       Spacer(modifier = Modifier.weight(0.7f))

       Button(
           onClick = {
                     
           },
           modifier = Modifier
               .width(330.dp)
               .height(40.dp),
           shape = RoundedCornerShape(30.dp),
           contentPadding = ButtonDefaults.ContentPadding

       ) {
           Text(
               text = "Create new account",
               fontWeight = FontWeight.Bold
           )

       }

       Spacer(modifier = Modifier.weight(0.2f))

   }

}