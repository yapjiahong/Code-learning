object scala_function_method {

  // method
  //def method1(x:Int,y:Int): Int = x*y
  def method1(x:Int,y:Int): Int =
  {
    println("method1")
    x*y
  }

  // function
  println("function block")
  val function_times = (x:Int,y:Int) => x*y
  val functin_times1: (Int, Int) => Int = (x:Int, y:Int) => x*y
  val functipm_times2 = (_:Int)*(_:Int)
  val function_times3: (Int, Int) => Int = (_:Int)*(_:Int) ; println("function_times3")
  val function_plus:(Int,Int) => Int = _ + _ ; println("function plus")
  val function_divided:(Int,Int) => Int = (_:Int)/(_:Int)
  val function_minus:(Int,Int) => Int = (_:Int) - (_:Int)

  //for method m1
  //定义一个方法
  //方法 m1 参数要求是一个函数，函数的参数必须是两个Int类型
  //返回值类型也是Int类型
  def m1(f:(Int,Int) => Int):Int=
  {
    f(6,2)
  }
  //

  def Result(num1:Int,num2:Int,function:(Int,Int)=>Int):Int =
  {
    println("Result start")
    val temp_ans = function(num1,num2)
    println("Result end")
    temp_ans
  }

  val function_println_sayHello1: (String) => Unit = (prefix:String) => println(prefix+", scala")
  def printsomething1(prefix:String,printFunction:(String)=>Unit): Unit =
  {
    printFunction(prefix)
  }


  val function_println_sayHello2: () => Unit = () => println("Hello, scala")
  def printsomething2(printFunction:()=>Unit): Unit = {
    printFunction()
  }

  val f: Int => Int = (x: Int) =>  x + 3//val f = (x: Int) =>  x + 3
  val max = (m: Int, n: Int) => if(m > n) m else n //val max2:(Int,Int) => Int = (m: Int, n: Int) => if(m > n) m else n
  val f1:(Int) => Int = (x:Int) => x+3
  def m2 = 100

  def m3() = 1000
  var f2: () => Int = () => 100 //var f2 =() => 100

  val function_3 = { (x:Int,y:Int) =>
     x % y
  }
  //function_3`s functionality same as function_4
  val function_4: (Int, Int) => Int = { (x:Int, y:Int) =>
    x % y
  }

  def main(args:Array[String]): Unit =
  {
    //println("Test.")
    //val test1 = m1(function_times(7,11)) //*Error


    val test1 = m1(function_times3)
    println(test1)

    val test2 = m1(function_divided)
    println(test2)


    val result_plus = Result(3,6,function_plus)
    println(result_plus)

    function_println_sayHello1("NO!")
    println(function_divided(8,2))
    printsomething1("zzzz",function_println_sayHello1)
    println("Test Mehotd(Function) 2")
    printsomething2(function_println_sayHello2)

    println(f(3))
    println(f1(6))


    println(m2)
    println(m3()) //same with --> println(m3)
    println(f2)
    println(f2())

    def m4(x:Int): Int = x * x * x
    val f3 = m4 _ // m4(method) transform to function
    println(f3(3))

    println("function_3(9,3)> "+function_3(4+5,2+1)) //0
    println("function_4(9,3)> "+function_4(4+5,2+1)) // 0
    //println(m4(3))

    /* Expectation Result
      function block
      function_times3
      function plus
      12
      3
      result start
      result end
      9
      NO!, scala
      4
      zzzz, scala
      Test Mehotd(Function) 2
      Hello, scala
      6
      9
      100
      1000
      <function0>
      100
      27
    */
  }

}
