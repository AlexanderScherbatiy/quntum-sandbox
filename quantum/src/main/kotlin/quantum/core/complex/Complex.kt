package quantum.core.complex

interface Complex

object ComplexZero : Complex

object ComplexOne : Complex

data class CartesianComplex(val real: Double, val image: Double) : Complex

data class PolarComplex(val radius: Double, val angle: Double) : Complex

fun Int.toComplex(): Complex = CartesianComplex(this.toDouble(), 0.0)

fun Double.toComplex(): Complex = CartesianComplex(this, 0.0)
