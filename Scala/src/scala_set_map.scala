object scala_set_map {
  def main(args:Array[String]): Unit =
  {
    //預設的Set實作是不可變動的（Immutable）
    val seta:Set[Int] = Set(3,6,9)
    //+ 可用來於集合中新增元素
    //由於預設的Set實作是不可變動的，所以實際上會建立一個新的Set物件傳回
    //-可以刪除元素中某個元素
    //++ 串接兩個Set
    //-- 刪去另一個Set 物件所指定的元素
    //** 交集操作
    //比較兩個Set物件的內含元素是否相同，可以直接使用==
    println("seta - 2> "+(seta - 2)) //Set(3, 6, 9, 11)
    println("seta - 6> "+(seta - 6)) //Set(3, 9, 11)
    val setb:Set[Int] = Set(3,7,11,13,17)
    println("seta ++ setb> "+(seta ++ setb )) //Set(6, 9, 13, 17, 7, 3, 11)
    println("seta -- setb> "+(seta -- setb)) //Set(6, 9)
    //println(seta ** setb)
    println(seta intersect(setb)) //Set(3)
    val seta_a:Set[Int] = Set(9,6,3)
    val seta_b:Set[Int] = Set(3,6,9)
    println("seta == seta_a> "+(seta == seta_a)) //true
    println("seta == seta_b> "+(seta == seta_b)) //true
    //
    //Map
    val rooms:Map[Int,String] = Map(101 -> "Morgan",102 -> "Lenny")
    println(rooms(101)) // Morgan
    //println(rooms(1001))
    //val newRooms = rooms(101) = "Arthur"
    //val newRooms = rooms.apply(101,"Arthur")
    println("rooms.foreach( f => println(f._2))")
    rooms.foreach( f => println(f._2))
    println("rooms.foreach{ case (key,value) => println(value) }")
    rooms.foreach{ case (key,value) => println(value) }
    println("rooms.foreach((f:(Int,String))=> println(\"Room: \"+f._1+\"\\tName> \"+f._2 ))")
    rooms.foreach((f:(Int,String))=> println("Room: "+f._1+"\tName> "+f._2 ))
    println("""rooms.foreach( element=> {\nal (key,value) = element\nprintln(\"Key-> \"+key+\"\\tValue-> \"+value)\n})""")
    rooms.foreach( element=> {
      val (key,value) = element
      println("Key-> "+key+"\tValue-> "+value)
    })
    println("rooms.foreach(println)")
    rooms.foreach(println)
  }
}
