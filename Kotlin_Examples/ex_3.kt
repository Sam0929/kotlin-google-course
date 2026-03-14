/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    

    var x: Int? = 111 // Sempre usar variáveis não nulas caso não seja necessário ter uma variável nulavel, 
                      //processamento melhor de variaveis Int, String, do que Int? String?
//     println(x)
//     x = null
//     println(x)
    
    
    var favoriteActor: String? = "Sandra Oh"
    
//     println(favoriteActor?.length)  //Operador de chamada segura ?.
    
//     println(favoriteActor!!.length) //Operador de declaração não nula !! força a execucao mesmo se a var for null, podendo gerar uma exception
    
    
    favoriteActor = "Sandra Oh"
    favoriteActor = null
	
//     if (favoriteActor != null) {
//       println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
//     }else {
//       println("You didn't input a name. ${favoriteActor?.length}")
//     }
    
     val lengthOfName = favoriteActor?.length?: 0
    
    print(lengthOfName)


    
    
    
}