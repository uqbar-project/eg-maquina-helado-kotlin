package ar.edu.unsam.algo2.maquinaHelado

import ar.edu.unsam.algo2.maquinaHelado.creacionales.PreparacionBuilder
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.Ingrediente
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TestIceMachine : DescribeSpec({
    describe("Dada una Ice Machine 2000") {
        val iceMachine = StubIceMachine(temperatura = 10)

        it("si se intenta enfriar demasiado queda en error") {
            iceMachine.setValue(MaquinaHelado.SENSOR_TEMPERATURA, -2)

            iceMachine.getStatus() shouldBe MaquinaHelado.MAQUINA_ERROR
            iceMachine.getValue(MaquinaHelado.SENSOR_TEMPERATURA) shouldBe 10
        }
        it("si se quiere cambiar una configuración que no existe queda en error") {
            iceMachine.setValue(222, -1)

            iceMachine.getStatus() shouldBe MaquinaHelado.MAQUINA_ERROR
            iceMachine.getValue(MaquinaHelado.SENSOR_TEMPERATURA) shouldBe 10
        }
    }
})