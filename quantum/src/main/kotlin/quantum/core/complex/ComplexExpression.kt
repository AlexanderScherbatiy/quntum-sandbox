package quantum.core.complex

interface ComplexExpression

data class ValueExpression(val complex: Complex) : ComplexExpression

data class SumComplexExpression(val complex1: ComplexExpression, val complex2: ComplexExpression) : ComplexExpression

data class MulComplexExpression(val complex1: ComplexExpression, val complex2: ComplexExpression) : ComplexExpression

fun Complex.toExpr(): ValueExpression = ValueExpression(this)