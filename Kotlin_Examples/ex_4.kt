    //classes

    //propriedades (var que sao atributos dos obj)
    //métodos (funcoes que a classse contem)
    //construtores(funcoes de membro especiais, criam instancias da classe 
    //em todo programa em que sao definididas)

class SmartDevice (val name: String, val category: String){ //isso é o construtor {

    // constructor(): this(Primary constructor parameters){  //construtor secundario

    // }

    // constructor(name: String, category: String, statusCode: Int) : this(name, category) {
    //     deviceStatus = when (statusCode) {
    //         0 -> "offline"
    //         1 -> "online"
    //         else -> "unknown"
    //     }
    // }  //EXEMPLO

    var deviceState = 0

    var speakerVolume = 0

    get(value){
        return self.speakerVolume

    }
    set(value){

        if (value in 0..100){
            field = value
        }

    }

    fun turnOn(){
        deviceState = 1
    }
    fun turnOff(){
        deviceState = 0
    }
    fun isOn(){
        
        if (deviceState == 1){
            println("Smart device is on.")

        }else if(deviceState == 0){
            println("Smart device is off.")

        }else{
            println("ERROR!")
        }
        
    }
}
fun main(){

    val phone = SmartDevice(name = "S21FE", category = "Smartphone") //se definida como val, nao e possivel alterar o objeto da val, 
                                                                     //mas e possivel alterar o estado do objeto, mudando suas propriedades
    

    phone.turnOff()

    phone.isOn()
    
}