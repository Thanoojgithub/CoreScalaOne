
object ClassForLoop {
  
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    val addr1 = new Address("Ayodhya");
    val addr2 = new Address("MIdhila");
    val addr3 = new Address("Kishkinda");
    
    val peo1 = new People(addr1)
    val peo2 = new People(addr2)
    val peo3 = new People(addr3)
    
    val peoList = List(peo1, peo2, peo3)
    for(p <- findPeopleIn("Ayodhya", peoList))
      println(p.address.city)
  }
  

  def findPeopleIn (city : String, people : List[People]) : List[People] =
    for (person <- people.toList; if person.address.city  == city) yield person
}

class People (val addr : Address ) {
  var address: Address = addr
}

class Address (val c : String ) {
  var city : String = c
}


/*
RUN:
~>scalac HelloWorld.scala

~>scala HelloWorld
Hello, world!
Ayodhya

~>
