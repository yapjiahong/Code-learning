object scala_lambda_function
{

  val plus = (_:Int) + (_:Int) // function
  val sum:(Int,Int) => Int = _ + _

  // method
  def times(num1:Int,num2:Int):Int =
  {
    num1*num2
  }
  // method

  def minus = (_:Int) - (_:Int) // def minus: (Int, Int) => Int = (_:Int) - (_:Int)

  //def counterResult(num1:Int,num2:Int,counter:(Int,Int)=> Int): Unit = {
  def counterResult(num1:Int,num2:Int,counter:(Int,Int)=> Int) = {
    println(counter(num1,num2))
  }

  def main(args:Array[String]): Unit =
  {
    counterResult(6,6,plus) //12
    counterResult(6,4,minus) //2
    counterResult(3,2,times) // 6
  }
}
