
// // Smart TV IS-A smart device.
// class SmartTvDevice : SmartDevice() {
// }

// SmartHome HAS-A SmartDevice

open class SmartDevice (val name: String, val category: String){ //open define que a classe pode ser estendida/herdada por outras classes

    var deviceStatus = "Off"

    open val deviceType = "unknown"

    // get(value){
    //     return self.speakerVolume

    // }
    // set(value){

    //     if (value in 0..100){
    //         field = value
    //     }

    // }

    open fun turnOn(){                          // open torna a funcao alteravel por subclasses
        deviceStatus = "On"
    }
    open fun turnOff(){
        deviceStatus = "Off"
    }
    fun isOn(){
        
        if (deviceStatus == "On"){
            println("Smart device is on.")

        }else if(deviceStatus == "Off"){
            println("Smart device is off.")

        }else{
            println("ERROR!")
        }
        
    }

}
class SmartTvDevice(deviceName: String, deviceCategory: String): //depois dos : e a classe pai  //deviceName e deviceCategory nao sao definidas com mutaveis ou imutaveis,
    SmartDevice(name = deviceName, category = deviceCategory){                 // o que significa que sao apenas parametros do construtor e nao propriedades da classe.

    override val deviceType = "Smart TV"

    var speakerVolume = 0

    private set(value){

        if (value in 0..100){
            field = value
        }

    }

    private var channelNumber = 0
    
    set(value){

        if (value in 0..200){
            field = value
        }

    }

    fun increaseSpeakerVolume(){
        speakerVolume ++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun nextChannel(){
        channelNumber ++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel = 0

    set(value) {
        if (value in 0..100) {
            field = value
        }
    }

    fun increaseBrightness(){
        brightnessLevel ++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {                    //override sobrescreve o metodo herdado
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {                  //override sobrescreve o metodo herdado
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// The SmartHome class HAS-A smart TV device and smart light.
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    // SMART TV
    fun turnOnTv(){
        smartTvDevice.turnOn()
    }

     fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }

    // SMART LIGHT
    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    // ALL DEVICES

    fun turnOffAllDevices(){
        turnOffTv()
        turnOffLight()
    }

}


fun main(){

    val myTv: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    myTv.turnOn()

    val lightRoom: SmartDevice = SmartLightDevice("Google Light", "Utility")
    lightRoom.turnOn()

    var smartHome = SmartHome(smartTvDevice = myTv, smartLightDevice = light_room)


}