import scala.io.StdIn.{readInt, readLine}

object ALDS1_6_D extends App {
  val n = readInt
  val A = readLine.split(" ").map(_.toInt)
  val totalCost = calcTotalCost(n, A, A.sorted)
  println(totalCost)

  def calcTotalCost(n: Int, A: Array[Int], B: Array[Int]): Int = {
    val visited = Array.fill[Boolean](n)(false)
    val pos = Array.fill[Int](B.max + 1)(-1)
    B.zipWithIndex.map{ case(e, i) => pos(e) = i }

    val minOfAll = B(0)
    var totalCost = 0
    A.foreach(e => {
      var v = e
      if (!visited(pos(v))) {
        var sum = 0
        var count = 0
        var min = Integer.MAX_VALUE
        while (!visited(pos(v))) {
          visited(pos(v)) = true
          sum += v
          count += 1
          min = Math.min(min, v)
          v = A(pos(v))
        }
        val cost1 = (min * (count - 2)) + sum
        val cost2 = (minOfAll * (count + 1)) + (min * 2) + (sum - min)
        totalCost += Math.min(cost1, cost2)
      }
    })
    totalCost
  }
}
