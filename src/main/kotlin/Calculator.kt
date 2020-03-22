import javafx.fxml.FXML
import javafx.scene.input.KeyEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*
import Operator.*
import Expression.*


class Calculator : View(){
    var ans = TerminalExpression();
    var value = TerminalExpression();
    var y1 = TerminalExpression();
    var y2 = TerminalExpression();
    var operatorExpression: String ="";
    
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

    var state: Operator = add(0)

    fun onAction(fn: Operator) {
        state = fn
        display.text = ""
    }

    val displayValue: Long
        get() = when(display.text) {
            "" -> 0
            else -> display.text.toLong()
        }

    private fun operator(x: String) {
        if (Regex("[0-9]").matches(x)) {
            display.text += x
        } else {
            if(x.equals("="))
            {
                y2.addDigit(value.solve());
                kalkulasi();
                display.text = ans.solve().toString();
                value.setZero();
            }else if(x.equals("-") || x.equals("sqrt") || x.equals("cos") || x.equals("sin") || x.equals("tan"))
            {
                operatorExpression = x;
            }else
            {
                y1.addDigit(value.solve());
                value.setZero();
                operatorExpression = x;
            }
            // when(x) {
            //     "+" -> onAction(add(displayValue))
            //     "-" -> onAction(sub(displayValue))
            //     "/" -> onAction(div(displayValue))
            //     "%" -> { onAction(add(displayValue /100)); operator("=") }
            //     "X" -> onAction(mult(displayValue))
            //     "C" -> onAction(add(0))
            //     "+/-" -> { onAction(add(-1* displayValue)); operator("=") }
            //     "=" -> display.text = state.calculate(displayValue).toString()
            // }
        }
    }

    private fun kalkulasi()
    {

    }
}