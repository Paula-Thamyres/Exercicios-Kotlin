class Anagram(private val source: String) {

    // Função manual para normalizar
    private fun normalizeManual(word: String): String {
        val chars = word.lowercase().toCharArray()
        // Ordena manualmente (bubble sort simples)
        for (i in chars.indices) {
            for (j in i + 1 until chars.size) {
                if (chars[j] < chars[i]) {
                    val tmp = chars[i]
                    chars[i] = chars[j]
                    chars[j] = tmp
                }
            }
        }
        return String(chars)
    }

    fun match(anagrams: Collection<String>): Set<String> {
        val normalizedSource = normalizeManual(source)
        val sourceLower = source.lowercase()
        val result = mutableSetOf<String>()

        for (candidate in anagrams) {
            val lowerCandidate = candidate.lowercase()

            // Se for exatamente a mesma palavra (ignorando case) → pula
            if (lowerCandidate == sourceLower) continue

            // Compara a versão normalizada
            if (normalizeManual(candidate) == normalizedSource) {
                result.add(candidate)
            }
        }
        return result
    }
}
