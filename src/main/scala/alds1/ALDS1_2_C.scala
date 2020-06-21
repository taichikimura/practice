package main.scala.alds1

import scala.io.StdIn.{readInt, readLine}

object ALDS1_2_C extends App {

  val n = readInt
  val cards1 = readLine.split(" ")
  val cards2 = cards1.clone()

  bubbleSort(n, cards1)
  selectionSort(n, cards2)

  val sortedCards1 = cards1.mkString(" ")
  val sortedCards2 = cards2.mkString(" ")

  println(sortedCards1)
  println("Stable")

  println(sortedCards2)
  if (sortedCards1.equals(sortedCards2)) {
    println("Stable")
  } else {
    println("Not stable")
  }

  def bubbleSort(n: Int, cards: Array[String]) = {
    for (i <- 0 to n - 1; j <- n - 1 to i + 1 by -1) {
      if (compareCards(cards(j), cards(j - 1)) < 0) {
        swapCard(cards, j, j - 1)
      }
    }
  }

  def selectionSort(n: Int, cards: Array[String]) = {
    for (i <- 0 until n) {
      var mini = i
      for (j <- i + 1 until n) {
        if (compareCards(cards(j), cards(mini)) < 0) {
          mini = j
        }
      }
      if (i != mini) {
        swapCard(cards, i, mini)
      }
    }
  }

  def compareCards(card1: String, card2: String): Int = {
    val value1 = card1.substring(1).toInt
    val value2 = card2.substring(1).toInt
    value1 - value2
  }

  def swapCard(cards: Array[String], i: Int, j: Int): Unit = {
    val tmp = cards(i)
    cards(i) = cards(j)
    cards(j) = tmp
  }

}
