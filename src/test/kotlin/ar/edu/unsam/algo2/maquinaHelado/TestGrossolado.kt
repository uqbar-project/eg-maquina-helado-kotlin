package ar.edu.unsam.algo2.maquinaHelado

import ar.edu.unsam.algo2.maquinaHelado.creacionales.PreparacionBuilder
import ar.edu.unsam.algo2.maquinaHelado.ingredientes.Ingrediente
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class TestGrossolado : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Dada una preparación para una máquina") {
        val stubIceMachine = StubIceMachine(15)

        val leche = Ingrediente("leche", 125)
        val azucar = Ingrediente("azucar", 72)
        val chocolate = Ingrediente("chocolate", 84)


        val grossolado = PreparacionBuilder()
            .enfriarHasta(5)
            .agregar(200, leche)
            .agregar(20, azucar)
            .batir(10)
            .enfriar(3)
            .agregar(30, chocolate)
            .triturar(2)
            .enfriarHasta(0)
            .build()

        val maquina = MaquinaHelado(stubIceMachine)
        with(maquina) {
            ingresarIngrediente(azucar, 1000)
            ingresarIngrediente(leche, 7500)
            ingresarIngrediente(chocolate, 500)
            preparar(grossolado)
        }

        it("se descuenta el stock de un ingrediente que está en la máquina según la preparación") {
            maquina.stock(chocolate) shouldBe 470
        }
        it("la máquina queda con la temperatura según la preparación") {
            maquina.getTemperatura() shouldBe 0
        }
        it("la máquina no queda en error") {
            maquina.estaEnError() shouldBe false
        }
        it("la máquina queda libre para hacer otra preparación") {
            maquina.estaLibre() shouldBe true
        }
    }
})
