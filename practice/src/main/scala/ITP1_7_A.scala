
import scala.io.StdIn.readLine

object ITP1_7_A {

  def main(args: Array[String]): Unit = {

    var continue = true
    while (continue) {
      val Array(m, f, r) = readLine().split(" ").map(_.toInt)
      if (m == -1 && f == -1 && r == -1) {
        continue = false
      } else {
        printGrade(m, f, r)
      }
    }
  }

  def printGrade(m: Int, f: Int, r: Int): Unit = {
    if (m == -1 || f == -1) {
      println("F")
    } else {
      m + f match {
        case x if x >= 80 => println("A")
        case x if x >= 65 => println("B")
        case x if x >= 50 => println("C")
        case x if x >= 30 => {
          if (r >= 50) println("C")
          else println("D")
        }
        case _ => println("F")
      }
    }
  }

}
