object Raindrops {
  def convert(n: Int): String = {
    val strings =
      List(3, 5, 7)
        .map { number => (number, n % number == 0) }
        .filter { pair => pair._2 }
        .map { pair =>
          pair._1 match {
            case 3 => "Pling"
            case 5 => "Plang"
            case 7 => "Plong"
          }
        }
    if (strings.nonEmpty) strings.mkString("")
    else n.toString
  }
}
