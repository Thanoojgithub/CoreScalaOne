package com.corescalaone

import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._

/**
 * Scala is a pure object-oriented language in the sense that everything is an object, including numbers or functions.
 */
object InteractionWithJava {

  def main(args: Array[String]) {
    getADateInstance
  }
  
  def getADateInstance(): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.ENGLISH)
    println(now + " || " + (df format now))
  }
}