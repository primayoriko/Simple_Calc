package Expression

class TerminalExpression : Expression
{
    protected var x: Double;

    constructor(x: Double)
    {
        this.x = x;
    }

    override public fun solve(): Double
    {
        return this.x;
    }
}