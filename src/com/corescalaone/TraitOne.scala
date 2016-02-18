package com.corescalaone

object TraitOne {
  def main(args: Array[String]): Unit = {

    val starCruiser = new StarCruiser(100, 0)
    println(starCruiser.engage)
    println(starCruiser.speedUp)
  }
}

abstract class Spacecraft {
  def engage(): String
}

trait CommandoBridge extends Spacecraft {
  def engage(): String = {
    println("inside engage")
    for (_ <- 1 to 3) {
      println("inside loop engage")
      speedUp()
    }
    "engage loop for 3 times"
  }
  def speedUp(): Int
}

trait PulseEngine extends Spacecraft {
  val maxPulse: Int
  var currentPulse: Int
  def speedUp(): Int = {
    println("inside speedUp " + maxPulse)
    if (currentPulse < maxPulse) {
      println("inside if speedUp")
      currentPulse += 1
    }
    currentPulse
  }
}

class StarCruiser(mp: Int, cp: Int) extends Spacecraft with CommandoBridge with PulseEngine {
  val maxPulse = mp
  var currentPulse = cp
}