package com.corescalaone

trait Output {
  def print(s: String) = Console.println(s)
}

class Hi extends Output {
  def hello() = print("hello world!")
}

object Inheritance {

  def main(args: Array[String]): Unit = {
    val hi = new Hi with Output
    hi.hello()
  }
}