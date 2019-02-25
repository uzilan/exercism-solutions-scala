import Robot._

import scala.util.Random.shuffle

object Robot {
   private val numberOfLetters = 2
   private val numberOfDigits = 3
   private val chars = 'A' to 'Z'
   private val digits = 0 to 9

   private val random: Iterator[String] = {
      Stream.from(1).map(_ => randomName).distinct.iterator
   }

   private def randomName = {
      val letters = (0 until numberOfLetters).map(_ => randomLetter()).mkString
      val numbers = (0 until numberOfDigits).map(_ => randomDigit()).mkString
      letters + numbers
   }

   private def randomLetter(): Char = shuffle[Char, IndexedSeq](chars).head

   private def randomDigit(): Int = shuffle(digits).head
}

class Robot {
   var name = ""

   final def reset() {
      name = random.next()
   }

   reset()
}

