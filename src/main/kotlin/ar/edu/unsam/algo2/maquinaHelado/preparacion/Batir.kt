package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado

class Batir(val minutos:Int):Paso() {
    override fun ejecutar(maquina: MaquinaHelado) {
        maquina.batir()
        esperar(minutos)
        maquina.detenerPaletas()
    }
}