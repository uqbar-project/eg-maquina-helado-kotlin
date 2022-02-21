package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado

class Triturar(val minutos: Int) : Paso() {
    override fun ejecutar(maquina: MaquinaHelado) {
        maquina.triturar()
        esperar(minutos)
        maquina.detenerPaletas()
    }
}