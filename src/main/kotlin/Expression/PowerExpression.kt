package MyCalc.main.kotlin.Expression
import kotlin.math.pow

class PowerExpression : BinaryExpression
{
    constructor(x: Expression, y: Expression) : super(x,y);
    
    override public fun solve(): Double
    {
        return(this.x.solve().pow(this.y.solve()));
    }
}