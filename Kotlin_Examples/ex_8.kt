// No kotlin funcoes sao consideradas construcoes de primeira classe, como um tipo de dado, Int, Double, String, etc.
// Podem ser armazenadas em váriaveis, transmitidas para outras funcoes como argumentos, etc.


fun main() {
    // val trickFunction = trick  // :: operador de referencia de funcao, permite usar a funcao como valor

    // trick()
    // trickFunction()
    // treat()
    
    // Em expressao lambda, nao existe return, o resultado da ultima expressao sera o retorno
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }
    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    // E possivel simplificar a sintaxe de funcoes lambda, omitindo o nome dos parametros caso a funcao tenha um unico parametro.
    // O Kotlin atribui it ao parametro implicitamente, caso o nome seja omitido

    val coins_simplified:(Int) -> String = {
        "$it quarters"
    }
    
    //E possivel tambem usar expressoes lambda diretamente, sem criar uma variavel
    val trickFunction = trickOrTreat(true, null)
	val treat2Function = trickOrTreat(false, {"$it quarters"})
    val treatFunction = trickOrTreat(false, coins_simplified)

    // Ainda e possivel fazer de outra forma, quando uma functionType e o ultimo parametro, podemos usar name(args){lambda expression}
    // Observação: as funções de composição usadas para declarar a UI utilizam funções como parâmetros e geralmente são chamadas com a sintaxe de lambda final.

    val treat3Function = trickOrTreat(false){"$it quarters"}
    
//     val trickFunction = trickOrTreat(true){ "$it" }
//     val treatFunction = trickOrTreat(false){ "$it" }
    
    trickFunction()
    treatFunction()


// Quando uma funcao retorna outra ou usa uma funcao como argumento, ela e uma funcao de ordem superior

// Ex de funcao de ordem superior e a trickOrTreat

// Outro e a repeat, que tem essa assinatura ---> repeat(times: Int, action: (Int) -> Unit)


    repeat(4) {
        treatFunction()
    }
}

// fun trick() {
//     println("No treats!")  //usar dessa forma, necessita de :: para atribuir a fun a uma variavel
// }


// Expressoes lambda

val trick = {
    println("No treats!")
}

// Function Types  :(pode ter args aqui) -> tipo de retorno 

val treat: () -> Unit = {
    println("Have a treat!")
}

//tipo de retorno da funcao e uma funcao que nao retorna nada
// Ao usar uma funcao como parametro, nao sao necessarios rotulos, somente os tipos
// Para declarar um functionType que pode ser null, deve-se, : ((parms) -> returnType)?)
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {

    if (isTrick) {
        return trick
    } else {
        if(extraTreat != null){
            println(extraTreat(5))
        }
        return treat
    }

}

