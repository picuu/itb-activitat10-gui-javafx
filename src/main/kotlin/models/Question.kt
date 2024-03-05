package models

class Question {
    private var text: String
    private var answer1: String
    private var answer2: String
    private var answer3: String
    private var answer4: String
    private var userAnswer: Int
    private var puntsResposta1: Int
    private var puntsResposta2: Int
    private var puntsResposta3: Int
    private var puntsResposta4: Int


    constructor(text: String, answer1: String, answer2: String, answer3: String, answer4: String) {
        this.text = text
        this.answer1 = answer1
        this.answer2 = answer2
        this.answer3 = answer3
        this.answer4 = answer4
        this.userAnswer = -1
        this.puntsResposta1 = 10
        this.puntsResposta2 = 20
        this.puntsResposta3 = 30
        this.puntsResposta4 = 40
    }

    fun getText(): String {
        return this.text
    }

    fun getAnswer1(): String {
        return this.answer1
    }

    fun getAnswer2(): String {
        return this.answer2
    }

    fun getAnswer3(): String {
        return this.answer3
    }

    fun getAnswer4(): String {
        return this.answer4
    }

    fun setUserAnswer(userAnswer: Int) {
        this.userAnswer = userAnswer
    }

    fun getUserAnswer(): Int {
        return this.userAnswer
    }

    override fun toString(): String {
        return "Question: ${this.text}" +
                "\nAnswer 1: ${this.answer1}" +
                "\nAnswer 2: ${this.answer2}" +
                "\nAnswer 3: ${this.answer3}" +
                "\nAnswer 4: ${this.answer4}" +
                "\nUser answer: ${this.userAnswer}"
    }


}