package main.scala.alds1

import scala.io.StdIn.readInt

object ALDS1_1_C extends App {
  val n = readInt()
  var cnt = 0
  for (_ <- 1 to n) {
    if (isPrime(readInt())) {
      cnt += 1
    }
  }
  println(cnt)

  def isPrime(x: Int): Boolean = {
    if (x <= 1) return false
    if (x == 2) return true
    if (x % 2 == 0) return false
    for (i <- 3 to Math.sqrt(x).toInt by 2) {
      if (x % i == 0) return false
    }
    true
  }
}
