object Etl {
  def transform(old: Map[Int, Seq[String]]): Map[String, Int] = {
    old.flatMap { case (number, letters) =>
      letters.map { letter =>
        letter.toLowerCase -> number
      }
    }
  }
}
