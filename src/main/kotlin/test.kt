import Expression.*

fun main(args: Array<String>) {
    val a = TerminalExpression(2.0)
    val b = TerminalExpression(60.0)

    val np = TrigonometricExpression(a, b);
    println(np.solve());
}