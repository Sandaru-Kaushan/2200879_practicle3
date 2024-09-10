object WordProcessor {

  def countLetterOccurrences(words: List[String]): Int = {
    val wordLengths = words.map(_.length)
    
    val totalLetters = wordLengths.reduce(_ + _)
    
    totalLetters
  }
}

object Main extends App {
  
  val words = List("apple", "banana", "cherry", "date")
  
  val totalLetters = WordProcessor.countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalLetters")
}
