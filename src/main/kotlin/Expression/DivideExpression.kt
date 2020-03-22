package MyCalc.main.kotlin.Expression

class DivideExpression : BinaryExpression
{
    constructor(x: Expression, y: Expression) : super(x,y);
    
    override public fun solve(): Double
    {
        if(this.y.solve() == 0.0)
        {
            throw ArithmeticException("E");
        }else
        {
            return(this.x.solve() / this.y.solve());
        }
    }
}