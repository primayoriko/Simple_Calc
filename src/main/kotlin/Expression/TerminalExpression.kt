package Expression

class TerminalExpression : Expression
{
    protected var x: Double;
    protected var dotNum: Int;
    protected var validNum: Boolean;

    constructor()
    {
        this.x = 0.0;
        this.dotNum = 0;
        this.validNum = true;
    }
    
    constructor(x: Double)
    {
        this.x = x;
        this.dotNum = 0;
        this.validNum = true;
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
        this.validNum = true;
    }

    public fun addDigit(y: String)
    {
        if(y.equals(".")){
            this.dotNum++
        }
        this.validNum = false
    }

    public fun reset()
    {
        this.x = 0.0;
        this.dotNum = 0;
        this.validNum = true;
    }
}