object simple_class {

  //class Account(acctNumber: String, acctName: String) {
  class Account(val acctNumber: String, val acctName: String) {
    val id: String = acctNumber
    val name = acctName
    //private var bal = 0
    private var bal = 0 //private var bal:Int = _

    def deposit(amount: Int) {
      require(amount > 0) // 不能存負數
      bal += amount
    }

    def withdraw(amount: Int) {
      require(amount > 0)     // 不能提負數
      if(amount <= bal) {
        bal -= amount
      }
      else {
        throw new RuntimeException("餘額不足")
      }
    }

    def balance = bal
  }

  class Resource private {
    def service(request: String) = request + "...processed..."
  }

  object Resource {
    println("Runn object Resource")
    private val resource = new Resource

    def apply() = resource
  }

  def main(args:Array[String]): Unit =
  {
    val acct = new Account("123-456-789", "Justin Lin")
    acct.deposit(1000)
    acct.withdraw(400)
    println(acct.name)
    println(acct.balance)
    val resource = Resource()
    println(resource.service("XD"))
  }
}
