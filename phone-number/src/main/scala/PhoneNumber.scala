object PhoneNumber {
  private val zeroOrOne = List('0', '1')

  def clean(number: String): Option[String] = {
    number match {
      case x if x.matches(".*[a-z].*") || x.matches(".*[@:!].*") => None
      case _ => number.replaceAll("[^0-9]", "") match {
        case c if c.length < 10 || c.length > 11 => None
        case c if c.length > 10 => c.head match {
          case '1' => Some(c.tail)
          case _ => None
        }
        case c if zeroOrOne.contains(c.head) || zeroOrOne.contains(c.charAt(3)) => None
        case c => Some(c)
      }
    }
  }
}