object Hello {

  def hellwolrd1(){
    println("Hello World")
  }

  def hellwolrd2()={
    println("Hello World2")
  }

  def hellwolrd3():Unit ={
    println("Hello World3")
  }

  def printOneLine(line:String = "Default line"): Unit =
  {
    println(line)
  }

  def printTwoLine(line: String, line2:String): Unit =
  {
    println(line)
    println(line2)
  }

  def add1(x:Int, y:Int) = x + y
  def add2(x:Int, y:Int): Int = {x+y}

  def sum(n:Int):Int =
  {
    def sumImpl(n :Int, acc:Int): Int =
    {
      if (n==0)
        acc
      else
        sumImpl(n-1,acc+n)
    }
    sumImpl(n,0)
  }
  /*
  wrong pattern match
  def selected(selection: Int):= Unit
  {
    selection match
    {
      case 1 => println("seleted 1")
      case 2 => println("seleted 2")
      case _ => println("other")
    }
  }
  */
  def selected(selection: Int): Unit = selection match
  {
    case 1 => println("seleted 1")
    case 2 => println("seleted 2")
    case _ => println("other")
  }

  /*
  def pattern_match(pattern:Any): String = pattern match
  {
    case i:Int => "integer"
    case _:Double => "Double"
    case s:String => "String"
    case c:Char => "Char"
    case boolen:Boolean => "Boolean"
  }*/
  def pattern_match(pattern:Any): String =
  {
    pattern match {
      case i: Int => "integer"
      case _: Double => "Double"
      case s: String => "String"
      case c: Char => "Char"
      case boolen: Boolean => "Boolean"
    }
  }
  class ClassA
  {
    val x:Int = 10
    println("Init class a frist print")
    def Hello():Unit =
    {
      println("Hello, Test")
    }
    println("Init class b second print")
  }

  class Person(var userID:Int, var userName:String)
  /*
  class Person2
  {
    val mName:String = ""
    val mAge:Int = 0

    def name():String = this.mName()
    def age (): Int = this.mAge
  }
  */

  case class Person2(name: String, age: Int)
  def PersonCheck(person:Person2)
  {
    person match
    {
      case Person2("Joe",15) => "Name-> Joe Age-> 15"
      case Person2("Joe",age) => s"Name-> Joe Age-> $age"
      case Person2(name,age) if age >=20 => s"name-> $name Age-> $age"
      case _ => "Orthers"
    }
  }

  def printOptionBox(box:Option[Int]): Unit =
  {
    if(box.isDefined)
      println("box non-empty> "+box.get )
    else if(box.isEmpty)
      println("box is empty")
  }

  def printOptionBoxWithMatch(box:Option[Int]): Unit =
  {
    box match
    {
      case Some(value) => println("Box with int> "+value)
      case None => println("empty box")
    }
  }

  def scoreToLevel(score:Int): String =
  {
    score match
    {
      case scoreA if scoreA >= 90 && scoreA <= 100 =>
        "A"
      case scoreB if scoreB >= 80 && scoreB <= 89 =>
        "B"
      case scoreC if scoreC >= 70 && scoreC <= 79 =>
        "C"
      case scoreF if scoreF <= 69 && scoreF >= 0 =>
        "Failed"
      case _  =>
        "score Error"
    }
  }

  def isOdd(odd:Int): Boolean = odd %2 == 0
  def matchOdd(x:Any):Unit =
  {
    x match
    {
      case myInt:Int =>
        if(isOdd(myInt)) println(s" $myInt is odd") else println(s" $myInt not odd")

    }
  }

  def matchOdd2(x:Any):Unit =
  {
    x match
    {
      case myInt:Int if isOdd(myInt) => println(s" $myInt is odd")
      case myInt:Int if !isOdd(myInt) => println(s" $myInt not odd")
    }
  }
  def main(args: Array[String]):Unit=
  {
    val test:Int = 0
    val test2 = 0
    hellwolrd1()
    hellwolrd2()
    hellwolrd3()

    printOneLine("Test.")
    printOneLine()

    printTwoLine("Line1", "Line2")
    printTwoLine(line2 = "second line", line="1st line")

    println(add1(3,2))
    println(add2(3,2))

    def addThenMultiplyDiv(x: Int, y: Int)(multiplier: Int)(div: Int): Double = {
      ((x + y) * multiplier) / div
    }
    // == def addThenMultiplyDiv(x: Int, y: Int)(multiplier: Int)(div: Int): Double = ((x + y) * multiplier) / div
    println("addThenMultiplyDiv> "+addThenMultiplyDiv(2, 2)(3)(2)) // 9

    //val scores = List(93, 45, 95, 63, 58, 60, 73)

    val scores:List[Int] =  List(93,45,95,63,58,60,73)
    //scores.foreach((x: Int) => println(x))
    scores.foreach((x:Int)=>println(x))

    val objA = new ClassA
    objA.Hello()

    val person = new Person(102,"John")
    println(person.userID)

    val boxwithInt: Option[Int] = Some(3)

    print("boxwithInt()> ")
    println(boxwithInt)
    print("boxwithInt.get> ")
    println(boxwithInt.get)

    //print("boxwithInt(5)> ")
    //println(boxwithInt(5))

    //printOptionBox() <-- Error!
    printOptionBox(None)
    printOptionBox(Some(5))

    val boxwithint:Option[Int] = Some(3)
    val emptybox:Option[Int] = None
    println("boxwithInt(0)*3> "+boxwithInt.getOrElse(0)*3)
    println("boxwithInt(1)*3> "+boxwithInt.getOrElse(1)*3)
    //println("emptybox().get> "+emptybox.get) <-- Error
    println("emptybox(1)> "+emptybox.getOrElse(1))
    println("emptybox(0)*3> "+emptybox.getOrElse(0)*3)
    println("emptybox(1)*3> "+emptybox.getOrElse(1)*3)

    /*
    if(emptybox.getOrElse(1) == None)
      println("non-emptybox")
    else
      println("emptybox")
      */

    selected(23)

    println(pattern_match(false))
    println("score level")
    println(scoreToLevel(40))
    println(scoreToLevel(91))
    println(scoreToLevel(70))
    println(scoreToLevel(140))
    println(scoreToLevel(-40))
    println(scoreToLevel(0))
    //println(scoreToLevel(a))
    matchOdd(16)
    matchOdd(17)
    matchOdd2(24)
    matchOdd2(23)

    println("option[T] with Match")
    //println(printOptionBoxWithMatch(Some(13)))
    //println(printOptionBoxWithMatch(None))
    printOptionBoxWithMatch(Some(13))
    printOptionBoxWithMatch(None)
    /*
    var ali:Person2 = Person2("Joe",15)
    PersonCheck(ali)
    */
    println(PersonCheck(new Person2("Joe", 15)))
  }

}