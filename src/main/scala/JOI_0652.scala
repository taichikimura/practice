import scala.io.StdIn.readLine

object JOI_0652 extends App {
  val arr = readLine.split(" ").map(_.toInt)



  var b = arr.sorted


  val team1 = b(0) + b(3)
  val team2 = b(1) + b(2)
  println(Math.abs(team1 - team2))
}
