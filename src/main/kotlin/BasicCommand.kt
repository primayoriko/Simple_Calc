package MyCalc.main.kotlin

import MyCalc.main.kotlin.Expression.*
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
            this.equation.addToken()
            this.display = equation.calculate()
            if(!display.equals("Error")){
                this.ans.setValue(this.display.toDouble())
            }
        }
        else if(x.equals("CE")){
            this.display = ""
            this.equation.clear()
        }
        else if(x.equals("AC")){
            this.ans.setValue(0.0)
            this.savedVal = LinkedList<String>()
            doTask("CE")
        }
        else if(x.equals("MR")){
            if(!this.savedVal.isEmpty()) {
                this.equation.clear()
                this.display = this.savedVal.remove()
            }
        }
        else if(x.equals("MC")){
            doTask("=")
            if(!display.equals("Error")){
                this.savedVal.add(display)
            }
        }
        else if(x.equals("Ans")){
            this.equation.addToken(ans.solve().toString())
            this.display = equation.printEquation()
        }
        else{
            this.equation.addToken(x)
            this.display = equation.printEquation()
        }
        return this.display
    }
}