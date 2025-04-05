package data.model;

enum class PasswordStrength(val strength: Int) {
    NONE(0),
    LOW(1),
    AVERAGE_MIN(2),
    AVERAGE_MAX(3),
    STRONG(4);

    companion object {
        fun fromStrength(strength: Int) = entries.firstOrNull { it.strength == strength } ?: NONE
    }
}