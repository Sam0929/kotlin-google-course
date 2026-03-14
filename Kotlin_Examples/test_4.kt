class Song(
    val title: String, 
    val artist: String, 
    val releaseDate: String,
    protected var numberOfReplays: Long
){

    protected val isFamous: Boolean 
        get() = if (numberOfReplays >= 1000) true else false
    

    fun musicDescription() {
        println("$title, from $artist, released in $releaseDate.")
    }
    fun verifyFamous() {
        if(isFamous) {
            println("This music is famous!")
        }
       	else {
            println("This music isn't famous ):")
        }
        
    }
    fun update(){
        numberOfReplays = 12
    }
    
}

fun main() {
    
    val Hello: Song = Song(title = "Hello", artist = "Adele", releaseDate = "October 23, 2015", numberOfReplays = 1802026880)
    
    Hello.musicDescription()
    Hello.verifyFamous()
    Hello.update()
    Hello.verifyFamous()
    
}