fun main(args: Array<String>){
    var test = BasicCommand()
    println(test.doTask("2")) //print 2
    println(test.doTask("2")) //print 22
    println(test.doTask("+")) //print 22+
    println(test.doTask("2"))//print 22+2
    println(test.doTask("=")) //print 24
    println(test.doTask("CE")) // tidak ada string diprint/hanya newline saja
    println(test.doTask("Ans"))//print 24 (hasil dari 22+2)
    println(test.doTask("MC")) //print 24 hasil dari operator = didalam fungsi & menyimpan hasil ke queue
    println(test.doTask("MR")) //print 24 dari meload hasil fungsi
}