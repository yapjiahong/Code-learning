object scala_string {
  def main(args:Array[String]): Unit =
  {
    val str1 = "Scala"
    val str2 = new String(Array('S', 'c', 'a', 'l', 'a'))
    println(str1) // 顯示 Scala
    println(str2) // 顯示 Scala
    //字串是不可變動的（Immutable），在建立之後就不能改變它的值
    /*
    char charAt(int index)	傳回指定索引處的字元
    int indexOf(int ch)	傳回指定字元第一個找到的索引位置
    int indexOf(String str)	傳回指定字串第一個找到的索引位置
    int lastIndexOf(int ch)	傳回指定字元最後一個找到的索引位置
    String substring(int beginIndex)	取出指定索引處至字串尾端的子字串
    String substring(int beginIndex, int endIndex)	取出指定索引範圍子字串
    char[] toCharArray()	將字串轉換為字元陣列
    */
    for(c <- "Scala") {
      println(c) // 每行顯示一個字元
    }
    val str = "Scala"
    println(str(0)) // 顯示 'S'
    println(str(1)) // 顯示 'c'
    println(str(2)) // 顯示 'a'
    println(str(3)) // 顯示 'l'
    println(str(4)) // 顯示 'a'
    val s2 = "This is \"Scala\"!"
    println(s2) // 顯示 This is "Scala" !
    val str3 = """This is "Scala"!"""
    println(str3) // 顯示 This is "Scala" !
    val re = "\\d\\d\\d"
    println(re)
    println("123-134".replaceAll(re, "###")) // 顯示 ###-###
    val re2 = """\d\d\d"""
    println("123-134".replaceAll(re2, "###")) // 顯示 ###-###
    //Scala中基本上也沒有必要直接呼叫 equals方法，而可以直接使用==取代
    val str_cmp1 = "Scala"
    val str_cmp2 = "Scala"
    val str_cmp3 = new String(str1)
    println(str_cmp1 == str_cmp2)       // 顯示 true
    println(str_cmp1 == str_cmp3)       // 顯示 true
    println(str_cmp1.equals(str_cmp3))  // 顯示 true
    //真的要比較兩個物件參考是否相同，可以使用eq或ne方法
    println(str1 eq str2)         // 顯示 true
    println(str1 ne str3)         // 顯示 true
  }
}
