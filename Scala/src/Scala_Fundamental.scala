
object Scala_Fundamental
{
  def main(args:Array[String]): Unit  =
  {
    //資料型態
    // Byte、Short、Int、Long、Float、Double、Boolean、Char、String
    // 0  開頭為8進位
    // 0x 開頭為十六進位整數
    // L或l結尾時 Long整數
    //println(010) <-- ~ 8, 但是現在不能使用
    println(BigInt("10",8)) //<-- 8進位
    println(0xA) // 10
    println(123l) // println(123L)
    //a float number default is Double, only end with F/f then transform to Float
    println(3.14) //<- Double
    println(3.14F) // println(3.14f) //<-- Float
    //
    println('A') // <- Char A
    println("sad") // <- String sad
    println('\u0041') // <- unicode =  Char A
    // 字元指定方式
    /*
    \\	反斜線
    \'	單引號 '
    \"	雙引號 "
    \uaaaa 以16 進位數指定Unicode字元輸出
    \b	倒退一 個字元
    \f	換頁
    \n	換行
    \r	游標移 至行首
    \t	跳格 (一個Tab鍵)
     */
    //整數、浮點數等的數值範圍
    /*
    println("Int: " + Math.MIN_INT + " ~ " + Math.MAX_INT)
    println("Long: " + Math.MIN_LONG + " ~ " + Math.MAX_LONG)
    println("Float: " + Math.MIN_FLOAT + " ~ " + Math.MAX_FLOAT)
    println("Double: " + Math.MIN_DOUBLE + " ~ " + Math.MAX_DOUBLE)
    */
    println(-13 abs)
    println( 3 max 6)
    println( 9 max 6)
    println(2.4142 round)
    //
    //算術操作 Arithmetic operation：如+、-、*、/、%
    //關係操作（Rational operation）：如>、>=、<、<=、==、!=
    //邏輯操作（Logical operation）：如&&、||、!
    //位元操作（Bitwise operation）：如&、|、~、^、>>、>>>、<<
    //指定操作：如+=、-=、*=、/=、%=、&=、|=、~=、>>=、>>>=、<<=
    // Scala中，==、!=是用來比較兩個物件內容值是否相同
    println(List(1, 2, 3) == List(1, 2, 3))
    //如果要比較兩個參考實際上是否為同一實例，可以使用eq方法或ne方法，例如以下傳回false：
    println(List(1, 2, 3) eq List(1, 2, 3))
    //位元操作如&、|、^、~，用來執行數位設計上AND、OR、XOR與補數等運算
    println("AND operation：")
    println("0 AND 0\t\t" + (0 & 0))
    println("0 AND 1\t\t" + (0 & 1))
    println("1 AND 0\t\t" + (1 & 0))
    println("1 AND 1\t\t" + (1 & 1))

    println("\nOR operation：")
    println("0 OR 0\t\t" + (0 | 0))
    println("0 OR 1\t\t" + (0 | 1))
    println("1 OR 0\t\t" + (1 | 0))
    println("1 OR 1\t\t" + (1 | 1))

    println("\nXOR operation：")
    println("0 XOR 0\t\t" + (0 ^ 0))
    println("0 XOR 1\t\t" + (0 ^ 1))
    println("1 XOR 0\t\t" + (1 ^ 0))
    println("1 XOR 1\t\t" + (1 ^ 1))
    val test_bitwise_operation: Byte = 0
    println("test_bitwise_operation\t\t"+(~test_bitwise_operation))
    val original = 'A'
    println("before encoding：" + original)   // 顯示A
    println("after encoding：" + (original ^ 0x7).toChar) // 顯示F
    //Scala還有左移（<<）與右移（>>）
    val number = 1
    println("2的1次: " +  (number << 1))
    println("2的2次: " +  (number << 2))
    println("2的3次: " +  (number << 3))
    println("2的4次: " +  (number << 4))
    /*
    +=	a += b	a = a + b
    -=	a -= b	a = a - b
    *=	a *= b	a = a * b
    /=	a /= b	a = a / b
    %=	a %= b	a = a % b
    &=	a &= b	a = a & b
    |=	a |= b	a = a | b
    ^=	a ^= b	a = a ^ b
    <<=	a <<= b	a = a << b
    >>=	a >>= b	a = a >> b
    >>>=	a >>>= b	a = a >>> b
     */

    /*
    var x = List(1, 2)
    println(0::x)
    var x = List(1, 2)
    println(x.::(0))
    var x = List(1, 2)
    println(x::3)
    */
    for(j <- 1 to 9) {
      for(i <- 1 to 9) {
        printf("%d*%d=%2d ",i, j,  i * j)
      }
      println()
    }
    //val max = (m: Int, n: Int) => if(m > n) m else n
    //你使用=>定義函式常量，在上例中，=>左邊的(m: Int, n: Int)定義了函式的參數與類型，
    // =>右邊則是函式本體，max的型態呢？實際上是(Int, Int) => Int，也就是實際上完整的宣告應該是：
    val (max: ((Int, Int) => Int)) = (m: Int, n: Int) => if(m > n) m else n
    println("max(3,6)> "+max(3,6))
    println("max(6,9)> "+max(6,9))
  }
}
