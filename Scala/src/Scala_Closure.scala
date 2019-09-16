object Scala_Closure {

  def some(): (Int => Int)=
  {
    println("top of some")
    val x = 3
    val f:(Int) => Int = (y:Int) => y*x
    f
  }

  def other(): (Int)=>Int = {
    var x = 3
    val f = x*(_:Int)
    x = 6
    f
  }

  def doOther(): (Int)=>Int = {
    var x = 10
    val f = (y:Int) => { x -= 1; x}
    f
  }

  //def doSome(x: Int) = (a: Int) => x + a
  def doSome(x:Int): Int => Int = { (a:Int) => x+a }

  def main(args:Array[String]): Unit =
  {
    val test = some()
    println(test(3))
    println(test(3+3))
    val test2 = other()
    println(test2(3))
    println(test2(3+3))
    val test3 = doOther()
    println(test3(3))
    val foo1 = doOther()
    val foo2 = doOther()
    println(foo1(6))
    println(foo2(9))
    val foo3 = doSome(3)
    val foo4 = doSome(3)
    println(foo3(6))
    println(foo3(9))
  }
}
