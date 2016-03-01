package com.corescalaone

import scala.collection.mutable.MutableList
import java.io.IOException
import java.io.FileNotFoundException
import scala.io.Source
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader

import scala.util.control.Breaks._
import java.io._

object ForExpressionsExceptionHandling {
  def main(args: Array[String]): Unit = {
    val afile: java.io.FileReader = new FileReader("D:/thanooj/work/Workspaces/WSscala/WSOne/CoreScalaNew/resources/Authors.csv")
    partialFunctionOne(afile)
  }

  def partialFunctionOne(afile: FileReader) = {
    val input = new BufferedReader(afile)
    try {
      for (line <- Iterator.continually(input.readLine()).takeWhile(_ != null)) {
        println(line)
      }
    } catch {
      case e: IOException => e
    } finally {
      input.close()
      afile.close()
    }
  }
}
  
/*ExpressionsExceptionHandling

OUTPUT:
------


*/
