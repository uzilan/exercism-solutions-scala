object Isogram {
   def isIsogram(string: String): Boolean = {
      val cleaned = string.replaceAll("[^A-Za-z]", "").toLowerCase
      cleaned.distinct.length == cleaned.length
   }
}
