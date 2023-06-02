package AtmMachine;

import java.util.Scanner;

public class AtmMachine {
    public static void main(String[] args) {

        //Creating object

        AtmMachine atm = new AtmMachine();
        atm.working();
    }
    //methods

    private void working(){
        System.out.println("Welcome to Our Bank, Insert Your Card");
        Pin pin = new Pin();

        //scanner

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Pin...");
        int userPin = sc.nextInt();

        /**
         * accessing getName method in Pin class to get name of the user
         */

        String name = pin.gettingName(userPin);

        /**
         * to show the pin entered by user is wrong
         */

        if(name == null){
            System.out.println("Wrong Pin");
        }
        else{
            System.out.println(name);
        }
    }
}