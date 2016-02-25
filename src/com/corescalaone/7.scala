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

    //1. ForExpressions
    val strList = "welcome to scala for expressions".split(" ").toList
    for (str <- strList) println(str)

    for (i <- 0 to strList.length - 1) println(strList(i))
    for (i <- 0 until strList.length) println(strList(i))
    //Filtering
    for (i <- 0 until strList.length if strList(i).equals("scala")) println(strList(i))
    for (i <- 0 until strList.length if strList(i).equals("scala") if !strList(i).equals("for")) println(strList(i))

    for (str <- strList if str.equals("scala"); str <- strList if !str.equals("for")) println(str + " " + str)

    val strYield = for (str <- strList if str.equals("scala") ) yield str
    println(strList + " | " + strYield)
    strYield.foreach { x => println(x) }

    //2. ExceptionHandling
    val afile: java.io.File = new File("D:/thanooj/work/Workspaces/WSscala/WSOne/CoreScalaNew/resources/Authors.csv")
    val authorList = loadAuthorsFromFile(afile)
    authorList.foreach { println }

    //3. Match expressions
    for (str <- strList) yield str match {
      case "welcome"     => println("welcome")
      case "to"          => println("to")
      case "scala"       => println("scala")
      case "for"         => println("for")
      case "expressions" => println("expressions")
      case _             => println("nothing?")
    }

    //4. Living without break and continue
    var i = 0
    var foundIt = false
    while (i < args.length && !foundIt) {
      if (!args(i).startsWith("")) {
        if (args(i).endsWith(".scala"))
          foundIt = true // break
      }
      i = i + 1
    }
    val inLine = new BufferedReader(new InputStreamReader(System.in))
    breakable {
      while (true) {
        println(inLine.lines())
        if (inLine.readLine() == "") break
      }
    }

    //5. Variable scope
    val aValOne = 1
    //val aValOne = 2 // Does not compile
    println(aValOne)

    val aValTwo = 2;
    {
      val aValTwo = 3; { // Compiles just fine
        println(aValTwo)//3
      }
      println(aValTwo)//3
    }
    println(aValTwo)//2

  }
  def loadAuthorsFromFile(afile: java.io.File): MutableList[Author] = {
    var authorList: MutableList[Author] = MutableList[Author]()
    try {
      for (line <- Source.fromFile(afile).getLines()) {
        val authorArr = line.split(",")
        val author: Author = new Author(authorArr(0).toInt, authorArr(1), authorArr(2))
        authorList += author
      }
    } catch {
      case ex: FileNotFoundException => println("FileNotFoundException : " + ex)
      case ex: IOException           => println("IO Exception : " + ex)
    } finally {
      println("OK")
    }
    authorList
  }
}