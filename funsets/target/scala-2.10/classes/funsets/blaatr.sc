package funsets

object blaatr {
	import funsets._

  val bound = 1000

	test = new FunSets(1,true)

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !contains(p, a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }
}