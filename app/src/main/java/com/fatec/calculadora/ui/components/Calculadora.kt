package com.fatec.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calculadora() {

    var input1 by rememberSaveable {
        mutableStateOf("") }
    var input2 by rememberSaveable {
        mutableStateOf("") }
    var selectedOperation by rememberSaveable {
        mutableStateOf<String?>(null)}
    var result by rememberSaveable {
        mutableStateOf<Double?>(null) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

        ) {
            Text(text = result?.toString() ?: "O resultado será mostrado aqui",
                modifier = Modifier.padding(16.dp))
        }
        TextField(value = input1,
            onValueChange = {input1 = it},
            label = { Text("1º numero")},
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ){
        OperationButton("+"){selectedOperation = "+"}
        OperationButton("-"){selectedOperation = "-"}
        OperationButton("*") {selectedOperation = "*"}
        OperationButton("/") {selectedOperation = "/"}
    }
    Spacer(modifier = Modifier.height(16.dp))

    TextField(
        value = input2,
        onValueChange = {input2 = it},
        label = { Text("2º numero" )},
        modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = calculateResult(input1, input2, selectedOperation)
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("=")
        }
    }
}

fun calculateResult(input1: String, input2: String, operation: String?): Double? {
    val num1 = input1.toDoubleOrNull()
    val num2 = input2.toDoubleOrNull()

    if (num1 != null && num2 != null && operation != null){
        return when (operation){
            "+" -> num1+num2
            "-" -> num1-num2
            "*" -> num1*num2
            "/" -> if(num2 != 0.0) num1/num2 else null
            else -> null
        }
    }
    return null
}

@Composable
fun OperationButton(operation: String,onClick:() -> Unit) { 
    Button(onClick = onClick, modifier = Modifier.padding(4.dp)){
    Text(operation)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorScreen(){
    Calculadora()
}





