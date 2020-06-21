package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_11_A extends App {

  val labels = readLine().split(" ")
  val directions = readLine()

  val dice: Dice = new Dice(labels)
  dice.move(directions)
  println(dice.getLabel(0))

  class Dice(labels: Array[String]) {

    object f extends Enumeration {
      val top = 0
      val front = 1
      val right = 2
      val left = 3
      val back = 4
      val bottom = 5
    }

    val faces = Array.fill(6){0}
    for (i <- 0 until faces.length) {
      faces(i) = i
    }

    def getLabel(i: Int): String = {
      labels(faces(i))
    }

    def setFace(topLabel: String, frontLabel: String): Boolean = {
      var currentPos = getCurrentPos(topLabel)
      currentPos match {
        case p if p == faces(f.top) => {}
        case p if p == faces(f.front) => move("N")
        case p if p == faces(f.right) => move("W")
        case p if p == faces(f.left) => move("E")
        case p if p == faces(f.back) => move("S")
        case p if p == faces(f.bottom) => move("EE")
        case -1 => return false
      }
      currentPos = getCurrentPos(frontLabel)
      currentPos match {
        case p if p == faces(f.top) => return false
        case p if p == faces(f.front) => {}
        case p if p == faces(f.right) => move("SEN")
        case p if p == faces(f.left) => move("SWN")
        case p if p == faces(f.back) => move("SEEN")
        case p if p == faces(f.bottom) => return false
        case -1 => return false
      }
      true
    }

    def getCurrentPos(label: String): Int = {
      for (i <- 0 until labels.length) {
        if (labels(faces(i)).equals(label)) {
          return faces(i)
        }
      }
      -1
    }

    def move(direction: String): Unit = {
      direction.foreach(move(_))
    }

    def move(direction: Char): Unit = {
      val oldTop = faces(f.top);
      direction match {
        case 'S' => {
          faces(f.top) = faces(f.back)
          faces(f.back) = faces(f.bottom)
          faces(f.bottom) = faces(f.front)
          faces(f.front) = oldTop
        }
        case 'N' => {
          faces(f.top) = faces(f.front)
          faces(f.front) = faces(f.bottom)
          faces(f.bottom) = faces(f.back)
          faces(f.back) = oldTop
        }
        case 'W' => {
          faces(f.top) = faces(f.right)
          faces(f.right) = faces(f.bottom)
          faces(f.bottom) = faces(f.left)
          faces(f.left) = oldTop
        }
        case 'E' => {
          faces(f.top) = faces(f.left)
          faces(f.left) = faces(f.bottom)
          faces(f.bottom) = faces(f.right)
          faces(f.right) = oldTop
        }
      }
    }

    def isIdentical(other: Dice): Boolean = {
      for (i <- 0 until labels.length; j <- 0 until labels.length) {
        val success1 = this.setFace(labels(i), labels(j))
        val success2 = other.setFace(labels(i), labels(j))
        if (success1 && success2 && checkIdentical(other)) {
          return true
        }
      }
      false
    }

    def checkIdentical(other: Dice): Boolean = {
      for (i <- 0 until labels.length) {
        if (!getLabel(i).equals(other.getLabel(i))) { return false }
      }
      true
    }
  }

}
