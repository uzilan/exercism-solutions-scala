object Hamming {
   def distance(strand1: String, strand2: String): Option[Int] =
      if (strand1.length != strand2.length) None
      else Some(strand1.zip(strand2).count(p => p._1 != p._2))
}
