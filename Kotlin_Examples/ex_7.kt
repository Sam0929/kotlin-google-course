// Delegados de propriedades
// var [name] by [delegate object]
// o que sao interfaces? Interfaces sao protocolos que devem ser seguidos pelas classes que a implementam  
// interface [name] {
//    [body]
// }

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set
    
    protected fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }

    protected fun actionsOnline(action: () -> Unit){

        if (deviceStatus == "on"){
            action()
        }
        else{
            println("Your device is OFF, please turn ON the device before making an action!")
        }
    }

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 10, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() = actionsOnline {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun decreaseSpeakerVolume()  = actionsOnline{
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() = actionsOnline{
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    fun previousChannel() = actionsOnline {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        if (deviceStatus == "off"){
            super.turnOn()
            println(
                "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
            )
        }else{
            println("Your device is already On!")
        }
        
    }

    override fun turnOff() = actionsOnline{
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() = actionsOnline {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    fun decreaseBrightness() = actionsOnline {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        if (deviceStatus == "off"){
            super.turnOn()
            brightnessLevel = 2
            println("$name turned on. The brightness level is $brightnessLevel.")
        }else{
            println("Your device is already On!")
        }
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    fun decreaseTvVolume(){
        smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun changeTvChannelToPrevious(){
        smartTvDevice.previousChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun printSmartLightInfo(){
        smartLightDevice.printDeviceInfo()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness(){
        smartLightDevice.decreaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    //metodos que atuam como getter e setters das propriedades

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartTv: SmartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    smartTv.turnOn()
    smartTv.nextChannel()
    smartTv.increaseSpeakerVolume()
    smartTv.turnOff()
    smartTv.nextChannel()
    smartTv.increaseSpeakerVolume()
    
    
//     println("O canal da tv é: ${smartDevice.channelNumber}")
//     println("O volume da tv é: ${smartDevice.speakerVolume}")

    val smartLight: SmartLightDevice = SmartLightDevice("Google Light", "Utility")
    smartLight.turnOn()
    smartLight.increaseBrightness()
    
    smartLight.turnOff()
    smartLight.increaseBrightness()
    smartLight.decreaseBrightness()

    val myHome: SmartHome = SmartHome(smartTv, smartLight)

    myHome.printSmartTvInfo()
    myHome.printSmartLightInfo()
}