fun transcribeToRna(dna: String): String {
    // Mapeamento dos nucleotídeos DNA -> RNA
    val map = mapOf(
        'G' to 'C',
        'C' to 'G',
        'T' to 'A',
        'A' to 'U'
    )

    // Usa map para converter cada char e depois junta em string
    return dna.map { nucleotide ->
        map[nucleotide] ?: throw IllegalArgumentException("Invalid nucleotide")
    }.joinToString("")
}
