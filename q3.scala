class Account(val accountNumber: String, private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. Current balance: $$${balance}")
    } else {
      println("Deposit amount must be positive")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. Current balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient balance")
    } else {
      println("Withdraw amount must be positive")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      withdraw(amount)  
      toAccount.deposit(amount)  
      println(s"Transferred $$${amount} from account ${accountNumber} to account ${toAccount.accountNumber}")
    } else if (amount > balance) {
      println("Insufficient balance to transfer")
    } else {
      println("Transfer amount must be positive")
    }
  }

  def getBalance: Double = balance
}

object BankApp {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("123456", 1000.0)
    val account2 = new Account("654321", 500.0)

    account1.deposit(200)
    account1.withdraw(150)
    account1.transfer(300, account2)

    println(s"Final balance of account1: $$${account1.getBalance}")
    println(s"Final balance of account2: $$${account2.getBalance}")
  }
}
