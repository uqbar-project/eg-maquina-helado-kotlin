package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.IngredienteNecesario
import ar.edu.unsam.algo2.utils.between

class Preparacion(var temperaturaMinima: Int, var temperaturaMaxima: Int) {

    val pasos: MutableList<Paso> = mutableListOf()


    fun temperaturaAdecuada(temperatura: Int) = temperatura.between(temperaturaMinima, temperaturaMaxima)

    fun preparar(maquina: MaquinaHelado) {
        pasos.forEach {
            maquina.validarEstado()
            it.ejecutar(maquina)
        }
    }

    fun agregarPaso(paso: Paso) {
        pasos.add(paso)
    }

    fun sinPasos() = pasos.isEmpty()

    fun ingredientesNecesarios(): List<IngredienteNecesario> {
        return pasos.flatMap { it.ingredienteNecesario }
    }
}

