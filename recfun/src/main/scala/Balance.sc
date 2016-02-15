object Balance {
  def balance(chars: List[Char]): Boolean = {
      def check(chars: List[Char], timesOpen: Int): Boolean = {
      
        if(chars.isEmpty) timesOpen == 0
        else if (chars.head == '(') check(chars.tail, timesOpen + 1)
        else if (chars.head == ')') timesOpen > 0 && check(chars.tail, timesOpen - 1)
        else check(chars.tail, timesOpen)
      }
      
      check(chars, 0)
    }                                             //> balance: (chars: List[Char])Boolean
  
  balance("(if (zero? x) max (/ 1 x))".toList)    //> res0: Boolean = true
}