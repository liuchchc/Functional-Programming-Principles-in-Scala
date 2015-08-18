package forcomp

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet")

  type Word = String
  type Occurrences = List[(Char, Int)]
  type Sentence = List[Word];$skip(277); 
  def wordOccurrences(w: Word): Occurrences = {
    val wordMap = w groupBy ((element: Char) => element)
    (for ((char, charList) <- wordMap) yield (char, charList.length)).toList
  };System.out.println("""wordOccurrences: (w: forcomp.Test.Word)forcomp.Test.Occurrences""");$skip(277); 

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence) = {
    def subSentence(s: Sentence): Word = s match {
      case List()  => ""
      case x :: xs => x ++ subSentence(xs)
    }

    wordOccurrences(subSentence(s))
  };System.out.println("""sentenceOccurrences: (s: forcomp.Test.Sentence)forcomp.Test.Occurrences""");$skip(58); val res$0 = 
  sentenceOccurrences(List("sdsdsd", "sdsdsd", "qwwqqw"));System.out.println("""res0: forcomp.Test.Occurrences = """ + $show(res$0));$skip(62); 
  lazy val dictionary = List("eat", "tea", "ate", "hi", "ih");System.out.println("""dictionary: => List[String]""");$skip(585); 

  def combinations(occurrences: Occurrences) = {
    def genSubOccurrences(occ: (Char, Int), crtIndex: Int): Occurrences = {
      if (crtIndex == 0) List()
      else (occ._1, crtIndex) :: genSubOccurrences(occ, crtIndex - 1)
    }

    def genAllOccurrences(subOccurrences: Occurrences): List[Occurrences] = subOccurrences match {
      case List()  => List()
      case x :: xs => genSubOccurrences(x, x._2) :: genAllOccurrences(xs)
    }

    val allOcc = genAllOccurrences(occurrences)
    for { len <- 0 until allOcc.length } yield occurrences.combinations(len).toList

  };System.out.println("""combinations: (occurrences: forcomp.Test.Occurrences)scala.collection.immutable.IndexedSeq[List[List[(Char, Int)]]]""");$skip(46); val res$1 = 
       combinations(List(('a', 2), ('b', 2)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[List[List[(Char, Int)]]] = """ + $show(res$1))}
}
