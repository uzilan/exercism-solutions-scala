object Strain {
   def keep[T](seq: Seq[T], predicate: T => Boolean): Seq[T] =
      seq.foldLeft(Seq[T]()) {
         (acc, item) => if (predicate(item)) acc :+ item else acc
      }

   def discard[T](seq: Seq[T], predicate: T => Boolean): Seq[T] =
      seq.foldLeft(Seq[T]()) {
         (acc, item) => if (predicate(item)) acc else acc :+ item
      }
}