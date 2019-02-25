object Pangrams {
  def isPangram(input: String): Boolean = {
    val lowercase = input.toLowerCase
    ('a' to 'z').forall(lowercase.contains(_))
  }
}

