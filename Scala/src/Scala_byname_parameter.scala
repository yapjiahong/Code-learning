

object Scala_byname_parameter {

  //call by value
  //def sum(a: Int, b: Int) = a + b
  def sum(a: Int, b: Int): Int = a + b

  // call by name
  def unless(cond:Boolean,func:()=>Any):Unit =
  {
    if(!cond)
      {
        func()
      }
    else
      {
        func2()
      }
  }

  val func2:()=>Unit = () => println("LoL...")

  //如果想要省略()=>的撰寫，則可以這麼宣告
  // call by name
  def unless2(cond:Boolean, f: => Any): Unit =
  {
    if(!cond)
    {
      f
    }
  }
  //expr的型態是=>Any，稱之為以名呼叫參數（By-name parameter），
  // 注意到在呼叫unless函式時，直接寫下了println("XD")這樣的運算式，省略了()=>的撰寫。事實上，
  // 省略()=>並不是這個範例的重點，重點是在於println("XD")不會被馬上執行，
  // 真正的執行是在cond為false，也就是unless中if結果為true時。

  def unless3(cond:Boolean,x:Int,f:()=> Int):Unit =
  {
    if(cond)
      println(f()*x)
  }

  def unless4(cond:Boolean,prefix:String,f: => Int):Unit =
  {
    if(cond)
      println(prefix+f)
  }

  def unless5(cond:Boolean,x:Int, prefix:String, f:Int=>Int):Unit =
  {
    if(cond & x%3==0)
      println(prefix+f(x))
    else
      println(prefix+" not the %3 therefore "+f(x*3))
  }

  def something(): Int =
  {
    println("calling something")
    1
  }

  def callByValue(x:Int):Unit =
  {

    println("callByValue\nx1= "+x)
    println("x2= "+x)
  }

  def callByName(x: => Int):Unit =
  {
    println("callByName\n1= "+x)
    println("x2= "+x)
  }

  val max_function: (Int,Int) => Int = (a:Int,b:Int) => if(a>b) a else b
  def method_find_max_function(a:Int,b:Int,f:(Int,Int)=>Int) =  if(a>0 & b>0 )f(a,b) else println("Compare GG?")
  //def method_find_max_function2(a:Int,b:Int,f(Int,Int): => Int) =  if(a>0 & b>0 )f(a,b) else println("Compare GG?")
  //def method_find_max_function2(a:Int,b:Int,f:(Int,Int)=>Int) =  if(a>0 & b>0 ) f(a,b) else 0

  def cal(input: => Int ) = input*37
  //def cal(input: Int => Int ) =

  def main(args:Array[String]): Unit =
  {

    //call by value
    println(sum(1 + 2, 3 + 4))

    //這個函式的作用是，除非cond條件成立（也就是true），
    // 否則就執行所傳入的函式物件（也就是if的相反）。
    // 所傳入的函式物件，並沒有定義參數，不過() =>仍不能省略，也就是你不可以寫成：
    //unless(false, println("XD"))

    unless(cond = false, ()=>println("xD"))
    unless(true, ()=>println("Orz"))

    //如果想要省略()=>的撰寫，則可以這麼宣告
    unless2(false,println("xD"))
    unless2(cond = true,println("Orz"))

    //Cuury
    val b: (Int) => (Int) => Int = (x: Int) => (y: Int) => x + y
    //b: Int => (Int => Int) = <function1>
    //val b = (x: Int) => (y: Int) => x + y;
    //function literal
    def b2(x:Int)(y:Int): Int = x+y
    println(b(3)(6))
    println(b2(3)(6))
    println("***************************")
    println("unless3> ")
    unless3(true,3, ()=>3*3)
    //unless4(true,3,"unless4> ", 9)
    unless5(true,3,"Unless5>",(x:Int)=> x*3)
    unless5(true,5,"Unless5>",(x:Int)=> x*3)

    callByValue(something())
    println("")
    callByName(something())

    println("find max")
    println(method_find_max_function(3,6,max_function))
    println(method_find_max_function(6,3,max_function))
    println(method_find_max_function(6,-3,max_function))

    println("cal> "+cal(3))
  }
}
