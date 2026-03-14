// MODIFICADORES DE VISIBILIDADE 

// public, private (mesma classe ou arquivo de origem), protected(acessivel em subclases), internal (acessivel no mesmo modulo) 

//modulo pode conter varios pacotes // pacote agrupa classes relacionadas

open class SmartDevice(val name: String, val category: String) {

    private var deviceStatus = "online"

    protected set      // e possivel ocultar o corpo, caso a operacao seja somente atualizar o valor
    
    //setter quase sempre serao protected

}

open class SmartDevice protected constructor (val name: String, val category: String) {  //construtor protected

    ...

}

internal open class SmartDevice(val name: String, val category: String) {  // classe internal

    ...

}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set
    // SMART TV
    fun turnOnTv(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
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
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
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


}