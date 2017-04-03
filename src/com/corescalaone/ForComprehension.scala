package com.corescalaone

/**
 * Translating for-comprehensions
 * Scala’s "for comprehensions" are syntactic sugar for composition of multiple operations
 * with for-each, map, flatMap, filter or withFilter.
 */
object ForComprehension {

  def main(args: Array[String]): Unit = {
    println(even(0, 20))
    println(old(0, 20))

    //val fruits: List[String]
    val fruits = "apple" :: "banana" :: "orange" :: Nil
    val fruitsInUpperCase = for (e <- fruits) yield e.toUpperCase
    println(fruitsInUpperCase)
    fruitsInUpperCase.map(println)

    var fruitsMutable = scala.collection.mutable.ArrayBuffer[String]()
    fruitsMutable += "apple"
    fruitsMutable += "banana"
    fruitsMutable += "orange"
    fruitsMutable.map(println)

    var flag: Boolean = false
    List.range(1, 10).filter(_ % 2 == 1 && !flag).foreach(x => if (x == 5) { flag = true; println(x + " " + flag) } else { flag = false; println(x + " " + flag) })
  }

  def even(from: Int, to: Int): List[Int] = for (i <- List.range(from, to) if i != 0 && i % 2 == 0) yield i

  def old(from: Int, to: Int): List[Int] = for (i <- List.range(from, to) if i != 0 && i % 2 != 0) yield i

}