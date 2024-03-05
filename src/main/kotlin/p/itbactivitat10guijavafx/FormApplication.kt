package p.itbactivitat10guijavafx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class FormApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(FormApplication::class.java.getResource("form-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(FormApplication::class.java)
}