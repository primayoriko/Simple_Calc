package Expression

class TrigonometricExpression : BinaryExpression
{
    constructor(x: Expression, y: Expression) : super(x,y);
    
    override public fun solve(): Double
    {
        var result = when(this.x.solve())
        {
            1.0 -> Math.sin(Math.toRadians(this.y.solve()))
            2.0 -> Math.cos(Math.toRadians(this.y.solve()))
            3.0 -> Math.tan(Math.toRadians(this.y.solve()))
            else -> 0.0
        }
        return result;
    }
}