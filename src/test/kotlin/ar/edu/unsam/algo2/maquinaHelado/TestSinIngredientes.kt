package ar.edu.unsam.algo2.maquinaHelado

import ar.edu.unsam.algo2.maquinaHelado.creacionales.PreparacionBuilder
import ar.edu.unsam.algo2.maquinaHelado.exceptions.BusinessException
import io.kotest.core.spec.style.DescribeSpec
import org.junit.jupiter.api.assertThrows


class TestSinIngredientes : DescribeSpec({
    describe("Cuando se intenta preparar un helado sin ingredientes") {
        it("la operación resulta en error") {
            assertThrows<BusinessException> { PreparacionBuilder().build() }
        }
    }
})