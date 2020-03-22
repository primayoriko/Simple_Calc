class Equation<T>(defElmt: T){
    private var elmt : MutableList<Pair<String, T>> = mutableListOf<Pair<String, T>>()
    private var curToken : String = ""
    private var curType : String = ""

    public fun isNumComponent(x: String): Boolean{
        return Regex("[0-9.]").matches(x)
    }

    private fun isCurEmpty(): Boolean{
        return this.curToken.isEmpty()
    }

    public fun addToken(token: T){
        val tokenS = token.toString()
        if (isNumComponent(tokenS)) {
            this.curToken += tokenS
            this.curType = "operand"
        }
        else if(tokenS.equals("<-")){
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
                this.elmt.add(Pair<String, T>(this.curToken, this.curType))
            }
            this.curType="operator"
            this.curToken=tokenS
        }
    }

    public fun allEquation(){

    }

    public fun calculate(){

    }
}