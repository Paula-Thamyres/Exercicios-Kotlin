object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        if (factors.isEmpty()) return 0

        // Cria um conjunto de múltiplos únicos usando flatMap
        val multiples = factors
            .filter { it != 0 } // ignora fator 0
            .flatMap { factor ->
                // gera múltiplos do fator abaixo do limite
                (factor until limit step factor).toList()
            }
            .toSet() // remove duplicados automaticamente

        return multiples.sum()
    }
}
