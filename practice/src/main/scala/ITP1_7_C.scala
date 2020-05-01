
import scala.io.StdIn.readLine

object ITP1_7_C {

  def main(args: Array[String]): Unit = {

    val Array(r, c) = readLine().split(" ").map(_.toInt)
    val matrix = Array.fill(r, c)(0)
    0 until r foreach {
      matrix(_) = readLine().split(" ").map(_.toInt)
    }

    val totalRow = Array.ofDim[Int](c + 1)
    matrix.foreach { row =>
      println(s"${row.mkString(" ")} ${row.sum}")
      row.zipWithIndex.foreach { case(cellValue, cellIndex) =>
        totalRow(cellIndex) += cellValue
      }
      totalRow(c) += row.sum
    }
    println(s"${totalRow.mkString(" ")}")
  }
}
