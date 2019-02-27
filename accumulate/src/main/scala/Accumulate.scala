import scala.annotation.tailrec

class Accumulate {
   @tailrec final def accumulate[A, B](f: A => B, list: List[A], acc: List[B] = Nil): List[B] =
      list match {
         case List() => acc
         case x :: tail => accumulate(f, tail, acc :+ f(x))
      }
}
