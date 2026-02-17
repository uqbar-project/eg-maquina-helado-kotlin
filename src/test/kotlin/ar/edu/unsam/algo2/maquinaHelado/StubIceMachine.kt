package ar.edu.unsam.algo2.maquinaHelado

class StubIceMachine(var temperatura: Int = 0) : IceMachine2000 {

    var estado = MaquinaHelado.MAQUINA_LIBRE
    val stock: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    fun simularOcupada() {
        estado = MaquinaHelado.MAQUINA_OCUPADA
    }

    fun simularError() {
        estado = MaquinaHelado.MAQUINA_ERROR
    }

    override fun action(actionCode: Int) {
        // Oh sí, estoy haciendo eso que me pidió señor
    }

    override fun add(ingredientCode: Int, amount: Int) {
        val originalAmount = stock.getOrDefault(ingredientCode, 0)
        stock[ingredientCode] = originalAmount + amount
    }

    override fun getStatus() = estado

    override fun getValue(code: Int): Int {
        when (code) {
            MaquinaHelado.SENSOR_TEMPERATURA -> return temperatura
            else -> return 0
        }
    }

    override fun setValue(code: Int, value: Int) {
        if ((value != -1 && value != 1) || (code != MaquinaHelado.SENSOR_TEMPERATURA)) {
            simularError()
            return
        }
        temperatura += value
    }
}