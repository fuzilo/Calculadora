package com.fatec.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fatec.calculadora.ui.components.Calculadora
import com.fatec.calculadora.ui.components.CounterScreen
import com.fatec.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        //Colocar uma caixa de texto para receber os resultados
                        //Vai ser um card que recebe valores de cálculo
                        //uma caixa de texto para primeiro imput
                            //Vai ser um card que recebe valores digitados
                        //quatro botões com as operações básicas
                        //Uma caixa de texto para segundo input
                            //Vai ser um card que recebe valores digitados
                        //um botão com símbolo "="
                        //ao clickar no botão igual, realizar a operação input1 (operação) input2 (igual) -> resultado
                        //resultado deve aparecer no primeiro card
                        //CounterScreen()
                        Calculadora()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        CounterScreen()
    }
}