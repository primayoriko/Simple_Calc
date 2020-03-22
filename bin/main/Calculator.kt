import javafx.fxml.FXML
import javafx.scene.input.KeyEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*
import Expression.*

class Calculator : View(){
    var ans = TerminalExpression()
    var value = TerminalExpression()
    var y1 = TerminalExpression()
    var y2 = TerminalExpression()
    var operatorExpression: String ="";
    var queue : MutableList<Double> = arrayListOf();
    
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

//    var state: Operator = add(0)
//
//    fun onAction(fn: Operator) {
//        state = fn
//        display.text = ""
//    }

//    val displayValue: Long
//        get() = when(display.text) {
//            "" -> 0
//            else -> display.text.toLong()
//        }

    private fun operator(x: String) {
        if (Regex("[0-9.]").matches(x)) {
            display.text += x
            value.addDigit(x.toDouble());
        } else {
            // Binary Operator
            if(true)
            {
                display.text += x
                y1.addDigit(value.solve());
                value.reset();
                operatorExpression = x;
            }
            // Unary Operator n Khusus
            else{
                if(x.equals("="))
                {
                    y2.addDigit(value.solve());
                    kalkulasi();
                    display.text = ans.solve().toString();
                    value.reset();
                }
                else if(x.equals("Ans")){
                    y1.reset();
                    y1.addDigit(value.solve());
                }
                else if(x.equals("MC")){
                    queue.add(value.solve());
                }
                else if(x.equals("MR")){
                    if(queue.isEmpty())
                    {
                        value.reset();
                    }else
                    {
                        value.addDigit(queue.removeAt(0));
                    }
                }
                else if(x.equals("<-")) {

                }
                else if (x.equals("-") || x.equals("sqrt") || x.equals("cos") || x.equals("sin") || x.equals("tan"))
                {
                    operatorExpression = x;
                }
            }
        }
    }
    private fun kalkulasi()
    {
        if(operatorExpression.equals("+"))
        {
            ans.addDigit(AddExpression(y1, y2).solve());
        }else if(operatorExpression.equals("-"))
        {
            ans.addDigit(SubstractExpression(y1, y2).solve());
        }else if(operatorExpression.equals("*"))
        {
            ans.addDigit(MultipleExpression(y1, y2).solve());
        }else if(operatorExpression.equals("/"))
        {
            ans.addDigit(DivideExpression(y1, y2).solve());
        }else if(operatorExpression.equals("^"))
        {
            ans.addDigit(PowerExpression(y1, y2).solve());
        }else if(operatorExpression.equals("sqrt"))
        {
            ans.addDigit(RootSquareExpression(y1).solve());
        }else if(operatorExpression.equals("sin"))
        {
            ans.addDigit(TrigonometricExpression(y1).solve(1));
        }else if(operatorExpression.equals("cos"))
        {
            ans.addDigit(TrigonometricExpression(y1).solve(2));
        }else if(operatorExpression.equals("tan"))
        {
            ans.addDigit(TrigonometricExpression(y1).solve(3));
        }else if(operatorExpression.equals("ans"))
        {
            
        }
    }
}