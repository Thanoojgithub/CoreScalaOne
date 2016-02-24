package com.corescalaone

import scala.util.Random

/**
 * nameBy && valueBy
 */
object HigherOrderFunctions {

  def main(args: Array[String]): Unit = {

    /**
     * def layout(x: Int) : String
     * layout: Int => String
     */
    class Decorator(left: String, right: String) {
      def layoutVal(x: Int) = left + x + right
    }
    def apply(layoutFn: Int => String, v: Int) = layoutFn(v + 3)
    val decorator = new Decorator("[", "]")
    println(apply(decorator.layoutVal, 7))

    val set = (1 to 5).toSet
    set.foreach { println }

    def isEven(e: Int): Boolean = { e % 2 == 0 }
    //1. higher-order functions — functions that take functions as parameters(arguments) — which gives you extra opportunities to condense and simplify code.
    val evenSet = set.filter(i => isEven(i))
    evenSet.foreach { println }

    def randomString(length: Int) = Random.alphanumeric.take(length).mkString
    var ranStrlist = List(randomString(5))
    for (i <- 0 until 5) ranStrlist.:+=(randomString(5))
    ranStrlist.foreach { println }

    //2. Higher Order Functions - that take functions as return statement
    def capitalize(str: String): String = {
      def strUL() = str.head.toUpper + str.tail.toLowerCase()
      strUL()
    }
    ranStrlist = ranStrlist.map { s => capitalize(s) }
    println("------capitalize-----")
    ranStrlist.foreach { println }

    //Tests whether a predicate holds for some of the elements of this list. - exists
    val nums = (-1 to 5).toList
    def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
    println("exists : " + containsNeg(nums))

    //Currying
    def curriedSum(x: Int)(y: Int) = x + y
    println("Currying : " + curriedSum(1)(2))

    for (i <- (1 to 10).reverse) {
      println("i th element is: " + i);
    }
    for (i <- 10 to (1, -1)) {
      println("i th element is: " + i);
    }

  }

}