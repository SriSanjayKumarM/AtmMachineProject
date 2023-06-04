package AtmMachine;

import java.util.HashMap;

public class Pin {

    HashMap <Integer,String> name = new HashMap<>();

    /**
     * to verify the name of the user with pin
     */
    public  Pin(){
        name.put(1111,"Captain America");
        name.put(2222,"Iron Man");
        name.put(3333,"Dr. Strange");
    }

    /**
     * to get name of the user
     * @param userPin pin entered by the user
     * @return name of the user
     */
    public String getName(int userPin){
        return name.get(userPin);
    }

    public void updatePin(int oldUserPin, int newUserPin) {
        String oldValue = name.get(oldUserPin);
        name.remove(oldUserPin);
        name.put(newUserPin, oldValue);
    }
}