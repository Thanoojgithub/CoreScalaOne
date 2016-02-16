package com.corescalaone

import java.util.ArrayList

object CoreOne {
  def main(args: Array[String]): Unit = {
    println("CoreOne!")

    val list = List("1", "2", "3")

    for (i <- 0 until list.length) {
      println(i + "th element is: " + list(i));
    }

    for (strInt <- list) {
      println(strInt);
    }

    def listOne = list.flatMap(o => o)
    println("listOne :" + listOne)

    val ptOne = new Point(1, 2)
    println(ptOne)
    ptOne.move(10, 10)
    println(ptOne)

    val ptTwo = new Point(1)
    println(ptTwo)
    ptTwo.move(10, 10)
    println(ptTwo)

    val ptThree = new Point()
    println(ptThree)
    ptThree.move(10, 10)
    println(ptThree)
  }
}

class Point(xc: Int, yc: Int) {

  var x: Int = xc
  var y: Int = yc

  def this(xc: Int) {
    this(xc, 0)

  }
  def this() {
    this(0, 0)
  }

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = "(" + x + ", " + y + ")";
}





/*
OUTPUT

CoreOne!
0th element is: 1
1th element is: 2
2th element is: 3
1
2
3
listOne :List(1, 2, 3)
(1, 2)
(11, 12)
(1, 0)
(11, 10)
(0, 0)
(10, 10)


*/