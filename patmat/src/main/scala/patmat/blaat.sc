package patmat

object blaat {
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

  def weight(tree: CodeTree): Int = tree match {
    case Leaf(_, w) => w
    case Fork(_, _, _, w) => w
  }                                               //> weight: (tree: patmat.blaat.CodeTree)Int

  def chars(tree: CodeTree): List[Char] = tree match {
    case Leaf(c, _) => List(c)
    case Fork(_, _, c, _) => c
  }                                               //> chars: (tree: patmat.blaat.CodeTree)List[Char]

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, (chars(left) ::: chars(right)), (weight(left) + weight(right)))
                                                  //> makeCodeTree: (left: patmat.blaat.CodeTree, right: patmat.blaat.CodeTree)pat
                                                  //| mat.blaat.Fork

  def times(chars: List[Char]): List[(Char, Int)] = chars match {
    case Nil => Nil
    case c :: tail => (c, chars.count(_ == c)) :: times(tail.filterNot(_ == c))
  }                                               //> times: (chars: List[Char])List[(Char, Int)]

  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortBy(_._2).map((f) => Leaf(f._1, f._2))
  }                                               //> makeOrderedLeafList: (freqs: List[(Char, Int)])List[patmat.blaat.Leaf]

  def singleton(trees: List[CodeTree]): Boolean = trees match {
    case left :: Nil => true
    case _ => false
  }                                               //> singleton: (trees: List[patmat.blaat.CodeTree])Boolean
 /**
   * The parameter `trees` of this function is a list of code trees ordered
   * by ascending weights.
   *
   * This function takes the first two elements of the list `trees` and combines
   * them into a single `Fork` node. This node is then added back into the
   * remaining elements of `trees` at a position such that the ordering by weights
   * is preserved.
   *
   * If `trees` is a list of less than two elements, that list should be returned
   * unchanged.
   */
  def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
  	case t1 :: t2 :: tc => {
  	print(tc)
  		(makeCodeTree(t1, t2) :: tc).sortWith(weight(_) < weight(_))
  	}
  	case _ => trees
  }                                               //> combine: (trees: List[patmat.blaat.CodeTree])List[patmat.blaat.CodeTree]
  
  // (new Fork(l, r, chars(l) ::: chars(r), weight(l) + weight(r)) :: ts_).sortWith(weight(_) < weight(_))
 
 
 	 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> leaflist  : List[patmat.blaat.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4))
                                                  //| 
  	combine(leaflist)                         //> List(Leaf(x,4))res0: List[patmat.blaat.CodeTree] = List(Fork(Leaf(e,1),Leaf
                                                  //| (t,2),List(e, t),3), Leaf(x,4))
}