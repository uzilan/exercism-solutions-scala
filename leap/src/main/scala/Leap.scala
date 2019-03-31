object Leap {
  def leapYear(year: Int): Boolean =
    year.divisibleBy(4) &&
      (!year.divisibleBy(100) ||
        year.divisibleBy(400))

  implicit class AugmentedInt(i: Int) {
    def divisibleBy(number: Int): Boolean = i % number == 0
  }

}
