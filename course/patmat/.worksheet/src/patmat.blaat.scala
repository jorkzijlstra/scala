package patmat

object blaat {
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(328); 

  def weight(tree: CodeTree): Int = tree match {
    case Leaf(_, w) => w
    case Fork(_, _, _, w) => w
  };System.out.println("""weight: (tree: patmat.blaat.CodeTree)Int""");$skip(123); 

  def chars(tree: CodeTree): List[Char] = tree match {
    case Leaf(c, _) => List(c)
    case Fork(_, _, c, _) => c
  };System.out.println("""chars: (tree: patmat.blaat.CodeTree)List[Char]""");$skip(142); 

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, (chars(left) ::: chars(right)), (weight(left) + weight(right)));System.out.println("""makeCodeTree: (left: patmat.blaat.CodeTree, right: patmat.blaat.CodeTree)patmat.blaat.Fork""");$skip(172); 

  def times(chars: List[Char]): List[(Char, Int)] = chars match {
    case Nil => Nil
    case c :: tail => (c, chars.count(_ == c)) :: times(tail.filterNot(_ == c))
  };System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(126); 

  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortBy(_._2).map((f) => Leaf(f._1, f._2))
  };System.out.println("""makeOrderedLeafList: (freqs: List[(Char, Int)])List[patmat.blaat.Leaf]""");$skip(119); 

  def singleton(trees: List[CodeTree]): Boolean = trees match {
    case left :: Nil => true
    case _ => false
  };System.out.println("""singleton: (trees: List[patmat.blaat.CodeTree])Boolean""");$skip(683); 
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
  };System.out.println("""combine: (trees: List[patmat.blaat.CodeTree])List[patmat.blaat.CodeTree]""");$skip(179); 
  
  // (new Fork(l, r, chars(l) ::: chars(r), weight(l) + weight(r)) :: ts_).sortWith(weight(_) < weight(_))
 
 
 	 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""leaflist  : List[patmat.blaat.Leaf] = """ + $show(leaflist ));$skip(21); val res$0 = 
  	combine(leaflist);System.out.println("""res0: List[patmat.blaat.CodeTree] = """ + $show(res$0))}
}
