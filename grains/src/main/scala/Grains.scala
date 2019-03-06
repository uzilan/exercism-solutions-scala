import scala.math.BigInt

object Grains {
   def square(sq: Int): Option[BigInt] =
      if (sq <= 0 || sq > 64) None
      else Some(BigInt(2).pow(sq - 1))

   def total: BigInt = (0 until 64).foldLeft(BigInt(1)) { (acc, _) => acc * 2 } - 1
}
