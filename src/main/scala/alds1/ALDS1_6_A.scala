import scala.io.StdIn.{readInt, readLine}

object ALDS1_6_A extends App {

  val n = readInt
  val A = readLine.split(" ").map(_.toInt)
  val B = Array.fill[Int](n)(0)
  coutingSort(A, B, A.max)
  println(B.mkString(" "))

  def coutingSort(A: Array[Int], B: Array[Int], k: Int): Unit = {
    val C = Array.fill[Int](k + 1)(0)
    A.map(C(_) += 1)
    List.range(1, k + 1).foreach( i => C(i) += C(i-1) )
    A.reverse.foreach( value => {
      val idx = C(value) - 1
      B(idx) = value
      C(value) -= 1
    })
  }
}
