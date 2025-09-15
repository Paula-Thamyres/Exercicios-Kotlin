class Triangle<out T : Number>(a: T, b: T, c: T) {

    private val aD: Double
    private val bD: Double
    private val cD: Double

    init {
        // Converte manualmente
        aD = a.toDouble()
        bD = b.toDouble()
        cD = c.toDouble()

        // Verifica se os lados são maiores que zero
        if (aD <= 0.0 || bD <= 0.0 || cD <= 0.0) {
            throw IllegalArgumentException("Sides must be greater than zero")
        }

        // Verifica a desigualdade triangular
        val cond1 = aD + bD >= cD
        val cond2 = bD + cD >= aD
        val cond3 = aD + cD >= bD
        if (!cond1 || !cond2 || !cond3) {
            throw IllegalArgumentException("Triangle inequality violated")
        }
    }

    val isEquilateral: Boolean
        get() {
            return (aD == bD) && (bD == cD)
        }

    val isIsosceles: Boolean
        get() {
            return (aD == bD) || (bD == cD) || (aD == cD)
        }

    val isScalene: Boolean
        get() {
            return (aD != bD) && (bD != cD) && (aD != cD)
        }
}
