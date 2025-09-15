fun twofer(name: String?): String {
    // Se o parâmetro for null, substitui por "you"
    val person = if (name == null) "you" else name
    return "One for $person, one for me."
}

// Sobrecarga para permitir chamada sem argumentos:
fun twofer(): String = twofer(null)
