package MyCalc.main.kotlin.Expression

class NegativeExpression : UnaryExpression
{
    constructor(x: Expression) : super(x)

    override public fun solve(): Double
    {
        return((-1)*this.x.solve());
    }
}