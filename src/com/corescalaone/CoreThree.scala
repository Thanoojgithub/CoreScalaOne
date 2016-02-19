package com.corescalaone

// Pizza class
class Pizza(var crustType: String) {
  val pizzaVendor = "PizzaHut"
  override def toString = "Crust type is " + crustType
}

// companion object
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
}
class MyString(val jString: String) {
  private var extraData = ""
  override def toString = jString + extraData
}
object MyString {
  def apply(jString: String, extras: String) = {
    val s = new MyString(jString)
    s.extraData = extras
    s
  }
  def apply(jString: String) = new MyString(jString)
}
object CoreThree {
  def main(args: Array[String]): Unit = {

    println(Pizza.CRUST_TYPE_THIN)
    var pOne = new Pizza(Pizza.CRUST_TYPE_THICK)
    var pTwo = new Pizza(Pizza.CRUST_TYPE_THICK)
    var pObjOne = Pizza
    var pObjTwo = Pizza
    var pThree = new Pizza(Pizza.CRUST_TYPE_THICK)
    println(pOne)
    println(Pizza.getFoo)
    //589431969 1252169911 2101973421
    println(pObjOne.hashCode + " == " + pObjTwo.hashCode + " || " + pOne.hashCode + " != " + pTwo.hashCode)
    println(pOne.pizzaVendor)
    println(MyString("hello", " world"))
    println(MyString("hello"))

    //singleton call
    println(com.corescalaone.SumOfList.sum(List(1, 2, 3)))

    //Case Classes
    val summation = new Summation(20, 10)
    println(ArithmaticCaseClass.doArithmatic(summation))
    val multiplication = new Multiplication(20, 10)
    ArithmaticCaseClass.doArithmatic(multiplication)
    val division = new Division(20, 10)
    ArithmaticCaseClass.doArithmatic(division)
    val subtraction = new Subtraction(20, 10)
    ArithmaticCaseClass.doArithmatic(subtraction)
  }
}

/**
 * Case Classes
 */
abstract class Arithmatic
case class Summation(x: Int, y: Int) extends Arithmatic {
  def summation(x: Int, y: Int): Long = {
    x + y
  }
}
case class Multiplication(x: Int, y: Int) extends Arithmatic {
  def multiplication(x: Int, y: Int): Long = {
    x * y
  }
}
case class Division(x: Int, y: Int) extends Arithmatic {
  def division(x: Int, y: Int): Long = {
    x / y
  }
}
case class Subtraction(x: Int, y: Int) extends Arithmatic {
  def subtraction(x: Int, y: Int): Long = {
    x - y
  }
}

object ArithmaticCaseClass {
  var result: Any = 0.0
  def doArithmatic(arithmatic: Arithmatic): Any = {
    arithmatic match {
      case Summation(x, y)      => { result = x + y }
      case Multiplication(x, y) => { result = x * y }
      case Division(x, y)       => { result = x / y }
      case Subtraction(x, y)    => { result = x - y }
    }
    result
  }
}