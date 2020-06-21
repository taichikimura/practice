package main.scala.itp1

import scala.collection.mutable
import scala.io.StdIn.{readInt, readLine}

object ITP1_6_B {

  def main(args: Array[String]): Unit = {
    val n = readInt()
    val set = mutable.HashSet[String]()
    for (_ <- 1 to n) {
      set.add(readLine())
    }

    Array("S", "H", "C", "D").foreach(suit => {
      (1 to 13).foreach(rank => {
        val card = s"${suit} ${rank}"
        if (!set.contains(card)) { println(card) }
      })
    })
   }
}
