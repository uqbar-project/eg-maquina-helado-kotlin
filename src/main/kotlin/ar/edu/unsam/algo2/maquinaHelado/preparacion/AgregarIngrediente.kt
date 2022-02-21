package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.Ingrediente
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.IngredienteNecesario

class AgregarIngrediente(val ingrediente: Ingrediente, val cantidad: Int) : Paso() {
    override fun ejecutar(maquina: MaquinaHelado) {
        maquina.agregarIngrediente(ingrediente, cantidad)
    }

    init {
        ingredienteNecesario.add(IngredienteNecesario(cantidad, ingrediente))
    }
}