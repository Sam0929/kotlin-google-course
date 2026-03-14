/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
  
    var x = 11
    
    when(x){
        
        2, 3, 5, 7 ->  println("x is a prime number between 1 and 10.")
        
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        
        is Int -> println("x is an integer number, but not between 1 and 10.")
        
        else ->  println("x isn't an integer number.")
    }
    
    
    
}