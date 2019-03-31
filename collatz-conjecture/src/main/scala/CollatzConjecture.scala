import scala.annotation.tailrec

object CollatzConjecture {

  @tailrec def steps(i: Int, count: Int = 0): Option[Int] = i match {
    case 1 => Some(count)
    case _ if i <= 0 => None
    case _ if i % 2 == 0 => steps(i / 2, count + 1)
    case _ => steps(i * 3 + 1, count + 1)
  }
}
