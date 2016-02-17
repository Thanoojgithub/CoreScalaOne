package com.corescalaone

trait Animal {
  def print(s: String): String
}

trait Mammal extends Animal {
  override def print(s: String): String = { s + " - Mammal" }
}

trait Reptile extends Animal {
  override def print(s: String): String = { s + " - Reptile" }
}

class MammalOrReptile extends Reptile with Mammal

class ReptileOrMammal extends Mammal with Reptile

class AnimalLocal extends Mammal with Reptile {
  def hello() = print("Animal Locally")
  override def print(s: String): String = { s }
}

object Inheritance {

  def main(args: Array[String]): Unit = {
    val mammal = new Mammal {}
    println(mammal.print("Elephant"));

    val reptile = new Reptile {}
    println(reptile.print("Turtle"));

    val mammalOrReptile = new MammalOrReptile
    println(mammalOrReptile.print("Elephant"))

    val reptileOrMammal = new ReptileOrMammal
    println(reptileOrMammal.print("Turtle"))

    val animalLocal = new AnimalLocal
    println(animalLocal.hello)
    println(animalLocal.print("Animal Locally"))

    // object reference as argument 
    val fooWithBar = new FooWithBar
    val fooBar = new FooBar with Foo with Bar
    fooWithBar.bazFooBar(fooBar)
  }
}

trait Foo { def foo(foo: String) }

trait Bar { def bar(bar: String) }

class FooBar extends Foo with Bar {
  override def foo(foo: String) { println("Hello, " + foo + "!") }
  override def bar(bar: String) { println("Hello, " + bar + "!") }
}

class FooWithBar {
  def bazFooBar(fooBar: FooBar with Foo with Bar) {
    fooBar.foo("foo")
    fooBar.bar("bar")
  }
}


/*
OUTPUT
------


Elephant - Mammal
Turtle - Reptile
Elephant - Mammal
Turtle - Reptile
Animal Locally
Animal Locally
Hello, foo!
Hello, bar!


*/