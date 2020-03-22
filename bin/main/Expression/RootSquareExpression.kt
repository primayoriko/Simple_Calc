package Expression
import kotlin.math.sqrt

class RootSquareExpression : UnaryExpression
{
    constructor(x: Expression) : super(x)

    override public fun solve(): Double
    {
        if(this.x.solve() < 0.0){
            throw ArithmeticException("E");
        }else{
            return(sqrt(this.x.solve()));
        }
    }
}