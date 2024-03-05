package p.itbactivitat10guijavafx

import javafx.fxml.FXML
import javafx.scene.control.Label
import models.Question

class FormController {
    private var questions: List<Question> = listOf(
        Question("pregunta1", "a", "b", "c", "d"),
        Question("pregunta2", "a", "b", "c", "d"),
        Question("pregunta3", "a", "b", "c", "d"),
        Question("pregunta4", "a", "b", "c", "d"),
        Question("pregunta5", "a", "b", "c", "d"),
    )

    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }


}