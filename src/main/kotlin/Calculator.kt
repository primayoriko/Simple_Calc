import javafx.fxml.FXML
import javafx.scene.input.KeyEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class Calculator : View(){
    override val root: VBox by fxml()
    @FXML lateinit var display: Label
    var command = BasicCommand()
    init {
        title = "Simple Calc"
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                display.text = command.doTask((b as Button).text)
            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED) {
            display.text = command.doTask(it.character.toUpperCase().replace("\r", "="))
        }
    }
}