package Expression

class TerminalExpression : Expression
{
    protected var x: Double;

    constructor()
    {
        this.x = 0.0;
    }
    
    constructor(x: Double)
    {
        this.x = x;
    }

    public fun setValue(y: Double)
    {
        this.x = y;
    }

    fun isValidNum(): Boolean {
        return Regex("\\d+(\\.\\d*)?|\\.\\d+").matches(x.toString()) // 123. masih valid
    }

    override public fun solve(): Double
    {
        return this.x;
    }
}