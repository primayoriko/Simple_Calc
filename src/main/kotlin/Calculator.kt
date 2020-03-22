import javafx.fxml.FXML
import javafx.scene.input.KeyEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class Calculator : View(){
    override val root: VBox by fxml()
    @FXML lateinit var display: Label
    var operation = BasicOperator()
    init {
        title = "Simple Calc"
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                display.text = operation.operate((b as Button).text)
            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED) {
            display.text = operation.operate(it.character.toUpperCase().replace("\r", "="))
        }
    }
}