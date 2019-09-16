object scala_first_class_function {

  //function or Method
  def max(a:Int,b:Int):Int = if(a>b)a else b

  //函式常量（Function literal）
  //val max_function_literal = (a:Int,b:Int) => if (a>b) a else b
  val max_function_literal:((Int,Int) => Int) = {(a: Int, b: Int) => if (a > b) a else b}
  val max_function2: (Int, Int) => Int = (m: Int, n: Int) => {
    if(m > n)
      m
    else n
  }
  def selection(number: Array[Int], order: (Int, Int) => Boolean) {
    def mm(m: Int, j: Int): Int = {
      if(j == number.length) m
      else if(order(number(j), number(m))) mm(j, j + 1)
      else mm(m, j + 1)
    }
    /*
    for(i <- 0 until number.length -1; m = mm(i, i + 1) if i != m)
      swap(number, i, m)*/
    for(i <- 0 until number.length -1) {
      var m = mm(i, i + 1)
      if (i != m)
       swap(number, i, m)
    }
  }

  def swap(number: Array[Int], i: Int, j: Int) {
    val t = number(i)
    number(i) = number(j)
    number(j) = t
  }

  def o_order:(Int,Int)=>Boolean = (a:Int,b:Int) => a<b
  def un_order= (a:Int,b:Int) => a>b

  def main(args:Array[String]):Unit =
  {
    val arr1 = Array(2, 5, 1, 7, 8)
    val t = Array(3, 6, 9, 7, 11, 17, 23, 12, 15, 18)
    //selection(t, (a: Int, b: Int) => a < b)
    selection(t, o_order)
    selection(arr1, (a: Int, b: Int) => a < b)
    println(arr1.mkString(","))
    println(t.mkString(","))
    selection(t, (a: Int, b: Int) => a > b)
    selection(arr1, un_order)
    //selection(arr1, (a: Int, b: Int) => a > b)
    println(arr1.mkString(","))
    println(t.mkString(","))
    selection(t, (_:Int) < (_:Int) )
    //println(t.foreach(println))
    println(t.mkString(","))
    selection(t, _ > _ )
    println(t.mkString(","))
    val f = (_: Int) + (_: Int)
    println(f(3,6))
  }
}
