object BeerSong {
   def recite(start: Int, count: Int): String = {
      (start - count + 1 to start).reverse.map {
         case i@0 => s"${i.bottles().capitalize} of beer on the wall, ${i.bottles()} of beer.\n" +
            s"Go to the store and buy some more, ${99.bottles()} of beer on the wall.\n"

         case i => s"${i.bottles()} of beer on the wall, ${i.bottles()} of beer.\n" +
            s"Take ${i.one()} down and pass it around, ${(i - 1).bottles()} of beer on the wall.\n"
      }.mkString("\n")
   }

   implicit class BottleInt(i: Int) {
      def bottles(): String = i match {
         case 0 => "no more bottles"
         case 1 => "1 bottle"
         case _ => s"$i bottles"
      }

      def one(): String = if (i == 1) "it" else "one"
   }
}