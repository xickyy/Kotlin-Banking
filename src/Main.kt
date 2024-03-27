//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("******************************************")
    println("Welcome to Ricks Dollas!")
    println("Please select the type of account you would like to create.")
    println("--------------------")
    println("1. Debit Account")
    println("2. Credit Account")
    println("3. Checking account")
    println("--------------------")
    println("Tip: You can make your selection by typing in the number and pressing enter.")

    var accountType: String = ""
    var userChoice: Int? = readLine()?.toIntOrNull()

    when (userChoice) {
        1 -> {accountType = "debit"}
        2 -> {accountType = "credit"}
        3 -> {accountType = "checking"}
    }

    println("Congratulations on starting your new $accountType account!")

    var accountBalance: Int = -1000
//    val money:Int? = readLine()?.toIntOrNull()

    println("you currently have $accountBalance in your account")

    //withdraw method for checking and credit accounts
    fun withdraw(amount: Int): Int {
        accountBalance -= amount
        var message: String = "You have taken $amount out of your account and now have $accountBalance left"
        println(message)
        return amount

    }

    //withdraw method for debit accounts
    fun debitWithdraw(): Int {
        println("How much would you like to withdraw?")
        val amount:Int? = readLine()?.toIntOrNull()

        if (amount == null) {
            println("Invalid input")
            return accountBalance
        }

        if(accountBalance == 0) {
            println("You ain't got no moneyyy")
            return accountBalance
        } else {
            if(amount > accountBalance) {
                println("Insufficient funds my brotha")
                return 0
            } else {
                return withdraw(amount)
            }
        }
        return accountBalance
    }

//    debitWithdraw()

    //deposit method for checking and debit accounts
    fun deposit(amount: Int): Int {
        println("how much would you like to deposit?")
        var amount: Int? = readLine()?.toIntOrNull()

        if (amount == null) {
            println("Invalid input")
            return accountBalance
        }

        accountBalance += amount
        println("you have successfully deposited $amount into your account and now have $accountBalance")
        return amount
    }

//    deposit()

    //method for depositing into a credit account
    fun creditDeposit(amount: Int): Int {
        if(accountBalance == 0) {
            println("you dont owe us anthing")
            return accountBalance
        } else {
            if(accountBalance + amount > 0) {
                println("deposit failed, you dont owe us that much silly!")
            } else {
                if(amount == -accountBalance) {
                    accountBalance = 0
                    println("awesome! you payed off your balance and dont owe us anything!")
                    return amount
                } else {
                    deposit(amount)
                }
            }
        }

        return amount
    }

    creditDeposit(10)

}



