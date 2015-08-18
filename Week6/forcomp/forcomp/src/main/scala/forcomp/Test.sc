package forcomp

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  type Word = String
  type Occurrences = List[(Char, Int)]
  type Sentence = List[Word]
  def wordOccurrences(w: Word): Occurrences = {
    val wordMap = w groupBy ((element: Char) => element)
    (for ((char, charList) <- wordMap) yield (char, charList.length)).toList
  }                                               //> wordOccurrences: (w: forcomp.Test.Word)forcomp.Test.Occurrences

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence) = {
    def subSentence(s: Sentence): Word = s match {
      case List()  => ""
      case x :: xs => x ++ subSentence(xs)
    }

    wordOccurrences(subSentence(s))
  }                                               //> sentenceOccurrences: (s: forcomp.Test.Sentence)forcomp.Test.Occurrences
  sentenceOccurrences(List("sdsdsd", "sdsdsd", "qwwqqw"))
                                                  //> res0: forcomp.Test.Occurrences = List((w,3), (q,3), (s,6), (d,6))
  lazy val dictionary = List("eat", "tea", "ate", "hi", "ih")
                                                  //> dictionary: => List[String]

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

  }                                               //> combinations: (occurrences: forcomp.Test.Occurrences)scala.collection.immut
                                                  //| able.IndexedSeq[List[List[(Char, Int)]]]
       combinations(List(('a', 2), ('b', 2)))     //> res1: scala.collection.immutable.IndexedSeq[List[List[(Char, Int)]]] = Vect
                                                  //| or(List(List()), List(List((a,2)), List((b,2))))
}