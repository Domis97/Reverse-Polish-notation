package zad1;

import java.util.HashMap;


public class Variable {


    private HashMap<String, Integer> hashMap = new HashMap<>();


    public void put(String variable, String value) { //new variable with value
        int valueInt = Integer.parseInt(value);
        hashMap.put(variable, valueInt);
    }

    public String get(String variable) {//show value from variable

        if (hashMap.get(variable) == null)
            return "Error";
        else
            return Integer.toString(hashMap.get(variable));
    }

}
