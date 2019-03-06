case class Matrix(input: String) {

   private val rows = input.split("\n").map {
      _.split(" ")
       .map(s => s.toInt)
       .toVector
   }

   private val cols = rows.head.indices.map { i =>
      rows.map(row => row(i)).toVector
   }

   def row(i: Int): Vector[Int] = rows(i)

   def column(i: Int): Vector[Int] = cols(i)
}
