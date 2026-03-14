fun main() {

    val initialMetric = arrayOf(27.0, 350.0, 10.0)

    printFinalTemperature(
        initialMeasurement = initialMetric[0],
        initialUnit = "Celsius",
        finalUnit = "Fahrenheit",
        conversionFormula = {9/5.toDouble() * it + 32}     //c_To_F(initialMetric[0]) 
    )
    printFinalTemperature(
        initialMeasurement = initialMetric[1],
        initialUnit = "Kelvin",
        finalUnit = "Celsius",
        conversionFormula = {it - 273.15}       //c_To_F(initialMetric[1]) 
    )
    printFinalTemperature(
        initialMeasurement = initialMetric[2],
        initialUnit = "Fahrenheit",
        finalUnit = "Kelvin",
        conversionFormula = {5/9.toDouble() * (it - 32) + 273.15}       //c_To_F(initialMetric[2]) 
    )
    
}

// fun c_To_F(value: Double): Double{             // Just another way to do it
//     return (9/5.toDouble() * value + 32)

// }

// fun k_To_C(value: Double): Double{

//     return (value - 273.15)
// }

// fun f_to_K(value: Double): Double{

//     return (5/9.toDouble() * (value - 32) + 273.15)
// }


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}