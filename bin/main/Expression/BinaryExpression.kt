package Expression

abstract class BinaryExpression : Expression
{
    protected var x: Expression;
    protected var y: Expression

    constructor(x: Expression, y: Expression)
    {
        this.x = x;
        this.y = y;
    }

    override abstract fun solve(): Double;
}