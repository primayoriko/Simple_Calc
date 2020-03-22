class Equation<T>(defElmt: T){
    class Pair<T>(thisType: String, thisValue: T){
        public val type = thisType
        public var value = thisValue
    }

    private var elmt : MutableList<T> = mutableListOf<T>()
    private var curToken : String = ""

    public fun isNumComponent(x: String): Boolean{
        return Regex("[0-9.]").matches(x)
    }

    public fun addToken(token: T){
        val tokenS = token.toString()
        if (isNumComponent(tokenS)) {
            this.curToken += tokenS
        }
        else if(tokenS.equals("<-")){
            if(this.curToken.length!=0) {
                if (isNumComponent(this.content.get(this.content.length - 1).toString())) {

                }
            }
        }
        else{
            this.content += " "
            this
        }
    }
}