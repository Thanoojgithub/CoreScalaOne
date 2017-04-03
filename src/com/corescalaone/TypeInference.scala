package com.corescalaone
/**
 * Type Inference
 * Let the compiler figure out the types for you.
 * The Scala compiler is smart about static types.
 * Most of the time, you need not tell it the types of your variables.
 * Instead, its powerful type inference will figure them out for you.
 */
import scala.util.Random

object TypeInference {
  
def main(args: Array[String]): Unit = {
    val people = createRandomPeople()
    people.foreach(println)
    println(underagePeopleNames(people))
    underagePeopleNames(people).foreach(println)
    
    val listAny = 2 :: 1 :: "bar" :: "foo" :: Nil
    listAny.foreach(println)
    println(listAny.head)
    dropHead(List(1,2,3,4,5)).foreach(println)
  }

  def underagePeopleNames(persons: List[Person]) = {
    for (person <- persons; if person.age < 18)
      yield person
  }

  def createRandomPeople() = {
    val names = List("Alice", "Bob", "Carol",
      "Dave", "Eve", "Frank")
    for (name <- names) yield {
      val age = (Random.nextGaussian() * 8 + 20).toInt
      new Person(name, age)
    }
  }

  def dropHead[A](l: List[A]) = l.tail
}



class Person(val name: String, val age: Int) {
  override def toString = this.name + " (" + this.age + ")"
}