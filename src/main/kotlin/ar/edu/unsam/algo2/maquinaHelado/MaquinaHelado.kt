package ar.edu.unsam.algo2.maquinaHelado

import ar.edu.unsam.algo2.maquinaHelado.exceptions.BusinessException
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.Ingrediente
import ar.edu.unsam.algo2.maquinaHelado.preparacion.Preparacion

class MaquinaHelado(val iceMachine: IceMachine2000) {

    companion object {
        val ACTION_BATIR = 1
        val ACTION_TRITURAR = 2
        val ACTION_AGITAR = 3
        val ACTION_DETENER = 4
        val MAQUINA_OCUPADA = 0
        val MAQUINA_LIBRE = 1
        val MAQUINA_ERROR = 2
        val SENSOR_TEMPERATURA = 1
    }

    val stockIngredientes: MutableMap<Ingrediente, Int> = mutableMapOf()


    fun preparar(preparacion: Preparacion) {
        validarEstadoParaPreparar(preparacion)
        preparacion.preparar(this)
    }

    fun validarEstadoParaPreparar(preparacion: Preparacion) {
        if (!estaLibre()) {
            throw BusinessException("La máquina está preparando otro helado")
        }
        if (!preparacion.temperaturaAdecuada(getTemperatura())) {
            throw BusinessException("La máquina no está a la temperatura adecuada: ${getTemperatura()}")
        }
        validarIngredientesNecesarios(preparacion)
    }

    fun validarIngredientesNecesarios(preparacion: Preparacion) {
        preparacion.ingredientesNecesarios().forEach { stockSuficiente(it.ingrediente, it.cantidadNecesaria) }
    }

    fun agregarIngrediente(ingrediente: Ingrediente, cantidad: Int) {
        stockSuficiente(ingrediente, cantidad)
        iceMachine.add(ingrediente.codigo, cantidad)
        if (!estaEnError()) {
            descontarStock(ingrediente, cantidad)
        }
    }

    fun stockSuficiente(ingrediente: Ingrediente, cantidad: Int) {
        if (stock(ingrediente) < cantidad) {
            throw BusinessException("No hay suficiente stock de $ingrediente Stock actual: ${stock(ingrediente)}  vs  Cantidad Necesaria: $cantidad")
        }
    }

    fun stock(ingrediente: Ingrediente) = stockIngredientes.getOrDefault(ingrediente, 0)

    fun hayStock(ingrediente: Ingrediente) = stock(ingrediente) > 0

    fun descontarStock(ingrediente: Ingrediente, cantidad: Int) {
        if (hayStock(ingrediente)) {
            val cantidadActual = stock(ingrediente) - cantidad
            stockIngredientes[ingrediente] = cantidadActual
        }
    }

    fun ingresarIngrediente(ingrediente: Ingrediente, cantidad: Int) {
        stockIngredientes[ingrediente] = cantidad
    }

    fun validarEstado() {
        if (estaEnError()) {
            throw BusinessException("La máquina quedó con error")
        }
    }

    fun estaLibre() = iceMachine.getStatus() == MAQUINA_LIBRE

    fun getTemperatura() = iceMachine.getValue(SENSOR_TEMPERATURA)

    fun estaEnError() = iceMachine.getStatus() == MAQUINA_ERROR
    fun estaOcupada() = iceMachine.getStatus() == MAQUINA_OCUPADA

    fun enfriar() {
        iceMachine.setValue(SENSOR_TEMPERATURA, -1)
        validarEstado()
    }

    fun calentar() {
        iceMachine.setValue(SENSOR_TEMPERATURA, 1)
    }

    fun batir() {
        iceMachine.action(ACTION_BATIR)
    }

    fun agitar() {
        iceMachine.action(ACTION_AGITAR)
    }

    fun triturar() {
        iceMachine.action(ACTION_TRITURAR)
    }

    fun detenerPaletas() {
        iceMachine.action(ACTION_DETENER)
    }
}





