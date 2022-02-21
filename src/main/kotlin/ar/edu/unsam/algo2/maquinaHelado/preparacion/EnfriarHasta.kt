package ar.edu.unsam.algo2.maquinaHelado.preparacion

import ar.edu.unsam.algo2.maquinaHelado.MaquinaHelado
import ar.edu.unsam.algo2.maquinaHelado.exceptions.BusinessException

class EnfriarHasta(val temperaturaDeseada:Int):Paso() {
    override fun ejecutar(maquina: MaquinaHelado) {
        if (maquina.getTemperatura() < temperaturaDeseada) {
            throw BusinessException("La máquina está más fría que $temperaturaDeseada °C")
        }
        while (maquina.getTemperatura() > temperaturaDeseada) {
            maquina.enfriar()
        }
    }
}