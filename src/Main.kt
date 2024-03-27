////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//fun main() {
//
//    println("******************************************")
//    println("Welcome to Ricks Dollas!")
//    println("Please select the type of account you would like to create.")
//    println("--------------------")
//    println("1. Debit Account")
//    println("2. Credit Account")
//    println("3. Checking account")
//    println("--------------------")
//    println("Tip: You can make your selection by typing in the number and pressing enter.")
//
//    var accountType: String = ""
//    var userChoice: Int? = readLine()?.toIntOrNull()
//
//    when (userChoice) {
//        1 -> {accountType = "debit"}
//        2 -> {accountType = "credit"}
//        3 -> {accountType = "checking"}
//    }
//
//    println("Congratulations on starting your new $accountType account!")
//
//    var accountBalance: Int = -1000
////    val money:Int? = readLine()?.toIntOrNull()
//
//    println("you currently have $accountBalance in your account")
//
//    //withdraw method for checking and credit accounts
//    fun withdraw(amount: Int): Int {
//        accountBalance -= amount
//        var message: String = "You have taken $amount out of your account and now have $accountBalance left"
//        println(message)
//        return amount
//
//    }
//
//    //withdraw method for debit accounts
//    fun debitWithdraw(): Int {
//        println("How much would you like to withdraw?")
//        val amount:Int? = readLine()?.toIntOrNull()
//
//        if (amount == null) {
//            println("Invalid input")
//            return accountBalance
//        }
//
//        if(accountBalance == 0) {
//            println("You ain't got no moneyyy")
//            return accountBalance
//        } else {
//            if(amount > accountBalance) {
//                println("Insufficient funds my brotha")
//                return 0
//            } else {
//                return withdraw(amount)
//            }
//        }
//        return accountBalance
//    }
//
////    debitWithdraw()
//
//    //deposit method for checking and debit accounts
//    fun deposit(amount: Int): Int {
//        println("how much would you like to deposit?")
//        var amount: Int? = readLine()?.toIntOrNull()
//
//        if (amount == null) {
//            println("Invalid input")
//            return accountBalance
//        }
//
//        accountBalance += amount
//        println("you have successfully deposited $amount into your account and now have $accountBalance")
//        return amount
//    }
//
////    deposit()
//
//    //method for depositing into a credit account
//    fun creditDeposit(amount: Int): Int {
//        if(accountBalance == 0) {
//            println("you dont owe us anthing")
//            return accountBalance
//        } else {
//            if(accountBalance + amount > 0) {
//                println("deposit failed, you dont owe us that much silly!")
//            } else {
//                if(amount == -accountBalance) {
//                    accountBalance = 0
//                    println("awesome! you payed off your balance and dont owe us anything!")
//                    return amount
//                } else {
//                    deposit(amount)
//                }
//            }
//        }
//
//        return amount
//    }
//
//    creditDeposit(10)
//
//}
//
//
//


fun main() {
    // Step 1
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    // Step 2
    var accountType = ""
    var userChoice = 0

    // Step 3
    while (accountType == "") {
        println("Choose an option (1, 2 or 3)")
        userChoice = (1..5).random()
        println("The selected option is ${userChoice}.")

        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue
        }
    }

    //Step 4
    println("You have created a ${accountType} account.")

    // Step 1

    // inside main function

    var accountBalance = (0..1000).random()

    println("The current balance is ${accountBalance} dollars.")

    val money = (0..1000).random()

    println("The amount you transferred is ${money} dollars.")



    // Step 2

    var output = 0



    // Step 4

    output = withdraw(money)

    println("The amount you withdrew is ${output} dollars.")



    // Step 6

    output = debitWithdraw(money)

    println("The amount you withdrew is ${output} dollars.")

    // Step 7

    fun deposit(amount: Int): Int {

        accountBalance += amount

        println("You successfully deposited ${amount} dollars. The current balance is ${accountBalance} dollars.")

        return amount

    }


    // Step 8

    output = deposit(money)

    println("The amount you deposited is ${output} dollars.")



    // Step 10

    output = creditDeposit(money)

    println("The amount you deposited is ${output} dollars.")

    fun transfer(mode: String) {
        val transferAmount: Int

        when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = withdraw(money)
                }
                println("The amount you withdrew is ${transferAmount} dollars.")
            }
            "deposit" -> {
                if (accountType == "credit") {
                    transferAmount = creditDeposit(money)
                } else {
                    transferAmount = deposit(money)
                }
                println("The amount you deposited is ${transferAmount} dollars.")
            }
            else -> return
        }
    }

    var isSystemOpen = true
    var option = 0

    while (isSystemOpen == true) {
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()
        println("The selected option is ${option}.")

        when (option) {
            1 -> println("The current balance is ${accountBalance} dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}
