package forcomp


object ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(424); 

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
    };System.out.println("""iter: (list: List[<error>], map: Map[<error>,List[<error>]])Map[<error>,List[<error>]]""");$skip(94); 
  
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = iter(dictionary, Map());System.out.println("""dictionaryByOccurrences  : Map[<error>,List[<error>]] = <lazy>""");$skip(67); val res$0 = 


  dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1));System.out.println("""res0: Option[List[<error>]] = """ + $show(res$0))}
}
