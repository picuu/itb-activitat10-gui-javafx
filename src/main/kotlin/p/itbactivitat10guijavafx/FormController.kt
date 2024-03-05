package p.itbactivitat10guijavafx

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import models.Question

class FormController {
    private var questions: List<Question> = listOf(
        Question("On t'agrada passar més el temps?", "Platja", "Muntanya", "Bosc", "Ciutat"),
        Question("T'agrada viatjar?", "Molt", "Un parell de vegades a l'any", "Com menys millor", "No m'agrada"),
        Question("T'agradan els espais oberts?", "Molt", "Depèn del lloc", "Preferesc espais tancats", "M'agobien molt"),
        Question("Quin clima prefereixes?", "Mediterrani", "Tropical", "Nòrdic", "Desèrtic"),
        Question("Què sols fer quan tens vacances?", "Visitar museus", "Anar d'excursió", "Anar de compres", "Descansar"),
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
