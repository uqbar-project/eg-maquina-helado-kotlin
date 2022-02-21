package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.IngredienteNecesario

abstract class Paso {
    val ingredienteNecesario: MutableList<IngredienteNecesario> = mutableListOf()
    abstract fun ejecutar(maquina: MaquinaHelado)
    fun esperar(minutos: Int) {
        (1..minutos * 60000).forEach { }
    }
}