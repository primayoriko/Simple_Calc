package MyCalc.test.kotlin

import MyCalc.main.kotlin.*

fun main(args: Array<String>){
    var test = Equation()

    test.addToken("2")
    test.addToken("4")
    test.addToken("+")
    test.addToken("3")
    test.addToken()
    println(test.printEquation()) // print 24+3
    println(test.calculate()) // print 27
    test.removeToken()
    println(test.printEquation()) //print 24+
    test.clear()
    println(test.printEquation()) //print 'kosong/null' / hanya print newline
    if(test.isCurEmpty()){
        println("a")           // print a karena kosong
    }
    if(test.isValidNum("1234")){
        println("a")           // print a karena 1234 string penyusun angka valid
    }
}
