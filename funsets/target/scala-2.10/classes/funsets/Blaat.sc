package funsets

object Blaat {
  import common._

	object TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * 2. Purely Functional Sets.
   */
  object FunSets {
    /**
     * We represent a set by its characteristic function, i.e.
     * its `contains` predicate.
     */
    type Set = Int => Boolean

    /**
     * Indicates whether a set contains a given element.
     */
    def contains(s: Set, elem: Int): Boolean = s(elem)

    /**
     * Returns the set of the one given element.
     */
    def singletonSet(elem: Int): Set = Set(elem)

    /**
     * Returns the union of the two given sets,
     * the sets of all elements that are in either `s` or `t`.
     */
    def union(s: Set, t: Set): Set = ((x: Int) => s(x) || t(x))

  }
  
  new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  
  new FunSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }

}