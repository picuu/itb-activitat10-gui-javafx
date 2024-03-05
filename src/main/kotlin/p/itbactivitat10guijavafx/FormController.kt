package p.itbactivitat10guijavafx

import exceptions.InvalidPunctuationException
import exceptions.MissingAnswersException
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.paint.Color
import models.Question

class FormController {
    private var questions: List<Question> = listOf(
        Question("On t'agrada passar més el temps?", "Platja", "Muntanya", "Bosc", "Ciutat"),
        Question("T'agrada viatjar?", "Molt", "Un parell de vegades a l'any", "Com menys millor", "No m'agrada"),
        Question("T'agradan els espais oberts?", "Molt", "Depèn del lloc", "Preferesc espais tancats", "M'agobien molt"),
        Question("Quin clima prefereixes?", "Mediterrani", "Tropical", "Desèrtic", "Nòrdic"),
        Question("Què sols fer quan tens vacances?", "Anar d'excursió", "Visitar museus", "Anar de compres", "Descansar"),
    )

    private var currentQuestion: Int = 1

    private var selectedAnswers: MutableMap<Int, RadioButton> = mutableMapOf()

    @FXML
    private lateinit var questionText: Label
    @FXML
    private lateinit var answer1: RadioButton
    @FXML
    private lateinit var answer2: RadioButton
    @FXML
    private lateinit var answer3: RadioButton
    @FXML
    private lateinit var answer4: RadioButton
    @FXML
    private lateinit var qToggleGroup: ToggleGroup
    @FXML
    private lateinit var previous: Button
    @FXML
    private lateinit var next: Button
    @FXML
    private lateinit var resultInfo: Label
    @FXML
    private lateinit var errorMessage: Label

    @FXML
    private fun onPreviousQuestion() {
        if (currentQuestion <= 1) return
        this.currentQuestion--
        if (currentQuestion <= 1) this.previous.isDisable = true
        if (this.next.isDisable) this.next.isDisable = false

        updateValues()
        updateSelectedAnswers()
    }

    @FXML
    private fun onNextQuestion() {
        if (currentQuestion >= questions.size) return
        this.currentQuestion++
        if (currentQuestion >= questions.size) this.next.isDisable = true
        if (this.previous.isDisable) this.previous.isDisable = false

        updateValues()
        updateSelectedAnswers()
    }

    @FXML
    private fun onSelectAnswer() {
        val selectedAnswer = this.qToggleGroup.selectedToggle as RadioButton
        this.selectedAnswers.set(this.currentQuestion, selectedAnswer)

        val question = this.questions[this.currentQuestion-1]
        val selectedAnswerIndex = selectedAnswer.id.substring(selectedAnswer.id.length-1).toInt()

        println(selectedAnswerIndex)

        when (selectedAnswerIndex) {
            1 -> question.setPunctuation(10)
            2 -> question.setPunctuation(20)
            3 -> question.setPunctuation(30)
            4 -> question.setPunctuation(40)
        }

        this.errorMessage.isVisible = false
        this.resultInfo.isVisible = false
    }

    @FXML
    private fun onCheckAnswers() {
        try {
            if (this.selectedAnswers.size < 5) throw MissingAnswersException()
            this.errorMessage.isVisible = false

            var totalPunctuation = 0
            this.questions.forEach { totalPunctuation += it.getPunctuation() }

            println(totalPunctuation)

            val resultText: String
            when (totalPunctuation) {
                in 50..100 ->  resultText = "Menorca"
                in 110..120 -> resultText = "València"
                in 130..150 -> resultText = "Saragossa"
                in 160..180 -> resultText = "Barcelona"
                in 190..200 -> resultText = "quedar-te a casa"
                else -> throw InvalidPunctuationException()
            }

            this.resultInfo.text = "Tens una puntuació de $totalPunctuation. Per això\n" +
                    "el teu millor destí per aquest estiu és $resultText."
            this.resultInfo.textFill = Color.GREEN
            this.resultInfo.isVisible = true
        } catch (e: MissingAnswersException) {
            println(e.message)
            this.errorMessage.text = "Completa totes les respostes\nantes de verificar el formulari!"
            this.errorMessage.textFill = Color.RED
            this.errorMessage.isVisible = true
        } catch (e: InvalidPunctuationException) {
            println(e.message)
            this.errorMessage.text = "Hi ha hagut un error verificant la teva puntuació!"
            this.errorMessage.textFill = Color.RED
            this.errorMessage.isVisible = true
        } catch (e: Exception) {
                e.printStackTrace()
        }
    }

    private fun updateValues() {
        this.questionText.text = this.questions[currentQuestion-1].getText()
        this.answer1.text = "a) " + this.questions[currentQuestion-1].getAnswer1()
        this.answer2.text = "b) " + this.questions[currentQuestion-1].getAnswer2()
        this.answer3.text = "c) " + this.questions[currentQuestion-1].getAnswer3()
        this.answer4.text = "d) " + this.questions[currentQuestion-1].getAnswer4()
    }

    private fun updateSelectedAnswers() {
        this.answer1.isSelected = false
        this.answer2.isSelected = false
        this.answer3.isSelected = false
        this.answer4.isSelected = false

        if (this.selectedAnswers.contains(this.currentQuestion)) {
            val answer = this.selectedAnswers.get(this.currentQuestion)
            if (answer != null) answer.isSelected = true
        }
    }
}
