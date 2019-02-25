import scala.math.pow

object ArmstrongNumbers {
   def isArmstrongNumber(number: Int): Boolean = {
      val string = number.toString
      string.map(c => pow(c.asDigit, string.length)).sum == number
   }
}
