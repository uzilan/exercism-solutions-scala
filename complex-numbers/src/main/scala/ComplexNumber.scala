import scala.math.{cos, sin, sqrt, exp => mexp}

case class ComplexNumber(real: Double = 0, imaginary: Double = 0) {

   //  sum: (a + i * b) + (c + i * d) = (a + c) + (b + d) * i
   def +(that: ComplexNumber): ComplexNumber =
      ComplexNumber(this.real + that.real, this.imaginary + that.imaginary)

   //  difference: (a + i * b) - (c + i * d) = (a - c) + (b - d) * i
   def -(that: ComplexNumber): ComplexNumber =
      ComplexNumber(this.real - that.real, this.imaginary - that.imaginary)

   // multiplication: (a + i * b) * (c + i * d) = (a * c - b * d) + (b * c + a * d) * i
   def *(that: ComplexNumber): ComplexNumber = {
      val ac = this.real * that.real
      val bd = this.imaginary * that.imaginary
      val bc = this.imaginary * that.real
      val ad = this.real * that.imaginary
      ComplexNumber(ac - bd, bc + ad)
   }

   // division: (a + i * b) / (c + i * d) = (a + i * b) / (c + i * d) = (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i
   def /(that: ComplexNumber): ComplexNumber = {
      val ac = this.real * that.real
      val bd = this.imaginary * that.imaginary
      val bc = this.imaginary * that.real
      val ad = this.real * that.imaginary
      val denominator = that.real.square + that.imaginary.square
      ComplexNumber((ac + bd) / denominator, (bc - ad) / denominator)
   }

   // abs: |z| = sqrt(a^2 + b^2)
   def abs(): Double = sqrt(real.square + imaginary.square)

   // conjugate: a - b * i
   def conjugate(): ComplexNumber = ComplexNumber(real, -imaginary)

   implicit class AugmentedDouble(d: Double) {
      def square() = d * d
   }
}

object ComplexNumber {
   // exp(a, bi) = exp(a) * exp(bi), where exp(bi) = cos(b) + sin(b).
   def exp(complex: ComplexNumber): ComplexNumber = {
      val expa = mexp(complex.real)
      val expb = ComplexNumber(cos(complex.imaginary), sin(complex.imaginary))
      ComplexNumber(real = expa) * expb
   }
}
