object scala_function_overlod {

  //val sum:(Int,Int) => Int = (a:Int,b:Int) => a+b
  //val sum:(Int,Int,Int) => Int = (a:Int,b:Int,c:Int) => a+b+c
  def sum(a:Int,b:Int):Int = {a+b}
  def sum(a:Int,b:Int,c:Int) = a+b+c
  def sum(a:Double,b:Double):Double = a+b
  //
  //重複參數
  //符號，該參數就成了可重複參數
  //def sum(numbers:Int*):Int = {numbers.sum}
  //def sum(numbers:Int*):Int = {numbers.reduce(_+_)}
  //def sum(numbers:Int*):Int = {numbers.reduceLeft( (a,b) => a+b)}
  //reduceLeft方法接受一個函式物件，
  //reduceLeft每次會將函式物件的運算結果傳入函式物件作為第一個參數值（第一次第一個參 數預設是0），
  //而陣列的下一個元素作為第二個參數的值。
  //def sum(numbers:Int*):Int = {numbers.reduceRight((a,b)=>a+b)}
  def sum(numbers: Int*): Int = (0 /: numbers) {_ + _}
  def main(args:Array[String]):Unit =
  {
    println("sum(3,6)> "+sum(3,6)) //9
    println("sum(3,6,9)> "+sum(3,6,9)) //18
    println("sum(3.33,6.66)> "+sum(3.33,6.66)) //9.99
    println("sum(3,6,9,11)> "+sum(3,6,9,11)) //29
    println("sum(3,6,9,11)> "+sum(3,6,9,11,13)) //42
  }
}
