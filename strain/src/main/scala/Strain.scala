object Strain {
   def keep[T](seq: Seq[T], predicate: T => Boolean): Seq[T] =
      seq.foldLeft(Seq[T]()) {
         (acc, item) => if (predicate(item)) item +: acc else acc
      }.reverse

   def discard[T](seq: Seq[T], predicate: T => Boolean): Seq[T] =
      keep[T](seq, !predicate(_))
}