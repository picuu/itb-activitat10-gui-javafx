package exceptions

import utilities.RED_BRIGHT
import utilities.RESET

class InvalidPunctuationException: Exception {
    constructor(): this("The obtained punctuation is invalid")
    constructor(message: String): super(RED_BRIGHT + message + RESET)
}