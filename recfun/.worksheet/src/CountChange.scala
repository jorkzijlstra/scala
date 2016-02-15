object CountChange {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(240); 
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(31); val res$0 = 

  countChange(4, List(1, 2));System.out.println("""res0: Int = """ + $show(res$0));$skip(55); val res$1 = 
  countChange(300, List(5, 10, 20, 50, 100, 200, 500));System.out.println("""res1: Int = """ + $show(res$1));$skip(48); val res$2 = 
  countChange(300,List(500,5,50,100,20,200,10));System.out.println("""res2: Int = """ + $show(res$2))}
}
