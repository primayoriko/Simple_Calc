import Expression.*

fun main(args: Array<String>) {
    val a = TerminalExpression()
    val b = TerminalExpression(6.0)

    a.addDigit(5);
    println(a.solve());
    a.addDigit(6);
    println(a.solve());
    val np = AddExpression(a, b);
    println(np.solve());
}