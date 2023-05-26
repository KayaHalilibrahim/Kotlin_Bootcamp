package com.example.kotlindersleri.nesne_tabanlı_programlama

fun main() {

var h=Homework()

    println("---------1.example--------------")

   var calculate= h.returnFahrenhiet(20)
    println("fahrenhiet: ${calculate} F")

    println("\n----------2.example-------------")

    h.calculatePerimeter(10,20)

    println("\n----------3.example-------------")

    println("faktorial: ${h.faktorial(4)}")

    println("\n----------4.example-------------")

    h.wordCount("Ankara")

    println("\n----------5.example-------------")

    println("sum of interior angles: ${h.sumInteriorAngles(4)}")

    println("\n----------6.example-------------")

    var result=h.salarAccount(25)

    println("Your salary: $result")

    println("\n----------7.example-------------")

    var amountBill=h.billFee(55.8)

    println("your debt: $amountBill")

}