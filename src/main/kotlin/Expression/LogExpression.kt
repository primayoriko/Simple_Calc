package MyCalc.main.kotlin.Expression

class LogExpression : UnaryExpression
{
    constructor(x: Expression) : super(x)

    override public fun solve(): Double
    {
        if(this.x.solve() == 0.0)
        {
            throw ArithmeticException("E");
        }else
        {
            return(Math.log10(this.x.solve()));
        }
    }
}