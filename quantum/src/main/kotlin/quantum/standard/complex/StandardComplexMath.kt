package quantum.standard.complex

import kotlin.math.sqrt
import kotlin.math.atan2
import quantum.core.complex.PolarComplex

fun length(x: Double, y: Double): Double = sqrt(x * x + y * y)
fun cartesianToPolar(real: Double, image: Double) = PolarComplex(length(real, image), atan2(image, real))