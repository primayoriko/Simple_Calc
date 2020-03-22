package MyCalc.main.kotlin.Expression

abstract class UnaryExpression : Expression
{
    protected var x: Expression;

    constructor(x: Expression)
    {
        this.x = x;
    }

    override abstract fun solve(): Double;
}