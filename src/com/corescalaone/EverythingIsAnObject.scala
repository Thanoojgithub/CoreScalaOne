package com.corescalaone

import scala.util.Random

object EverythingIsAnObject {

  def main(args: Array[String]) {
    numbersAsObjects(10)
    functionsAsObjects(10)
    println(new MethodsWithoutArgumentsANDInheritanceOverriding(10, 10))
  }

  def numbersAsObjects(x: Int): Unit = {
    println("dotOperationsWithNumbers : " + dotOperationsWithNumbers(x))
  }

  def dotOperationsWithNumbers(x: Int): Int = { 1.toInt + (((2).*(3))./(x)).toInt }

  def functionsAsObjects(i: Int): Unit = {
    println("higherOrderFunctionDef : " + higherOrderFunctionDef(tempCalc, i))
    println("higherOrderFunctionDef : " + callbackFunctionWithArgAsArgument(tempCalc, i))
    println("higherOrderFunctionDef : " + callbackFunctionWithOutArgAsArgument(tempCalc))
    val anonymousFunctions = (x: Int) => x + 1
    println("anonymousFunctions : " + anonymousFunctions(10))
  }

  def higherOrderFunctionDef(higherOrderFunctionAlias: (Int) => Int, i: Int): Double = (higherOrderFunctionAlias(i) / 2).toDouble

  def callbackFunctionWithArgAsArgument(callbackFn: (Int) => Int, i: Int): Int = { (i) }

  def callbackFunctionWithOutArgAsArgument(callbackFn: () => Int): Int = { callbackFn() }

  def tempCalc(i: Int): Int = { i + Random.nextInt(1000) }

  def tempCalc(): Int = Random.nextInt(1000)

}

class MethodsWithoutArgumentsANDInheritanceOverriding(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary
  override def toString() = re + " || " + im;
}