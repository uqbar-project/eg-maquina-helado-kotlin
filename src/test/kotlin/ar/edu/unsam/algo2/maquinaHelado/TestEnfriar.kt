package ar.edu.unsam.algo2.maquinaHelado

import ar.edu.unsam.algo2.maquinaHelado.exceptions.BusinessException
import ar.edu.unsam.algo2.maquinaHelado.preparacion.EnfriarHasta
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.comparables.shouldNotBeEqualComparingTo
import org.junit.jupiter.api.assertThrows

class TestEnfriar : DescribeSpec({
    describe("Al enfriar una máquina hasta una cierta temperatura") {
        val stubIceMachine = StubIceMachine(15)
        val enfriarHasta5 = EnfriarHasta(5)
        val maquinaATemperaturaMayor = MaquinaHelado(stubIceMachine)
        val maquinaATemperaturaMenor = MaquinaHelado(StubIceMachine(-2))

        it("una máquina que está a mayor temperatura baja hasta la temperatura deseada") {
            maquinaATemperaturaMayor.getTemperatura() shouldNotBeEqualComparingTo 5
            enfriarHasta5.ejecutar(maquinaATemperaturaMayor)
            maquinaATemperaturaMayor.getTemperatura() shouldBeEqualComparingTo 5
        }
        it("la operación da error si la máquina está a menor temperatura") {
            assertThrows<BusinessException> { enfriarHasta5.ejecutar(maquinaATemperaturaMenor) }
        }
    }
})