/**
 * 1. Create an array of random numbers and print them it in a sorted order
 *
 * 2. Print list of even numbers and odd numbers from an array
 *
 * 3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield
 *
 * 4. Function that returns a tuple of minimum and maximum values of an array
 *
 * 5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map
 *
 * 6. Create a class called Connection( connectionId, url, port). How will you ensure that you will not create more than 10 connection objects?
 *
 * 7. Print the list of files in a directory using cmd/shell
 */
package com.corescalaone

import scala.util.Random

object CoreTwo {
  def main(args: Array[String]): Unit = {

    println("1. Create an array of random numbers and print them it in a sorted order");
    var array = Seq.fill(5)(Random.nextInt(10))
    println(array.foreach { println(_) })
    array = array.sorted
    println(array.foreach { println(_) })

    var randomArray = for (i <- 1 to 5) yield Random.nextInt(100)
    randomArray = randomArray.sorted
    println(randomArray.foreach { println })

    var arr = new Array[Int](5)
    for (i <- 0 to arr.length - 1) {
      arr(i) = (Random.nextInt(100))
    }
    arr = arr.sorted
    println(arr.foreach { println })

    println("2. Print list of even numbers and odd numbers from an array")
    var arr2 = new Array[Int](5)
    var evenListOne = List[Int]()
    var oddListOne = List[Int]()

    for (i <- 0 to arr2.length - 1) arr2(i) = (Random.nextInt(100))
    arr2 = arr2.sorted
    println(arr2.foreach { println })
    for (i <- 0 to arr2.length - 1) {
      if (arr2(i) % 2 == 0) evenListOne.:+=(arr2(i)) else oddListOne.:+=(arr2(i))
    }
    println(evenListOne.foreach { println })
    println(oddListOne.foreach { println })

    println("3. Write a function that takes an Int array input and swaps adjacent pairs of elements. Use for loop and yield")

    println("4. Function that returns a tuple of minimum and maximum values of an array")
    val minMaxTuple = new Tuple2(arr2(0), arr2(arr2.length - 1))
    println("minMaxTuple : " + minMaxTuple)
    println("MIN : " + minMaxTuple._1 + " | " + "MAX : " + minMaxTuple._2)

    println("5. If a = Array(1,2,3,4) and b = Array(“a”, “b”, “c”, “d”) generate the following output ((1,”a”),(2,”b”),(3,”c”),(4, “d”)) and convert it to map")
    //(1,"salmon") :+ true
    val aInt = Array[Int](1, 2, 3, 4)
    val bStr = Array[String]("a", "b", "c", "d")
    var finalTupleOfab = List[Tuple2[Int, String]]()
    for (i <- 0 to bStr.length - 1) {
      var tupleOfab = new Tuple2[Int, String](aInt(i), bStr(i))
      finalTupleOfab.:+=(tupleOfab)
    }
    println(finalTupleOfab)
    println(finalTupleOfab.toMap)
  }
}