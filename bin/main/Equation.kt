import Expression.*

interface EquationGeneric<T>{
    var elmt : MutableList<Pair<String, T>>
    var curToken : T
    var curType : T

    public fun isNumComponent(x: T): Boolean

    public fun isValidNum(x: T): Boolean

    fun isCurEmpty(): Boolean

    public fun addToken()

    public fun addToken(token: T)

    public fun removeToken()

    public fun clear()

    //public fun clearAll()

    public fun printEquation() : T

    public fun calculate() : T
}

class Equation : EquationGeneric<String>{
    override var elmt: MutableList<Pair<String, String>>
    override var curToken: String
    override var curType: String

    constructor(){
        this.elmt = mutableListOf<Pair<String, String>>()
        this.curToken = ""
        this.curType = ""
    }

    override fun isNumComponent(x: String): Boolean{
        return Regex("[0-9.]").matches(x)
    }

    override fun isValidNum(x: String): Boolean {
        return Regex("[0-9]*\\.?[0-9]+").matches(x) // \d+(\.\d*)?|\.\d+
    }

    override fun isCurEmpty(): Boolean{
        return this.curToken.isEmpty()
    }

    override fun addToken() {
        if(!isCurEmpty()){
            this.elmt.add(Pair<String, String>(this.curType, this.curToken))
        }
    }

    override public fun addToken(token: String){
        if (isNumComponent(token) || isValidNum(token)) {
            this.curToken += token
            this.curType = "operand"
        }
        else if(token.equals("<-")){
            removeToken()
        }
        else{
            if(!isCurEmpty()){
                this.elmt.add(Pair<String, String>(this.curType, this.curToken))
            }
            this.elmt.add(Pair<String, String>("operator", token))
            this.curType=""
            this.curToken=""
        }
    }

    override fun removeToken() {
        if(!isCurEmpty() && this.curType.equals("operand")){
            this.curToken = this.curToken.slice(0..this.curToken.length-2)
            if(isCurEmpty()){
                this.curType = ""
            }
        }
        else if(this.curType.equals("operator")){
            this.curToken = ""
            this.curType = ""
        }
        else if(isCurEmpty()){
            if(!this.elmt.isEmpty()){
                this.curToken = this.elmt[this.elmt.lastIndex].second
                this.curType = this.elmt[this.elmt.lastIndex].first
                this.elmt.removeAt(this.elmt.lastIndex)
                removeToken()
            }
        }
    }

//    override fun clear() {
//        TODO("Not yet implemented")
//    }

    override fun clear() {
        this.curType=""
        this.curToken=""
        this.elmt = mutableListOf<Pair<String, String>>()
    }

    override public fun printEquation(): String{
        var equation = ""
        this.elmt.forEach { i ->  equation += i.second }
        if(!isCurEmpty()){
            equation += this.curToken
        }
        return equation
    }

    override public fun calculate(): String{
        var stack : MutableList<Pair<String,String>> = mutableListOf<Pair<String,String>>();
        var result : String;
        var numb : Double;
        var numb2 : Double;
        var op : String;
        this.elmt.forEach { i->stack.add(Pair<String, String>(i.first, i.second))}
        try{
            while(stack.size != 1){
                if(isValidNum(stack[stack.lastIndex].second)){
                    numb = stack[stack.lastIndex].second.toDouble();
                    stack.removeAt(stack.lastIndex);
                    if(stack.isNotEmpty()){
                        op = stack[stack.lastIndex].second;
                        stack.removeAt(stack.lastIndex);
                        if(op.equals("log") || op.equals("sqrt") || op.equals("sin") || op.equals("cos") || op.equals("tan") || (op.equals("-") && stack.isNotEmpty() && stack[stack.lastIndex].first.equals("operator"))){
                            result = when(op)
                            {
                                "-" -> {
                                    NegativeExpression(TerminalExpression(numb)).solve().toString()
                                }
                                "log" -> LogExpression(TerminalExpression(numb)).solve().toString()
                                "sqrt" -> RootSquareExpression(TerminalExpression(numb)).solve().toString()
                                "sin" -> TrigonometricExpression(TerminalExpression(numb)).solve(1).toString()
                                "cos" -> TrigonometricExpression(TerminalExpression(numb)).solve(2).toString()
                                "tan" -> TrigonometricExpression(TerminalExpression(numb)).solve(3).toString()
                                else -> throw ArithmeticException("E")
                            }
                            if(op.equals("-") && stack.isNotEmpty() && stack[stack.lastIndex].first.equals("operator")){
                                stack.removeAt(stack.lastIndex);
                            }
                            stack.add(Pair<String, String>("operand", result));
                        }else
                        {
                            if(stack.isNotEmpty() && isValidNum(stack[stack.lastIndex].second))
                            {
                                numb2 = stack[stack.lastIndex].second.toDouble();
                                stack.removeAt(stack.lastIndex);
                                if(stack.isNotEmpty() && stack[stack.lastIndex].second.equals("-") && stack[stack.lastIndex-1].first.equals("operator"))
                                {
                                    stack.removeAt(stack.lastIndex);
                                    numb2 = NegativeExpression(TerminalExpression(numb2)).solve();
                                }
                                
                                result = when(op)
                                {
                                    "+" -> AddExpression(TerminalExpression(numb), TerminalExpression(numb2)).solve().toString()
                                    "-" -> SubstractExpression(TerminalExpression(numb2), TerminalExpression(numb)).solve().toString()
                                    "x" -> MultipleExpression(TerminalExpression(numb), TerminalExpression(numb2)).solve().toString()
                                    "/" -> DivideExpression(TerminalExpression(numb2), TerminalExpression(numb)).solve().toString()
                                    "^" -> PowerExpression(TerminalExpression(numb2), TerminalExpression(numb)).solve().toString()
                                    else -> throw ArithmeticException("E");
                                }
                                stack.add(Pair<String,String>("operand",result));
                            }else
                            {
                                throw ArithmeticException("E");
                            }
                        }
                    }else
                    {
                        result = numb.toString();
                        stack.add(Pair<String,String>("operand",result));
                    }
                }else
                {
                    throw ArithmeticException("E");
                }
            }
            result = stack[stack.lastIndex].second;
            return result;
        }catch(e: ArithmeticException){
            return "Error";
        }
    }
}
