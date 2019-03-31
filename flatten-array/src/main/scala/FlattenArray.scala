object FlattenArray {
  def flatten(list: List[_], acc: List[_] = List()): List[_] = {
    list match {
      case null | List() => acc.reverse
      case head :: tail =>
        head match {
          case null | List() => flatten(tail, acc)
          case li: List[_] => flatten(li.head :: li.tail :: tail, acc)
          case _ => flatten(tail, head :: acc)
        }
    }
  }
}