package ar.edu.unsam.algo2.maquinaHelado.creacionales

import ar.edu.unsam.algo2.maquinaHelado.exceptions.BusinessException
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.Ingrediente
import ar.edu.unsam.algo2.maquinaHelado.preparacion.*

class PreparacionBuilder {
    val preparacion = Preparacion(temperaturaMinima = -10, temperaturaMaxima = 30)

    fun enfriarHasta(temp: Int): PreparacionBuilder {
        preparacion.agregarPaso(EnfriarHasta(temp))
        return this
    }

    fun enfriar(temp: Int): PreparacionBuilder {
        preparacion.agregarPaso(EnfriarXGrados(temp))
        return this
    }

    fun agregar(cuanto: Int, ingrediente: Ingrediente): PreparacionBuilder {
        preparacion.agregarPaso(AgregarIngrediente(ingrediente, cuanto))
        return this
    }

    fun batir(cuanto: Int): PreparacionBuilder {
        preparacion.agregarPaso(Batir(cuanto))
        return this
    }

    fun triturar(cuanto: Int): PreparacionBuilder {
        preparacion.agregarPaso(Triturar(cuanto))
        return this
    }

    fun build(): Preparacion {
        if (preparacion.sinPasos()) {
            throw  BusinessException("No ha definido pasos para la preparacion")
        }
        return preparacion
    }
}