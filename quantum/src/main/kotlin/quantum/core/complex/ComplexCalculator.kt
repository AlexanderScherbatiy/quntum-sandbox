package quantum.core.complex

import quantum.standard.CalculatorException
import kotlin.jvm.Throws


interface ComplexCalculatorResult {

    enum class Type {
        CARTESIAN, POLAR
    }

    fun resultType(): Type
    fun getCartesian(): CartesianComplex
    fun getPolar(): PolarComplex
}

interface ComplexCalculator {
    @Throws(CalculatorException::class)
    fun calculate(expr: ComplexExpression): ComplexCalculatorResult
}