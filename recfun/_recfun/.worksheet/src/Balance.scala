object Balance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(414); 
  def balance(chars: List[Char]): Boolean = {
      def check(chars: List[Char], timesOpen: Int): Boolean = {
      
        if(chars.isEmpty) timesOpen == 0
        else if (chars.head == '(') check(chars.tail, timesOpen + 1)
        else if (chars.head == ')') timesOpen > 0 && check(chars.tail, timesOpen - 1)
        else check(chars.tail, timesOpen)
      }
      
      check(chars, 0)
    };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(50); val res$0 = 
  
  balance("(if (zero? x) max (/ 1 x))".toList);System.out.println("""res0: Boolean = """ + $show(res$0))}
}
