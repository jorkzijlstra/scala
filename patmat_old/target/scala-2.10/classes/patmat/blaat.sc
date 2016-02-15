package patmat

object blaat {
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

  def weight(tree: CodeTree): Int = tree match {
    case Leaf(_, w) => w
    case Fork(_, _, _, w) => w
  }

  def chars(tree: CodeTree): List[Char] = tree match {
    case Leaf(c, _) => List(c)
    case Fork(_, _, c, _) => c
  }

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, (chars(left) ::: chars(right)), (weight(left) + weight(right)))

  def times(chars: List[Char]): List[(Char, Int)] = chars match {
    case Nil => Nil
    case c :: tail => (c, chars.count(_ == c)) :: times(tail.filterNot(_ == c))
  }

  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortBy(_._2).map((f) => Leaf(f._1, f._2))
  }

  def singleton(trees: List[CodeTree]): Boolean = trees match {
    case x :: Nil => true
    case _ => false
  }

  def combine(trees: List[CodeTree]): List[CodeTree] = {
    if (singleton(trees)) trees
    else {
      def forkTree = makeCodeTree(trees(0), trees(1))
      
    }
  }
 
 	 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
  	combine(leaflist)
}