import NumberType.{Abundant, Deficient, Perfect}

object PerfectNumbers {
  def classify(number: Int): Either[String, NumberType] = {
    if (number <= 0) Left("Classification is only possible for natural numbers.")
    else factors(number).sum match {
      case p if p == number => Right(Perfect)
      case a if a > number => Right(Abundant)
      case _ => Right(Deficient)
    }
  }

  private def factors(num: Int): IndexedSeq[Int] = (1 to num / 2).filter {
    num % _ == 0
  }
}

sealed abstract class NumberType

object NumberType {

  case object Perfect extends NumberType

  case object Abundant extends NumberType

  case object Deficient extends NumberType

}
