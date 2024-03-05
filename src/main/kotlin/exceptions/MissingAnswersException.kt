package exceptions

import utilities.RED_BRIGHT
import utilities.RESET

class MissingAnswersException: Exception {
    constructor(): this("There are answers missing for this form")
    constructor(message: String): super(RED_BRIGHT + message + RESET)
}