import scala.io.StdIn.{readInt, readLine}

object ALDS1_4_B extends App {
  val n = readInt
  val numbers = readLine.split(" ").map(_.toInt)
  val q = readInt
  var ans = 0
  readLine.split(" ").foreach( key => {
    ans += binarySearch(numbers, key.toInt)
  })
  println(ans)

  def binarySearch(numbers: Array[Int], key: Int): Int = {
    var start = 0
    var end = numbers.length - 1
    while (true) {
      val mid = (start + end) / 2
      if (numbers(mid) == key) {
        return 1
      }
      if (numbers(mid) < key) {
        start = mid + 1
      } else {
        end = mid - 1
      }
      if (start > end || start < 0 || end > numbers.length - 1) {
        return 0
      }
    }
    0
  }
}
