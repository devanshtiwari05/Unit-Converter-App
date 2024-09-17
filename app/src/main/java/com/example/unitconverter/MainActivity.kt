package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}
@Composable
fun UnitConverter(){
    var inputValue by remember{ mutableStateOf("") }
    var outputValue by remember{ mutableStateOf("") }
    var inputUnit by remember{ mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iexpanded by remember{ mutableStateOf(false) }
    var oexpanded by remember{ mutableStateOf(false) }
    val iconversionFactor=remember{ mutableStateOf(1.0) }
    val oconversionFactor=remember{ mutableStateOf(1.0) }
    fun converter(){
        var inputValueDouble=inputValue.toDoubleOrNull()?:0.0
        var result=(inputValueDouble/iconversionFactor.value)*oconversionFactor.value
        outputValue=result.toString()
    }
    Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Unit Converter",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue=it
            converter()
        },
            label = { Text(text = "Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { iexpanded=true } ) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iexpanded, onDismissRequest = {iexpanded=false}) {
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=1.0
                        inputUnit="Meters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=100.0
                        inputUnit="Centimeters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=1000.0
                        inputUnit="Millimeters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Foot") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=1.0
                        inputUnit="Foot"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Inches") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=1.0
                        inputUnit="Inches"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=0.001
                        inputUnit="Kilometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Nanometers") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=Math.pow(10.0,9.0)
                        inputUnit="Nanometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Micrometers") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=Math.pow(10.0,6.0)
                        inputUnit="Micrometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Yard") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=1.094
                        inputUnit="Yard"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Mile") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=(1.0/1609.0)
                        inputUnit="Mile"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Nautical Mile") }, onClick = {
                        iexpanded=false
                        iconversionFactor.value=(1.0/1852.0)
                        inputUnit="Nautical Mile"
                        converter()
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oexpanded=true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oexpanded, onDismissRequest = {oexpanded=false}) {
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=1.0
                        outputUnit="Meters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=100.0
                        outputUnit="Centimeters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=1000.0
                        outputUnit="Millimeters"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Foot") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=3.281
                        outputUnit="Foot"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Inches") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=39.37
                        outputUnit="Inches"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "kilometers") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=0.001
                        outputUnit="kilometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Nanometers") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=Math.pow(10.0,9.0)
                        outputUnit="Nanometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Micrometers") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=Math.pow(10.0,6.0)
                        outputUnit="Micrometers"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Yard") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=1.094
                        outputUnit="Yard"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Mile") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=(1.0/1609.0)
                        outputUnit="Mile"
                        converter()
                    })
                    DropdownMenuItem(text = { Text(text = "Nautical Mile") }, onClick = {
                        oexpanded=false
                        oconversionFactor.value=(1.0/1852.0)
                        outputUnit="Nautical Mile"
                        converter()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result : ${outputValue} ${outputUnit}",
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.headlineSmall,
            )
    }


}
@Composable
@Preview(showBackground = true)
fun UnitConverterPriview(){
    UnitConverter()
}




