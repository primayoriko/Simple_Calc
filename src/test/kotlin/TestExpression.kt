package MyCalc.test.kotlin

import MyCalc.main.kotlin.Expression.*

fun main(args: Array<String>)
{
    // TerminalExpression
    var a = TerminalExpression();       // 0.0
    var b = TerminalExpression(3.0);
    var c = TerminalExpression(4.0);

    // AddExpression
    println(AddExpression(a,b).solve());        // 3.0
    // SubtractExpression
    println(SubstractExpression(c,b).solve());  // 1.0
    // MultipleExpression
    println(MultipleExpression(c,b).solve());   // 12.0
    // DivideExpression
    println(DivideExpression(a,b).solve());     // 0.0
    // PowerExpression
    println(PowerExpression(b,c).solve());      // 81.0

    // LogExpression
    println(LogExpression(b).solve());          // 0.47712125471966244
    // NegativeExpression
    println(NegativeExpression(b).solve());     // -3.0
    // RootSquareExpression
    println(RootSquareExpression(c).solve());   // 2.0
    // TrigonometricExpression
    println(TrigonometricExpression(a).solve(3));   // 0.0
}