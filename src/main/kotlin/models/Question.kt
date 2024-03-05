package models

class Question {
    private var question: String
    private var answer1: String
    private var answer2: String
    private var answer3: String
    private var answer4: String
    private var userAnswer: Int


    constructor(question: String, answer1: String, answer2: String, answer3: String, answer4: String) {
        this.question = question
        this.answer1 = answer1
        this.answer2 = answer2
        this.answer3 = answer3
        this.answer4 = answer4
        this.userAnswer = -1
    }

    fun setUserAnswer(userAnswer: Int) {
        this.userAnswer = userAnswer
    }

    fun getUserAnswer(): Int {
        return this.userAnswer
    }

    override fun toString(): String {
        return "Question: ${this.question}" +
                "\nAnswer 1: ${this.answer1}" +
                "\nAnswer 2: ${this.answer2}" +
                "\nAnswer 3: ${this.answer3}" +
                "\nAnswer 4: ${this.answer4}" +
                "\nUser answer: ${this.userAnswer}"
    }


}