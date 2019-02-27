class Accumulate {
   def accumulate[A, B](f: (A) => B, list: List[A]): List[B] =
      list match {
         case List() => Nil
         case x :: tail => f(x) :: accumulate(f, tail)
      }
}
