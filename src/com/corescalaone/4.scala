package com.corescalaone

object ClassObject {

  //The Application trait
  def main(args: Array[String]): Unit = {
    val checksumAccumulator: ChecksumAccumulator = new ChecksumAccumulator()
    checksumAccumulator.add(1)
    ChecksumAccumulator.add(checksumAccumulator, 1)
    ChecksumAccumulator.addObj(1)
    println("sum : " + checksumAccumulator.getSum)
    println("a : " + A.run)
  }
}

object ClassObjectApp extends scala.App {
  
  val checksumAccumulator: ChecksumAccumulator = new ChecksumAccumulator()
  checksumAccumulator.add(1)
  ChecksumAccumulator.add(checksumAccumulator, 1)
  ChecksumAccumulator.addObj(1)
  println("sum : " + checksumAccumulator.getSum)
  println("a : " + A.run)
}

class ChecksumAccumulator {
  private var sum = 0

  def getSum: Int = sum
  def setSum_(sum: Int) { this.sum = sum }

  def add(b: Int) = { sum += b; }
}
//Singleton objects
//companion object.
//ChecksumAccumulator companion class
object ChecksumAccumulator extends ChecksumAccumulator {
  def addObj(b: Int) { (ChecksumAccumulator: ChecksumAccumulator).sum += b }
  def add(checksumAccumulator: ChecksumAccumulator, b: Int): Unit = { checksumAccumulator.sum += b }
}

/**
 * NOTE::
 * Private field in class cannot be accessed from companion object
 * def run { A.a = true } - value 'a' is not a member of object com.corescalaone.AObj
 */
class A {
  private var a: Boolean = false
}
object A extends A {
  def run = { (A: A).a = true; (A: A).a }
}