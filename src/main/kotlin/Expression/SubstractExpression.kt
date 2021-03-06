package MyCalc.main.kotlin.Expression

class SubstractExpression : BinaryExpression
{
    constructor(x: Expression, y: Expression) : super(x,y);
    
    override public fun solve(): Double
    {
        return(this.x.solve() - this.y.solve());
    }
}