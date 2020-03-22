import Expression.*

fun main(args: Array<String>) {
//    val a = TerminalExpression()
//    val b = TerminalExpression(6.0)
//
//    a.addDigit(5);
//    println(a.solve());
//    a.addDigit(6);
//    println(a.solve());
//    val np = AddExpression(TerminalExpression(5.0), TerminalExpression(7.0));
//    println(np.solve());
    var test = Equation()
    test.addToken("<-")
    println(test.elmt.size)
    test.addToken("2")
    println(test.elmt.size)
    test.addToken("2")
    println(test.elmt.size)
    test.addToken("+")
    println(test.elmt.size)
    test.addToken("2")
    println(test.elmt.size)
    test.addToken("2")
    println(test.elmt.size)
    test.addToken(".")
    println(test.elmt.size)
    test.addToken("0")
    println(test.elmt.size)
    test.addToken("2")
    println(test.elmt.size)
    test.addToken("x")
    println(test.elmt.size)
    test.addToken("x")
    println(test.elmt.size)
    test.addToken("<-")
    println(test.elmt.size)

    println(test.printEquation())
    //println(test.calculate())
}