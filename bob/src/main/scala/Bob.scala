object Bob {
   def response(statement: String): String = statement.trim match {
      case s if s.isEmpty => "Fine. Be that way!"
      case s if isUppercase(s) => if (s.endsWith("?")) "Calm down, I know what I'm doing!" else "Whoa, chill out!"
      case s if s.endsWith("?") => "Sure."
      case _ => "Whatever."
   }

   def isUppercase(s: String): Boolean =
      s.exists(c => c.isLetter) &&
         s.forall(c => !c.isLetter || c.isUpper)
}

