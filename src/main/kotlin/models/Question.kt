package models

/**
 * This class represents a question with its answers and punctuation.
 * @author ulisescastell
 * @author picuu
 * @since 05/03/2024
 * @constructor Creates a question with its answers and initialize its punctuation to 0.
 * @property text String of the question.
 * @property answer1 String of the first answer.
 * @property answer2 String of the second answer.
 * @property answer3 String of the third answer.
 * @property answer4 String of the fourth answer.
 * @property punctuation Int of the punctuation.
 */
class Question {
    private var text: String
    private var answer1: String
    private var answer2: String
    private var answer3: String
    private var answer4: String
    private var punctuation: Int

    /**
     * Default constructor for the Question class.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     */
    constructor(text: String, answer1: String, answer2: String, answer3: String, answer4: String) {
        this.text = text
        this.answer1 = answer1
        this.answer2 = answer2
        this.answer3 = answer3
        this.answer4 = answer4
        this.punctuation = 0
    }

    /**
     * This method is the getter for the text attribute. It is used to obtain the text of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String of the question.
     */
    fun getText(): String {
        return this.text
    }

    /**
     * This method is the getter for the answer1 attribute. It is used to obtain the first answer of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String of the first answer.
     */
    fun getAnswer1(): String {
        return this.answer1
    }

    /**
     * This method is the getter for the answer2 attribute. It is used to obtain the second answer of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String of the second answer.
     */
    fun getAnswer2(): String {
        return this.answer2
    }

    /**
     * This method is the getter for the answer3 attribute. It is used to obtain the third answer of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String of the third answer.
     */
    fun getAnswer3(): String {
        return this.answer3
    }

    /**
     * This method is the getter for the answer4 attribute. It is used to obtain the fourth answer of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String of the fourth answer.
     */
    fun getAnswer4(): String {
        return this.answer4
    }

    /**
     * This method is the getter for the punctuation attribute. It is used to obtain the punctuation of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return Int of the punctuation.
     */
    fun getPunctuation(): Int {
        return this.punctuation
    }

    /**
     * This method is the setter for the punctuation attribute. It is used to set the punctuation of the question.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @param punctuation Int of the punctuation.
     */
    fun setPunctuation(punctuation: Int) {
        this.punctuation = punctuation
    }

    /**
     * This method is the override of the toString method. It is used to obtain a string representation of the object.
     * @author ulisescastell
     * @author picuu
     * @since 05/03/2024
     * @return String with some attributes of the object.
     */
    override fun toString(): String {
        return "Question: ${this.text}" +
                "\nAnswer 1: ${this.answer1}" +
                "\nAnswer 2: ${this.answer2}" +
                "\nAnswer 3: ${this.answer3}" +
                "\nAnswer 4: ${this.answer4}"
    }
}
