class Clock(private var hours: Int, private var minutes: Int = 0) {

    init {
        normalizeManual()
    }

    // Normalização manual sem usar mod diretamente
    private fun normalizeManual() {
        // Total de minutos desde 00:00
        var totalMinutes = hours * 60 + minutes

        // Ajustar negativos ou positivos fora do intervalo
        val dayMinutes = 24 * 60
        totalMinutes = ((totalMinutes % dayMinutes) + dayMinutes) % dayMinutes

        // Quebrar em horas e minutos
        hours = totalMinutes / 60
        minutes = totalMinutes % 60
    }

    fun add(minutes: Int): Clock {
        this.minutes += minutes
        normalizeManual()
        return this
    }

    fun subtract(minutes: Int): Clock {
        this.minutes -= minutes
        normalizeManual()
        return this
    }

    override fun toString(): String {
        val h = if (hours < 10) "0$hours" else "$hours"
        val m = if (minutes < 10) "0$minutes" else "$minutes"
        return "$h:$m"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Clock) return false
        return this.hours == other.hours && this.minutes == other.minutes
    }

    override fun hashCode(): Int = 31 * hours + minutes
}
