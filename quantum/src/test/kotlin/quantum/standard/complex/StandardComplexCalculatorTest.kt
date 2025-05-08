package quantum.standard.complex

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import quantum.core.complex.*

val DELTA: Double = 0.01

class StandardComplexCalculatorTest {

    @Test
    fun testSum() {
        println("Test calc sum!")
        val c1 = CartesianComplex(1.0, 2.0)
        val c2 = CartesianComplex(3.0, 4.0)
        val sum = SumComplexExpression(c1.toExpr(), c2.toExpr())

        val calc = StandardComplexCalculator();
        val res = calc.calculate(sum)
        val cartesian = res.getCartesian()
        assertEquals(4.0, cartesian.real, DELTA)
        assertEquals(6.0, cartesian.image, DELTA)
    }
}