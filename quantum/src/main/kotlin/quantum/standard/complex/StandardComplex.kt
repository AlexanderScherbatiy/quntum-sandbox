package quantum.standard.complex

import quantum.core.complex.*
import kotlin.math.cos
import kotlin.math.sin

class StandardComplexCalculator : ComplexCalculator {

    override fun calculate(expr: ComplexExpression): ComplexCalculatorResult {
        return calc(expr).toCalculatorResult()
    }
}

private fun calc(expr: ComplexExpression): Result = when (expr) {
    is ValueExpression -> when (expr.complex) {
        is CartesianComplex -> expr.complex.toResult()
        is PolarComplex -> expr.complex.toResult()
        else -> throw Exception("Unknown complex: ${expr.complex}")
    }

    is SumComplexExpression -> sum(calc(expr.complex1), calc(expr.complex2))
    else -> throw Exception("Unknown expression: ${expr}")
}

private fun sum(res1: Result, res2: Result): Result = Result(res1.real + res2.real, res1.image + res2.image)

private fun CartesianComplex.toResult(): Result = Result(this.real, this.image)

// TBD: update
private fun PolarComplex.toResult(): Result = Result(this.radius * cos(this.angle), this.radius * sin(this.angle))

private data class Result(val real: Double, val image: Double)

private data class CalculatorResult(val real: Double, val image: Double) : ComplexCalculatorResult {

    override fun resultType(): ComplexCalculatorResult.Type = ComplexCalculatorResult.Type.CARTESIAN

    override fun getCartesian(): CartesianComplex = CartesianComplex(real, image)

    override fun getPolar(): PolarComplex = cartesianToPolar(real, image)
}

private fun Result.toCalculatorResult(): ComplexCalculatorResult = CalculatorResult(this.real, this.image)