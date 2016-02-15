package funsets

object blaatr {
	import funsets._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 

  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(29); val res$0 = 

	test = new FunSets(1,true);System.out.println("""res0: <error> = """ + $show(res$0));$skip(298); 

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
  };System.out.println("""forall: (s: <error>, p: Int => Boolean)Boolean""")}
}
