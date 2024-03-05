package p.itbactivitat10guijavafx

import javafx.fxml.FXML
import javafx.scene.control.Label

class FormController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}