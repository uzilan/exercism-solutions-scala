import scala.math.BigInt

object Grains {
   def square(sq: Int): Option[BigInt] =
      if (sq <= 0 || sq > 64) None
      else Some(BigInt(2).pow(sq - 1))

   def total: BigInt = BigInt(2).pow(64) - 1
}
