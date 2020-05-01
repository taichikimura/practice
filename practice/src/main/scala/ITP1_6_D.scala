
import scala.io.StdIn.{readInt, readLine}

object ITP1_6_D {

  def main(args: Array[String]): Unit = {

    val SEP = " "
    val Array(n, m) = readLine().split(SEP).map(_.toInt)
    val matrix = Array.fill(n, m)(0)
    0 until n foreach {
      matrix(_) = readLine().split(SEP).map(_.toInt)
    }

    val b = Array.ofDim[Int](m)
    0 until m foreach {
      b(_) = readInt()
    }

    matrix.foreach { arr => {
      var sum = 0
      arr.zip(b).foreach {
        case (a, b) => sum += (a * b)
      }
      println(sum)
    }}

  }
}
