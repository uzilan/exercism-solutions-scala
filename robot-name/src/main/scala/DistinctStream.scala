import scala.collection.mutable
import scala.util.Random.shuffle

object DistinctStreamTest {
  def rand(): Stream[Int] = Stream.cons(shuffle(1 to 1000).head, rand()).distinct

  def main(args: Array[String]): Unit = {
    val usedNumbers = mutable.HashSet.empty[String]
    (0 to 100).foreach(i => {
      val newNumber = rand().take(1).mkString
      if (usedNumbers.contains(newNumber)) {
        println(s"Found duplicates: $newNumber after $i iterations")
      }
      usedNumbers += newNumber
    })
  }
}