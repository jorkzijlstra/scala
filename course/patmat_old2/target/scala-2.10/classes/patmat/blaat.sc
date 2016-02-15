package patmat


object blaat {
	abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree


 	def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
 		//freqs.sortWith((f1, f2) => f1._2 < f2._2).map((f) => Leaf (f._1, f._2))
 		freqs.sortBy(_._2).map((f) => Leaf (f._1, f._2))
 	}                                         //> makeOrderedLeafList: (freqs: List[(Char, Int)])List[patmat.blaat.Leaf]
 	
 	
 	makeOrderedLeafList(List(('t', 3), ('e', 1), ('x', 2)))
                                                  //> res0: List[patmat.blaat.Leaf] = List(Leaf(e,1), Leaf(x,2), Leaf(t,3))
}