import scala.io.StdIn.{readInt, readLine}

object ALDS1_4_D extends App {

  val Array(n, noOfTrucks) = readLine.split(" ").map(_.toInt)
  val weights: Array[Int] = new Array[Int](n)
  var sum = 0L
  for (i <- 0 until n) {
    val w = readInt
    weights(i) = w
    sum += w
  }
  val ans = allocation(noOfTrucks, weights, sum)
  println(ans)

  def allocation(noOfTrucks: Int, weights: Array[Int], sum: Long): Long = {
    var start = 0L
    var end = sum
    while (true) {
      val p = (start + end) / 2
      val success = canAllocate(p, weights, noOfTrucks);
      if (success && start == end) {
        return p
      }
      if (success) {
        end = p - 1
      } else {
        start = p + 1
      }
      if (start > end) {
        end = start
      }
    }
    -1
  }

  def canAllocate(p: Long, weights: Array[Int], noOfTrucks: Int): Boolean = {
    var truckCount = 1
    var load = 0
    weights.foreach( w => {
      if (w > p) return false
      if (load + w <= p) {
        load += w
      } else {
        truckCount += 1
        if (truckCount > noOfTrucks) {
          return false
        }
        load = w
      }
    })
    true
  }
}
