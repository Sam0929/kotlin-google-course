open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(protected var isFolded: Boolean = false) :
    Phone(){

    override fun switchOn() {
        if(!isFolded) {
            super.switchOn()
        }
        else {
            println("Your phone is folded, please unfold to turn on!")
        }

    }

    fun foldPhone() {
        isFolded = true
    }
    fun unfoldPhone() { 
        isFolded = false
    }
}

fun main (){
    
    val myPhone: FoldablePhone = FoldablePhone()
    
    myPhone.checkPhoneScreenLight()
   
    myPhone.foldPhone()
    myPhone.switchOn()
    myPhone.unfoldPhone()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()

    
}
    
