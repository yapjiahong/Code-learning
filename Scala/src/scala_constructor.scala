object scala_constructor {

  def main(args: Array[String]): Unit = {

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

  class Test2(var x:Int=0,var y:Int=0)
  {
    println("Top of the method")
    var z:Int = _ // equal to var z:Int = 0
    println("Insisde the method")
    //def description = "x> " + x + "\ty> " + y
    def description: String = "x> " + x + "\ty> " + y + "\tz>" + z
    println("Bottom the method")
  }

}
