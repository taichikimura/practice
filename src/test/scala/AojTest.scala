import java.io.ByteArrayInputStream

object AojTest {

  val inputs = Array(
    "16\ninsert 35 99\ninsert 3 80\ninsert 1 53\ninsert 14 25\ninsert 80 76\ninsert 42 3\ninsert 86 47\ninsert 21 12\ninsert 7 10\ninsert 6 90\nprint\nfind 21\nfind 22\ndelete 35\ndelete 99\nprint"
//    "4\ninsert 1 10\ninsert 2 30\ninsert 3 40\nprint"
//    "43\ninsert 30\ninsert 17\ninsert 88\ninsert 53\ninsert 5\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ninsert 60\nprint\nfind -1\nfind 2\nfind 3\nfind 4\nfind 5\nfind 6\nfind 10\nfind 17\nfind 28\nfind 29\nfind 30\nfind 31\nfind 50\nfind 51\nfind 52\nfind 53\nfind 54\nfind 60\nfind 88\nfind 89\ninsert 2000000000\ninsert 55\ninsert 63\ninsert -1\ninsert 8\nprint\ndelete 53\ndelete 2000000000\ndelete 20\ndelete 5\ndelete 8\nprint"
  )

  def main(args: Array[String]): Unit = {
    prepare()
    inputs.foreach { input => {
      ALDS1_8_D.main(Array())
    }}
  }

  def prepare(): Unit = {
    val inContent = new ByteArrayInputStream(inputs.mkString("\n").getBytes)
    System.setIn(inContent)
  }
}
