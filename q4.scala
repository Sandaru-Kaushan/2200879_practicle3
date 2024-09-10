// Creat a class for Account with an id and balance
case class Account(id: Int, balance: Double)


object Bank {
  //get negative balances balance accounts
  def negativeBalanceAccounts(accounts: List[Account]): List[Account] = {
    accounts.filter(account => account.balance < 0)
  }

  //calculate the sum of all account balances
  def totalBalance(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  //calculate the final balances after applying interest
  def applyInterest(accounts: List[Account]): List[Account] = {
    accounts.map { account =>
      val interestRate = if (account.balance > 0) 0.05 else 0.1
      val newBalance = account.balance + (account.balance * interestRate)
      account.copy(balance = newBalance)
    }
  }
}

object Main extends App {

  val accounts = List(
    Account(1, 1000.0),  
    Account(2, -500.0),  
    Account(3, 200.0),   
    Account(4, -100.0)  
  )

  val negativeAccounts = Bank.negativeBalanceAccounts(accounts)
  println("Accounts with negative balances: " + negativeAccounts)

  val total = Bank.totalBalance(accounts)
  println("Total balance of all accounts: " + total)

  val accountsWithInterest = Bank.applyInterest(accounts)
  println("Final balances after applying interest: " + accountsWithInterest)
}
