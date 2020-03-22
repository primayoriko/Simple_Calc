interface EquationGeneric<T>{
    var elmt : MutableList<Pair<String, T>>
    var curToken : T
    var curType : T

    fun isNumComponent(x: T): Boolean

    fun isCurEmpty(): Boolean

    public fun addToken(token: T)

    public fun printEquation() : T

    public fun calculate()
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
        return Regex("\\d+(\\.\\d*)?|\\.\\d+").matches(x)
    }

    override fun isCurEmpty(): Boolean{
        return this.curToken.isEmpty()
    }

    override public fun addToken(token: String){
        if (isNumComponent(token)) {
            this.curToken += token
            this.curType = "operand"
        }
        else if(token.equals("<-")){
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
                    this.curToken = this.elmt[this.elmt.lastIndex].second.toString()
                    this.curType = this.elmt[this.elmt.lastIndex].first
                    this.elmt.removeAt(this.elmt.lastIndex)
                    addToken(token)
                }
            }
        }
        else{
            if(!isCurEmpty()){
                this.elmt.add(Pair<String, String>(this.curType, this.curToken))
            }
            this.curType="operator"
            this.curToken=token
        }
    }

    override public fun printEquation(): String{
        var equation = ""
        this.elmt.forEach { i ->  equation += i.second }
        if(!isCurEmpty()){
            equation += this.curToken
        }
        return equation
    }

    override public fun calculate(){

    }
}