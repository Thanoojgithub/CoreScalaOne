class Point(val xc: Int, val yc: Int) {
   var x: Int = xc
   var y: Int = yc
   
   def move(dx: Int, dy: Int) {
      x = x + dx
      y = y + dy
      println ("Point x location of move(x,y): " + x);
      println ("Point y location of move(x,y): " + y);
   }
}

class Location(override val xc: Int, override val yc: Int,
   val zc :Int) extends Point(xc, yc){
   var z: Int = zc

   def move(dx: Int, dy: Int, dz: Int) {
      x = x + dx
      y = y + dy
      z = z + dz
      println ("Point x location of move(x,y,z) : " + x);
      println ("Point y location of move(x,y,z) : " + y);
      println ("Point z location of move(x,y,z) : " + z);
   }
}

object Demo {
   def main(args: Array[String]) {
      val loc = new Location(10, 20, 15);
      loc.move(10, 10, 5);
      loc.move(10,10)
   }
}


//OUTPUT
Point x location of move(x,y,z) : 20
Point y location of move(x,y,z) : 30
Point z location of move(x,y,z) : 20
Point x location of move(x,y): 30
Point y location of move(x,y): 40
