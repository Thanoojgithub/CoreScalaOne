package com.corescalaone

import scala.util.Random

object CaseClasses {

  def main(args: Array[String]): Unit = {
    println(showNotification(Email("thanooj@scala.com", "Scala Tour", "Welcome to Scala Word!!")))
    val sms = SMS(7204437072l, "Scala Tour - Welcome to Scala Word!!")
    println(sms.sourceNumber + " | " + sms.message)
    println(showNotification(sms))
    
    println(doTypeMatch(1))
    println(doTypeMatch(10))
    println(doTypeMatch(10.0))
    println(doTypeMatch("&"))

    val monthNumberToName = Map(
      1 -> "January",
      2 -> "February",
      3 -> "March",
      4 -> "April",
      5 -> "May",
      6 -> "June",
      7 -> "July",
      8 -> "August",
      9 -> "September",
      10 -> "October",
      11 -> "November",
      12 -> "December")
    val monthName = monthNumberToName(9)
    println("monthName from Map : " + monthName)
  }

  def showNotification(notification: Notification): String = notification match {
    case Email(email, title, body)  => "You got an email from " + email + " with title: " + title + " and with body: " + body
    case SMS(number, message)       => "You got an SMS from " + number + "! Message: " + message
    case VoiceRecording(name, link) => "you received a Voice Recording from " + name + "! Click the link to hear it: " + link
  }

  def doTypeMatch(x: Any): Any = x match {
    case 1         => 1
    case i: Int    => i + Random.nextInt(1000)
    case "aString" => "***********a String***********"
    case d: Double => d + Random.nextDouble()
    case _ => "default"
  }

}

abstract class Notification
case class Email(sourceEmail: String, title: String, body: String) extends Notification
case class SMS(sourceNumber: Long, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification