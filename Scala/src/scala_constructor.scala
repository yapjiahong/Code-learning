object scala_constructor {

  def main(args: Array[String]): Unit = {
    /*
    Learning References from
    对于var修饰的参数：外部可读/可改写 （实际上是：编译器为该类参数（字段）自动生成了getter和setter）
    对于val修饰的参数：外部可读/不可改写（实际上是：编译器为该类参数（字段）只生成了getter没有生成setter）
    对于private var修饰的参数：内部可读/可改写 （编译器不会为私有类参数（字段）自动生成getter和setter）
    对于private val修饰的参数：内部可读/不可改写 （编译器不会为该类参数（字段）自动生成getter和setter）
    ————————————————
    版权声明：本文为CSDN博主「bluishglc」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/bluishglc/article/details/50899077
    */

    val t1 = new Test1
    println(t1.getx+"\t"+t1.gety)
    println("val t3 = new Test1(3)")
    val t2 = new Test1(3)
    println("val t3 = new Test1(3,4)")
    val t3 = new Test1(3,4)
    println(t3.getx+"\t"+t3.gety)

    println("val t4 = new Test2")
    val t4 = new Test2
    println(t4.x+"\t"+t4.y)
    println(t4.description)

    println("val t5 = new Test2")
    val t5 = new Test2(3,4)
    t5.z = 20
    println(t5.description)

    println("val t4 = new Test2")
    val t4_2 = new Test2_2(3,6)
    println(t4_2.description)
    println("change the varriable")
    t4_2.x = 7
    t4_2.y = 11
    println(t4_2.description)

    val t4_3 = new Test2_2(7,11,13)
    println(t4_3.description2)
    println("change the varriable")
    t4_3.x = 3
    t4_3.y = 6
    t4_3.z = 9
    println(t4_3.description2)

    println("Testing private")
    println("val t6 = new Test6")
    val t6 = new Test3
    println(t6.description)

    // if did not using the _= (Setter)
    //then
    //t6.x = 3 // Cant set the x and y
    //t6.y = 9 // Cant set the x and y
    t6.setX(3)
    t6.setY(9)
    println(t6.description)
    t6.setX(13)
    t6.setY(17)
    println(t6.description)

    /*
    val point1 = new Point
    point1.x = 99
    point1.y = 97
    point1.x = 1
    println(point1.description)
    */

    /*
    println("Testing private")
    println("val t7 = new Test6")
    val t7 = new Test4
    println(t7.description)
    */

    println("Testing private")
    println("val t8 = new Test4_1")
    val t8 = new Test4_1
    println(t8.description)
  }

  class Test1 {
    println("Top of the method")
    private var x = 0
    private var y = 0
    println("Insisde the method")

    def this(num1: Int) {
      this()
      println("deft this(num1)")
      this.x = num1
    }
    def this(num1: Int,num2:Int) {
      this(num1)
      println("deft this(num1,num2)")
      this.y = num2
    }

    Init()
    def Init() {
      this.x = 1
      this.y = 2
    }
    println("still Insisde the method")
    //def getx = x
    def getx: Int = x
    println("betwwen x and y")
    //def gety = y
    def gety: Int = y
    println("Bottom of the method")
  }

  class Test2_2(var x:Int=0,var y:Int=0)
  {
    println("Top of the method")
    var z:Int = _ // equal to var z:Int = 0
    //private var z:Int = 0
    println("Insisde the method")

    //定义辅助构造器
    def this(x:Int,y:Int,z:Int)
    {
      //每个辅助构造器执行必须以主构造器或者其他福主构造器的调用开始
      this(x,y)//调用主构造器
      println("执行辅助构造器")
      this.z = z
    }

    //def description = "x> " + x + "\ty> " + y
    def description: String = "x> " + x + "\ty> " + y
    def description2: String = "x> " + x + "\ty> " + y + "\tz>" + z
    println("Bottom the method")
  }

  class Test2(var x:Int=0,var y:Int=0)
  {
    println("Top of the method")
    var z:Int = _ // equal to var z:Int = 0
    println("Insisde the method")
    //def description = "x> " + x + "\ty> " + y
    def description: String = "x> " + x + "\ty> " + y + "\tz>" + z
    println("Bottom the method")
  }

  class Test3
  {
    println("Top of the method")

    private var _ax = 0
    private var _ay = 0
    //Getter
    def getx: Int = _ax
    def gety: Int = _ay
    println("Insisde the method")
    //Setter
    def setX(newValue:Int):Unit = { _ax = newValue}
    def setY(newValue:Int):Unit = { _ay = newValue}

    def ax_= (newValue:Int): Unit = _ax = newValue
    def ay_= (newValue:Int): Unit = _ay = newValue

    def description = "X> "+_ax+"\ty> "+_ay //def description2:String = "X> "+x+"\ty> "+y
    println("Bottom the method")
  }


  class Test4 private( var x:Int=0, var y:Int=0) //private修饰后，主构造器将不能被调用
  {
    println("Top of the method")
    println("Insisde the method")
    def description = "X> "+x+"\ty> "+y //def description2:String = "X> "+x+"\ty> "+y
    println("Bottom the method")
  }

  class Test4_1 (private var x:Int=0,private var y:Int=0)
  {
    println("Top of the method")
    println("Insisde the method")
    def description = "X> "+x+"\ty> "+y //def description2:String = "X> "+x+"\ty> "+y
    println("Bottom the method")
  }

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }
  def description: String = "x> " + x + "\ty> " + y
  private def printWarning = println("WARNING: Out of bounds")
}
}
