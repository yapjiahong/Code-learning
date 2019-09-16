object scala_HanoiTower {
  //a:from b:inter c:to
  def move(x:Int,a:Char,b:Char,c:Char):Unit=
  {
    if(x==1)
      println("from> "+a+" move the plate "+x+ " to the "+c)
    else
    {
      move(x-1,a,c,b)
      println("from> "+a+" move the plate "+x+ " to the "+c)
      move(x-1,b,a,c)
    }
  }

  def main(args:Array[String]):Unit =
  {
    move(6,'A','B','C')
  }
}
