package com.corescalaone

import scala.io.StdIn

object HelloWorld {
  def main(args: Array[String]): Unit = {
    // Not mandatory to call functions inside main()

    println("Enter a i value. ")
    val i = StdIn.readDouble()

    val result = square(i)
    println("def square :: " + result)
  }

  def multiple(x: Double, y: Double): Int = { if (x <= 0 || y <= 0) 0 else x.toInt * y.toInt }

  def square(i: Double): Double = { if (i <= 0) 0 else i * i }

  def quadrant(x: Double, y: Double): Int = {
    if (x < 0) {
      if (y < 0) 3 else 2
    } else {
      if (y < 0) 4 else 1
    }
  }

  println("Enter an x-coordinate. ")
  val x = StdIn.readDouble()
  println("Enter an y-coordinate. ")
  val y = StdIn.readDouble()
  println("def multiple :: " + multiple(x, y))
  println("def quadrant :: " + quadrant(x, y))

}


/*

OUTPUT


Enter an x-coordinate. 
1
Enter an y-coordinate. 
2
def multiple :: 2
def quadrant :: 1
Enter a i value. 
3
def square :: 9.0

 
*/