package patmat


object blaat {
	abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(419); 


 	def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
 		//freqs.sortWith((f1, f2) => f1._2 < f2._2).map((f) => Leaf (f._1, f._2))
 		freqs.sortBy(_._2).map((f) => Leaf (f._1, f._2))
 	};System.out.println("""makeOrderedLeafList: (freqs: List[(Char, Int)])List[patmat.blaat.Leaf]""");$skip(64); val res$0 = 
 	
 	
 	makeOrderedLeafList(List(('t', 3), ('e', 1), ('x', 2)));System.out.println("""res0: List[patmat.blaat.Leaf] = """ + $show(res$0))}
}
