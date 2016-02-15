object CountChange {
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }                                               //> countChange: (money: Int, coins: List[Int])Int

  countChange(4, List(1, 2))                      //> res0: Int = 3
  countChange(300, List(5, 10, 20, 50, 100, 200, 500))
                                                  //> res1: Int = 1022
  countChange(300,List(500,5,50,100,20,200,10))   //> res2: Int = 1022
}