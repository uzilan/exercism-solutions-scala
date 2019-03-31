import Sign._

import scala.annotation.tailrec
import scala.language.implicitConversions

object SecretHandshake {
  @tailrec def commands(number: Int, list: List[String] = List(), reverse: Boolean = false): List[String] =
    number match {
      case x if x <= 0 => if (reverse) list.reverse else list
      case x if (x & Reverse) == Reverse.value => commands(number - Reverse, list, reverse = true)
      case x if (x & Jump) == Jump.value => commands(number - Jump, Jump.sign :: list, reverse)
      case x if (x & CloseYourEyes) == CloseYourEyes.value => commands(number - CloseYourEyes, CloseYourEyes.sign :: list, reverse)
      case x if (x & DoubleBlink) == DoubleBlink.value => commands(number - DoubleBlink, DoubleBlink.sign :: list, reverse)
      case x if (x & Wink) == Wink.value => commands(number - Wink, Wink.sign :: list, reverse)
    }
}

sealed abstract class Sign(val value: Int, val sign: String)

object Sign {

  case object Wink extends Sign(binary("1"), "wink")

  case object DoubleBlink extends Sign(binary("10"), "double blink")

  case object CloseYourEyes extends Sign(binary("100"), "close your eyes")

  case object Jump extends Sign(binary("1000"), "jump")

  case object Reverse extends Sign(binary("10000"), "")

  def binary(digits: String) = Integer.parseInt(digits, 2)

  implicit def sign2Int(sign: Sign): Int = sign.value
}