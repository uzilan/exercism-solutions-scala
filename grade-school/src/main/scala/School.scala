import scala.collection.immutable.ListMap
import scala.collection.mutable.{Map => MuMap, Seq => MuSeq}

class School {
   type DB = Map[Int, Seq[String]]

   def add(name: String, g: Int) = {
      val names = map.getOrElse(g, MuSeq[String]())
      map.put(g, names :+ name)
   }

   def db: DB = map.toMap[Int, Seq[String]]

   def grade(g: Int): Seq[String] = map.getOrElse(g, Seq())

   def sorted: DB = {
      val sorted = map.map { case (x, y) => (x, y.sorted) }
      ListMap(sorted.toSeq.sortBy(_._1): _*)
   }

   val map = MuMap[Int, MuSeq[String]]()
}
