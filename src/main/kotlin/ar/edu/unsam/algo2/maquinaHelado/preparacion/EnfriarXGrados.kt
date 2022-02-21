package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado

class EnfriarXGrados(val grados: Int) : Paso() {

    override fun ejecutar(maquina: MaquinaHelado) {
        (1..grados).forEach { maquina.enfriar() }
    }
}