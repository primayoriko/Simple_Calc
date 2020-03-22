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

    override public fun solve(): Double
    {
        return this.x;
    }

    public fun addDigit(y: Double)
    {
        if(this.x == 0.0)
        {
            this.x += y;
        }else
        {
            this.x = this.x * 10 + y;
        }
    }

    public fun setZero()
    {
        this.x = 0.0;
    }
}