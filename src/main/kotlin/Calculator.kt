import javafx.fxml.FXML
import javafx.scene.input.KeyEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*
import Expression.*

class Calculator : View(){
    var ans = TerminalExpression()
    var queue : MutableList<Double> = arrayListOf();
    var equation = Equation()
    
    override val root: VBox by fxml()
    @FXML lateinit var display: Label
    init {
        title = "Simple Calc"
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                operator((b as Button).text)
            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED) {
            operator(it.character.toUpperCase().replace("\r", "="))
        }
    }

    private fun operator(x: String) {
        if(x.equals("=")){
            display.text = equation.calculate()
            ans.setValue(display.text.toDouble())
        }
        else if(x.equals("AC")){
            display.text = equation.calculate()
            ans.setValue(display.text.toDouble())
        }
        else if(x.equals("MR")){
            display.text = equation.calculate()
            ans.setValue(display.text.toDouble())
        }
        else if(x.equals("MC")){
            display.text = equation.calculate()
            ans.setValue(display.text.toDouble())
        }
        else if(x.equals("Ans")){
            display.text = equation.calculate()
            ans.setValue(display.text.toDouble())
        }
        else{
            equation.addToken(x)
            display.text = equation.printEquation()
        }

    }

}