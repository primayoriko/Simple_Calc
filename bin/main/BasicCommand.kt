import Expression.*
import java.util.Queue
import java.util.LinkedList

class BasicCommand{
    private var savedVal : Queue<String>
    private var equation : Equation
    private var ans : TerminalExpression
    private var display : String

    constructor(){
        this.display = ""
        this.ans = TerminalExpression()
        this.equation = Equation()
        this.savedVal = LinkedList<String>()
    }

    public fun doTask(x: String) : String {
        if(x.equals("=")){
            equation.addToken()
            display = equation.calculate()
            if(!display.equals("Error")){
                ans.setValue(display.toDouble())
            }
        }
        else if(x.equals("AC")){
            display = ""
            ans.setValue(0.0)
            //equation.reset()
        }
        else if(x.equals("MR")){
            if(!savedVal.isEmpty()) {
                //equation.clear()
                display = savedVal.remove()
            }
        }
        else if(x.equals("MC")){
            doTask("=")
            if(!display.equals("Error")){
                savedVal.add(display)
            }
        }
        else if(x.equals("Ans")){
            equation.addToken(ans.solve().toString())
            display = equation.printEquation()
        }
        else{
            equation.addToken(x)
            display = equation.printEquation()
        }
        return display
    }
}