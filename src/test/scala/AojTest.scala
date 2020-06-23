package test.scala
import main.scala.alds1._
import java.io.ByteArrayInputStream

object AojTest {

  val inputs = Array(
//    "8\ninsert 30\ninsert 17\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ndelete 20\nprint"
//    "25\ninsert 30\ninsert 17\ninsert 88\ninsert 53\ninsert 5\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ninsert 60\ninsert 2000000000\ninsert 55\ninsert 63\ninsert -1\ninsert 8\ndelete 53\nprint\ndelete 2000000000\nprint\ndelete 20\nprint\ndelete 5\nprint\ndelete 8\nprint"
    "43\ninsert 30\ninsert 17\ninsert 88\ninsert 53\ninsert 5\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ninsert 60\nprint\nfind -1\nfind 2\nfind 3\nfind 4\nfind 5\nfind 6\nfind 10\nfind 17\nfind 28\nfind 29\nfind 30\nfind 31\nfind 50\nfind 51\nfind 52\nfind 53\nfind 54\nfind 60\nfind 88\nfind 89\ninsert 2000000000\ninsert 55\ninsert 63\ninsert -1\ninsert 8\nprint\ndelete 53\ndelete 2000000000\ndelete 20\ndelete 5\ndelete 8\nprint"
  )

  def main(args: Array[String]): Unit = {
    prepare()
    inputs.foreach { input => {
      ALDS1_8_A_B_C.main(Array())
    }}
  }

  def prepare(): Unit = {
    val inContent = new ByteArrayInputStream(inputs.mkString("\n").getBytes)
    System.setIn(inContent)
  }
}
