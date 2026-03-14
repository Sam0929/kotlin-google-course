/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    var traficLightColor = "Green"
   
    var message = if (traficLightColor == "Red") "STOP!"
    
    else if (traficLightColor == "Yellow") "SLOW!"
    
    else if(traficLightColor == "Green") "GO!"
    
    else "invalid traficLightColor"
    
    println(message)
    
    traficLightColor = "Black"
     
    
    message = when(traficLightColor){
        
        "Red" -> "STOP!"
    
        "Yellow" -> "SLOW!"
        
        "Green" -> "GO!"
        
        else -> "QUEBRADO!!"
    }
    
    println(message)
    
    
    
}