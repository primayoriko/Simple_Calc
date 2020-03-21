package Expression
import kotlin.math.sqrt

class RootSquareExpression : UnaryExpression
{
    constructor(x: Expression) : super(x)

    override public fun solve(): Double
    {
        return(sqrt(this.x.solve()));
    }
}