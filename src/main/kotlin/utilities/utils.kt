package utilities

import java.text.SimpleDateFormat
import java.util.*

val scan: Scanner = Scanner(System.`in`)

/**
 * This method can be used to read a String word value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @return outputValue Output value
 */
fun readWord(pMessageIn: String
             , pMessageErrorDT: String
): String{

    var outputValue: String = ""
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.next()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a String sentence from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @return outputValue Output value
 */
fun readSentence(pMessageIn: String
                 , pMessageErrorDT: String
): String{

    var outputValue: String = ""
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextLine()
        }
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Char value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @return outputValue Output value
 */
fun readChar(pMessageIn: String
             , pMessageErrorDT: String
): Char{

    var outputValue: Char = ' '
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            // Get the first character of the input word from scan.next()
            outputValue = scan.next()[0]
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Char value from the user through keyboard using java.util.Scanner. It can force the output Char to be lower or uppercase
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pCase Input parameter to force lowercase (0) or uppercase (1)
 * @return outputValue Output value
 */
fun readChar(pMessageIn: String
             , pMessageErrorDT: String
             , pCase: Int
): Char{

    var outputValue: Char = ' '
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = if (pCase == 0) scan.next()[0].lowercaseChar()
            else scan.next()[0].uppercaseChar()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Boolean value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @return outputValue Output value
 */
fun readBoolean(pMessageIn: String
                , pMessageErrorDT: String
): Boolean{

    var outputValue: Boolean = false
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextBoolean()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextBoolean()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @return outputValue Output value
 */
fun readInt(pMessageIn: String
            , pMessageErrorDT: String
): Int{

    var outputValue: Int = 0
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextInt()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextInt()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner with a min value
 * @author raimon.izard
 * @author picuu
 * @since 19/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @return outputValue Output value
 */
fun readInt(pMessageIn: String, pMessageErrorDT: String, pMessageErrorDV:String, pMin: Int): Int {
    var outputValue: Int = 0
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextInt()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextInt()

            if (outputValue < pMin){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correctDataType = false
            }
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner in within a range
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @param pMax Max accepted value
 * @return outputValue Output value
 */
fun readInt(pMessageIn: String
            , pMessageErrorDT: String
            , pMessageErrorDV: String
            , pMin: Int
            , pMax: Int
): Int{

    var outputValue: Int = 0
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextInt()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextInt()

            if (outputValue < pMin || outputValue > pMax){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correctDataType = false
            }
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Float value from the user through keyboard using java.util.Scanner
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @return outputValue Output value
 */
fun readFloat(pMessageIn: String
              , pMessageErrorDT: String
): Float{

    var outputValue: Float = 0.0f
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextFloat()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextFloat()
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Float value from the user through keyboard using java.util.Scanner with a min value
 * @author raimon.izard
 * @author picuu
 * @since 08/02/2024
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @return outputValue Output value
 */
fun readFloat(pMessageIn: String
              , pMessageErrorDT: String
              , pMessageErrorDV: String
              , pMin: Float
): Float{

    var outputValue: Float = 0.0f
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextFloat()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextFloat()

            if (outputValue < pMin){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correctDataType = false
            }
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to read a Float value from the user through keyboard using java.util.Scanner in within a range
 * @author raimon.izard
 * @since 15/12/2023
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @param pMax Max accepted value
 * @return outputValue Output value
 */
fun readFloat(pMessageIn: String
              , pMessageErrorDT: String
              , pMessageErrorDV: String
              , pMin: Float
              , pMax: Float
): Float{

    var outputValue: Float = 0.0f
    var correctDataType: Boolean = false

    do{
        print(pMessageIn)
        correctDataType = scan.hasNextFloat()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + BLACK_BOLD + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            outputValue = scan.nextFloat()

            if (outputValue < pMin || outputValue > pMax){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correctDataType = false
            }
        }
        scan.nextLine()
    }while(!correctDataType)

    return outputValue
}

/**
 * This method can be used to round the decimals of a Number to a specified amount.
 * @author picuu
 * @since 04/01/2024
 * @param num Number to be rounded.
 * @param decimals Amount of decimals to round the number.
 * @return The given number rounded to the specified decimals as a Float.
 */
fun roundToFloat(num: Number, decimals: Int): Float {
    var multiplicator:String = "1"
    for (i in 1..decimals) multiplicator += "0"

    val rounded = (num.toDouble() * multiplicator.toInt()).toInt()
    return rounded.toFloat() / multiplicator.toInt()
}

/**
 * This method can be used to print a red text in the console, representing an error.
 * @author picuu
 * @since 04/01/2024
 * @param text The text to be displayed.
 */
fun error(text: String) {
    println(RED_BRIGHT + text + RESET)
}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}