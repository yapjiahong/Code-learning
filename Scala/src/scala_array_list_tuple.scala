object scala_array_list_tuple
{
  def main(args:Array[String]): Unit =
  {
    //Int、Double、Boolean、String
    //在建立陣列之後，如果內含元素是整數，則預設值為0，浮點數則預設值為0.0，
    // 字元則預設值為空字元（字元編碼為0的字元），布林值預設為false，
    // 其它型態則預設值為null（與Java的陣列類似）
    // Results form scala REPL
    /*
    scala> array1: Array[Int] = Array(0, 0, 0, 0, 0)

    scala> [I@163370c2

    scala> array2: Array[Double] = Array(0.0, 0.0, 0.0, 0.0, 0.0)

    scala> [D@463fd068

    scala> array3: Array[Char] = Array(?, ?, ?, ?, ?)

    scala> [C@6e15fe2

    scala> array4: Array[Boolean] = Array(false, false, false, false, false)

    scala> [Z@13d4992d

    scala> array5: Array[String] = Array(null, null, null, null, null)

    scala> [Ljava.lang.String;@3f57bcad

    */
    val array1:Array[Int] = new Array[Int](5) //val array1 = new Array[Int](5)
    println(array1)
    val array2:Array[Double] = new Array[Double](5)
    println(array2)
    val array3:Array[Char] = new Array[Char](5)
    println(array3)
    val array4:Array[Boolean] = new Array[Boolean](5)
    println(array4)
    val array5:Array[String] = new Array[String](5)
    println(array5)
    //二維陣列
    // val array1_two_dim:Array[Array[Int]] = new Array[Array[Int]](5,5)
    // val array_two_dim = new Array[Array[Int]](5,5)
    // 不能使用，要使用ofDim
    //var array_name = Array.ofDim[ArrayType](N, M)
    //or
    //var array_name = Array(Array(elements), Array(elements)
    var array1_two_dim_int:Array[Array[Int]] = Array.ofDim[Int](5,5)
    var array1_two_dim_double:Array[Array[Double]] = Array.ofDim[Double](5,5)
    // Results from repl
    //array1_two_dim_int: Array[Array[Int]] = Array(Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0))
    //array1_two_dim_double: Array[Array[Double]] = Array(Array(0.0, 0.0, 0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0, 0.0, 0.0),
    // Array(0.0, 0.0, 0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0, 0.0, 0.0))

    //Access the array
    array1(0) = 3
    array1(1) = array1(0) + 3
    array1(2) = array1(1) + 3
    println("array[0]> "+array1(0)) // 3
    println("array[1]> "+array1(1)) // 6
    println("array[2]> "+array1(2)) // 9
    array1_two_dim_int(0)(1) = 3
    array1_two_dim_int.updated(1,array1_two_dim_int(1).update(0,6))
    println("two_dim array[0][1]>" +array1_two_dim_int(0)(1))
    println("two_dim array[1][0]>" +array1_two_dim_int.apply(1)(0))
    //println("Testing faster way to apply/update array")
    println("array1_two_dim_int[4][3]> "+array1_two_dim_int(4).apply(3)) //0
    println("array1_two_dim_int[4][3] = 0 > 13 ")
    //var u = array1_two_dim_int.updated(4*5+3,array1_two_dim_int(4*5+3)+1)
    array1_two_dim_int.updated(4,array1_two_dim_int(4).update(3,13))
    println("array1_two_dim_int[4][3]> "+array1_two_dim_int(4).apply(3)) //13
    //事實上，當你使用arr(0) = 10這樣的指定方式時，Scala會將之轉換為呼叫陣列的update()方法，
    //而用arr(0)的方式要取得指定索引的元素時，Scala會將之轉換為呼叫apply方法。以下是個簡單的驗證方式：
    println("Using Array with .update and .apply")
    array1.update(0,3)
    array1.update(1,array1.apply(0)+3)
    array1.update(2,array1.apply(1)+3)
    //array1.updated(0,1)
    println("array[0]> "+array1.apply(0)) //3
    println("array[1]> "+array1.apply(1)) //6
    println("array[2]> "+array1.apply(2)) //9
    //在Scala中，指定索引進行存取時使用()而不是[]，其實是為了語法的一致性。
    // 這種在()中指定索引進行存取的方式，並非只有陣列專屬，只要是有提供update()或apply()方法的物件，
    // 其實都可以使用這樣的存取方式
    println("String(Array)")
    val str = "Scala"
    println(str.apply(0)) // Char 'S'
    println(str(1)) // Char 'a'

    println("==========================")
    println("val arr:Array[Int] =  Array(10, 20, 30)")
    val arr:Array[Int] =  Array(10, 20, 30)
    for(i <- 0 until arr.length) {
      println(arr(i))
    }
    println("==========================")
    println("val arr2:Array[Int] = Array.apply(3,6,9)")
    val arr2:Array[Int] = Array.apply(3,6,9)
    println("for(i <- arr2) println(i)")
    for(i <- arr2) println(i) // print 3,6,9
    println("for(i <- arr2.indices) println(i) ")
    for(i <- arr2.indices) println(i) // print numbers
    println("for(i <- arr2.indices) println(arr2.apply(i))")
    for(i <- arr2.indices) println(arr2.apply(i)) // print 3,6,9
    println("for(i <- arr2.indices) println(arr2(i))")
    for(i <- arr2.indices) println(arr2(i)) // print 3,6,9
    println("==========================")
    println("""val arr = Array(10, 20, 30)""")
    val arr3 = Array(10, 20, 30)
    arr3.foreach((i:Int)=>println(i))
    println("==========================")
    println("""val arr4:Array[Int] = Array.apply(9,6,3)""")
    val arr4:Array[Int] = Array.apply(9,6,3)
    println("""arr4.foreach(i=>println(i))""")
    arr4.foreach(i=>println(i))
    println("""arr4.foreach(println)""")
    arr4.foreach(println)
    println("==========================")
    println("val arr5:Array[Int] = Array.apply(3,7,11,13,23,27,31,34,37)")
    val arr5:Array[Int] = Array.apply(3,7,11,13,23,27,31,34,37)
    println("""arr5.filter( (p:Int) => p > 15).foreach(println)""")
    arr5.filter( (p:Int) => p > 12).foreach(println)
    println("""arr5.filter( _> 15).foreach(println)""")
    arr5.filter( _> 15).foreach(println)
    println("""arr5.map((f:Int) => f*3).foreach(println)""")
    arr5.map((f:Int) => f*3).foreach(println)
    //陣列可以串接
    println("""(arr5 ++ arr4).foreach(println)""")
    (arr5 ++ arr4).foreach(println)
    //兩個陣列的內含值
    val arr6:Array[Int] = Array(9,6,3)
    println(arr4 == arr6)
    println(arr4 sameElements arr6)
    //
    //List是不可變動的（Immutable），這表示你不可以改變物件的內容或狀態，就如同 字串 一樣
    val list:List[Int] =  List.apply(3,6,9) //val list = List(10,20,30) //
    val list1_1:List[Int] =  List(3,6,9)
    println("""val list:List[Int] =  List.apply(3,6,9)""")
    println(list)
    println("""for(i <- list.indices) println(list.apply(i))""")
    for(i <- list.indices) println(list.apply(i))
    println("""val list1_1:List[Int] =  List(3,6,9)""")
    println(list1_1)
    println("""list1_1.foreach(println)""")
    list1_1.foreach(println)
    //因為list是不可變動的，所以list(0) = 20 不能使用 list.update() 也是
    list1_1.updated(1,13) // <-- 雖然可以，但會顯示為無意義的表達方式
    println("list1_1[1]> "+list1_1(1))
    //Nil是List[Nothing]的實例
    val list1 = List(3,7,11)
    val list2:List[Int] = List(11,7,3)
    val list3:List[Int] = List.apply(17,13,11)
    val list4:List[Int] = List.apply(3,7,11)
    val empty_list = List()
    val empty_list1:List[Nothing] = List()
    println(list1 == list2)  //false
    println(list2 == list3) // false
    println(list3 == list1) //false
    println(list1 == list4) //true
    println(empty_list == Nil) //true
    //要在List中附加元素，可以使用::方法，不過要注意，::是將元素附加至List的前端，
    // 由於List是不可變動的，所以傳回的是新建立的List物件
    //val new_list1 = list1::13 // 會error 因為最後要list，但是最後加個NIL就行了
    //println("new_list1> "+new_list1)
    val new_list1 = 1::list1
    println("new_list1> "+new_list1)
    val new_list2 = new_list1 :: (13 :: Nil)
    val new_list3 = 13::new_list1::Nil
    println("new_list2> "+new_list2)
    println("new_list3> "+new_list3)
    println(new_list3(1))
    //可以使用-從List中刪去指定的元素
    // 注意所有符合的元素都會被刪掉
    //( list1 -- list2 ).fo
    //
    //List中如果放置不同型態的物件，則List會全部視為 scala.Any，
    //這是Scala所有類別的最頂層父類別，每個物件的型態資訊基本上就失去了，
    //你必須自己記得放了什麼）。Tuple同樣是不可變動

    val tuple = (3,"Tesla",true,3.2)
    val tuple2:(Int,String,String) = (4,"Eddision","Thief")
    println(tuple._1)

    val (id,name) = (3,"Fake")

    /*
    val (id2,name2) = info("some data")
    println(id2)
    println(name2)
    */
  }

  def info(data:String): Unit =
  {
    val id = 3
    val name = "Fake"
    (id,name)
  }
}
