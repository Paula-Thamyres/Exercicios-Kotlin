fun translate(rna: String?): List<String> {
    // Se for nulo ou vazio → lista vazia
    if (rna == null || rna.isEmpty()) return emptyList()

    // Map de códons
    val codonMap = mapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine", "UUC" to "Phenylalanine",
        "UUA" to "Leucine", "UUG" to "Leucine",
        "UCU" to "Serine", "UCC" to "Serine", "UCA" to "Serine", "UCG" to "Serine",
        "UAU" to "Tyrosine", "UAC" to "Tyrosine",
        "UGU" to "Cysteine", "UGC" to "Cysteine",
        "UGG" to "Tryptophan"
    )
    val stopCodons = setOf("UAA", "UAG", "UGA")

    val proteins = mutableListOf<String>()
    var i = 0
    while (i < rna.length) {
        // Se não houver caracteres suficientes para formar 3 nucleotídeos → erro
        if (i + 3 > rna.length) {
            throw IllegalArgumentException("Invalid codon")
        }

        val codon = rna.substring(i, i + 3)

        // Para no STOP codon
        if (stopCodons.contains(codon)) break

        // Se não encontrar no mapa → erro
        val protein = codonMap[codon] ?: throw IllegalArgumentException("Invalid codon")

        proteins.add(protein)
        i += 3
    }

    return proteins
}
