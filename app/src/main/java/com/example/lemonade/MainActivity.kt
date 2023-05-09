package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppLimonada()
                }
            }
        }
    }
}
@Preview
@Composable
fun AppLimonada(){
    var tela by remember { mutableStateOf(1) }
    var espremer by remember { mutableStateOf(1) }
    when(tela){
        1-> ConteudoApp(R.string.limoeiro, R.drawable.lemon_tree){
            espremer = (2..4). random()
        tela=2}
        2-> ConteudoApp(R.string.limao, R.drawable.lemon_squeeze){
            if (espremer > 0)
                espremer--
            else
            tela=3}
        3-> ConteudoApp(R.string.limonada, R.drawable.lemon_drink)
        {tela=4}
        4-> ConteudoApp(R.string.copo_vazio, R.drawable.lemon_restart)
        {tela=1}
    }
}
@Composable
fun ConteudoApp(
    idTexto:Int,
    idImagem:Int,
    onClickImagem:()->Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),

        ) {


        Text(
            text = stringResource(idTexto),
            textAlign = TextAlign.Center,
            fontSize = 19.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 13.dp)

        )
        Image(
            painter = painterResource(id = idImagem) ,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .border(
                    BorderStroke(3.dp, color = Color.Black),
                    RoundedCornerShape(9.dp)
                )
                .clickable(onClick = onClickImagem)
        )
    }
}