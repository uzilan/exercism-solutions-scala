object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = (n * (n + 1) * (2 * n + 1)) / 6

  def squareOfSum(n: Int): Int = square((n * (n + 1)) / 2)

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)

  private def square(n: Int): Int = n * n
}
