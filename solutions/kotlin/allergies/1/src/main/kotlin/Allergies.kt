class Allergies(private val score: Int) {

    fun getList(): List<Allergen> {
        val result = mutableListOf<Allergen>()
        // Percorrer todos os alergênicos manualmente
        for (allergen in Allergen.values()) {
            if (isAllergicTo(allergen)) {
                result.add(allergen)
            }
        }
        return result
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        // Checagem manual do bit
        val allergenScore = allergen.score
        val andResult = score and allergenScore
        return andResult != 0
    }
}
