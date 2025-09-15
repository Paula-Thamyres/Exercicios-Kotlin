object Acronym {
    fun generate(phrase: String): String {
        // 1. Substituir hífens por espaço
        val withSpaces = buildString {
            for (ch in phrase) {
                append(if (ch == '-') ' ' else ch)
            }
        }

        // 2. Remover pontuações exceto letras e espaços
        val lettersOnly = buildString {
            for (ch in withSpaces) {
                if (ch.isLetter() || ch.isWhitespace()) {
                    append(ch)
                }
            }
        }

        // 3. Dividir manualmente em palavras
        val words = mutableListOf<String>()
        var currentWord = StringBuilder()
        for (ch in lettersOnly) {
            if (ch.isWhitespace()) {
                if (currentWord.isNotEmpty()) {
                    words.add(currentWord.toString())
                    currentWord = StringBuilder()
                }
            } else {
                currentWord.append(ch)
            }
        }
        if (currentWord.isNotEmpty()) words.add(currentWord.toString())

        // 4. Construir a sigla pegando primeira letra maiúscula
        val acronym = StringBuilder()
        for (word in words) {
            acronym.append(word[0].uppercaseChar())
        }

        return acronym.toString()
    }
}
