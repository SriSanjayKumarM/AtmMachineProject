package AtmMachine;

import java.util.Scanner;

public class AtmMachine {
    public static void main(String[] args) {

        //Creating object

        AtmMachine atm = new AtmMachine();
        atm.working(); //invoking working method
    }

    /**
     * working method
     */

    private void working() {
        System.out.println("Welcome to Our Bank, Insert Your Card");
        Pin pin = new Pin();

        //scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Pin...");
        int userPin = sc.nextInt();

        /**
         * accessing getName method in Pin class to get name of the user
         */

        String name = pin.gettingName(userPin); //invoking gettingName method

        /**
         * to show the pin entered by user is wrong
         */

        if (name == null) {
            System.out.println("Wrong Pin");
        }

        /**
         * if pin is right it prints the name of the user
         */

        else {
            System.out.println("Welcome " + name + ", Select any one option...");
        }


        /**
         * printing deposit, bal enq, withdraw and pin change options
         */

        System.out.println("1-Deposit, 2-Balance Enquiry, 3-Withdraw, 4-Pin Change");
        int options = sc.nextInt();
        handleOption(options, sc, userPin, pin);
    }

    private void handleOption(int userSelectedOption, Scanner sc, int userPin, Pin pin) {
        //switch statement
        switch (userSelectedOption) {

            /**
             * case statements
             * instead of using if-else statements we can use switch case statements
             */
            case 1:
                //Deposit amount
                Deposit deposit = new Deposit();
                System.out.println("Enter the amount to deposit...");
                double addAmount = sc.nextDouble();
                addAmount = addAmount + deposit.avail_balance(userPin);
                System.out.println(addAmount);
                break;

            case 2:
                //Balance Enquiry
                deposit = new Deposit();
                Double avail_balance = deposit.avail_balance(userPin);
                System.out.println(avail_balance);
                if (avail_balance==null){
                    System.out.println("Please enter correct OTP...");
                }
                break;

            case 3:
                //Withdraw amount
                deposit = new Deposit();
                System.out.println("Enter the amount to withdraw...");
                double withdrawAmount = sc.nextDouble();
                withdrawAmount = deposit.avail_balance(userPin) - withdrawAmount;
                System.out.println(withdrawAmount);
                break;

            case 4:
                //Pin Change
                System.out.println("Enter Your Old Pin...");
                int oldPin = sc.nextInt();
                if (oldPin==userPin){
                    System.out.println("Enter Your New Pin...");
                    int newPin = sc.nextInt();
                    pin.updatePin(oldPin, newPin);
                    System.out.println("Your Pin has changed");
                    System.out.println("Your New Pin is : "+ newPin);
                }
                else {
                    System.out.println("PIN NOT MATCHES...");
                }
                break;
        }
    }
}