package main.scala.itp1

import scala.collection.mutable
import scala.io.StdIn.{readInt, readLine}

object ITP1_6_B {

  def main(args: Array[String]): Unit = {

    val hashSet = mutable.HashSet[String]()
    val n = readInt()
    for (_ <- 1 to n) {
      hashSet.add(readLine())
    }

    Array("S", "H", "C", "D").foreach(suit =>
      for (rank <- 1 to 13) {
        val card = s"${suit} ${rank}"
        if (!hashSet.contains(card)) {
          println(card)
        }
      }
    )
  }
}
