import Expression.*
//import java.util.Queue
//import java.util.LinkedList

class BasicOperator {
    private var queue : MutableList<Double> = mutableListOf();
    private var equation = Equation()
    private var ans = TerminalExpression()

    public fun operate(x: String) : String {
        var display = ""
        if(x.equals("=")){
            display = equation.calculate()
            ans.setValue(display.toDouble())
        }
        else if(x.equals("AC")){
            display = ""
            ans.setValue(0.0)
            //equation.reset()
        }
        else if(x.equals("MR")){
            if(true){

            }
            //equation.clear()
        }
        else if(x.equals("MC")){

        }
        else if(x.equals("Ans")){
            equation.addToken(ans.solve().toString())
            display= equation.printEquation()
        }
        else{
            equation.addToken(x)
            display = equation.printEquation()
        }
        return display
    }
}

