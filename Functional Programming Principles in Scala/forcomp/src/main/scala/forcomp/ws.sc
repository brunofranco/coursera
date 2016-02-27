package forcomp


object ws {

    def iter(list: List[Word], map: Map[Occurrences, List[Word]]): Map[Occurrences, List[Word]] = {
      
      if (list.isEmpty) {
        map
      } else {
      
      val word = list.head
      val occur = wordOccurrences(word)
      iter(list.tail,map.map((x) =>
        if (x.equals(occur)) {
          (x._1, x._2 :+ word)
        } else {
          x
        }
      ))
      }
    }
  
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = iter(dictionary, Map())


  dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1))
}