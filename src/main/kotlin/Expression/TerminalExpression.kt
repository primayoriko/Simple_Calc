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
        return Regex("[0-9]*\\.?[0-9]+").matches(x) // \d+(\.\d*)?|\.\d+
    }

    override public fun solve(): Double
    {
        return this.x;
    }
}