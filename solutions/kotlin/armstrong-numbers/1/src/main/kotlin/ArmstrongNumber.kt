object ArmstrongNumber {

    fun check(input: Int): Boolean {
        // Conta os dígitos manualmente
        var temp = input
        var digitsCount = 0
        while (temp > 0) {
            digitsCount++
            temp /= 10
        }
        if (digitsCount == 0) digitsCount = 1 // para o caso do zero

        // Calcula soma dos dígitos elevados à potência
        temp = input
        var sum = 0
        while (temp > 0) {
            val digit = temp % 10
            sum += intPow(digit, digitsCount)
            temp /= 10
        }

        // Caso especial para zero
        if (input == 0) sum = 0

        return sum == input
    }

    // Potenciação manual de inteiros
    private fun intPow(base: Int, exp: Int): Int {
        var result = 1
        repeat(exp) {
            result *= base
        }
        return result
    }
}
