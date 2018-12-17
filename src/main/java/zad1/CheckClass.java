package zad1;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckClass {

    Count count = new Count();

    Variable variable = new Variable();

    private Stack stack = new Stack();

    private String res;

    public String checkStart(String message) {


        Pattern pattern;
        pattern = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*\\s{1}={1}[a-zA-Z0-9\\s+--*/]*");//= assignment pattern

        Matcher mat;
        mat = pattern.matcher(message);

        if (mat.matches()) {
            String[] parts = message.split("\\s+={1}\\s+");//split string into variable and value

            stack.push(parts[1]);//value

            valVar(parts[1]);//counting value

            res = (checkVar(String.valueOf(stack.pop())));//final value

            variable.put(parts[0], res);//saving value with variable

            stack.clear();

            return parts[0] + "=" + variable.get(parts[0]); // result display

        } else {//just value

            valVar(message);//counting value

            if (stack.empty()) {//checking what was at standard input
                if (variable.get(message) != "Error") {
                    res = "???";
                } else
                    res = "Error";
            } else
                res = checkVar(String.valueOf(stack.pop()));//final value

            stack.clear();

            return res;//result display
        }
    }


    private void counter() {

        count.setSign(stack.pop().toString());//get sign for calculation
        count.setSecond(stack.pop().toString());
        count.setFirst(stack.pop().toString());
        stack.push(count.count());//result of calculation

    }

    private void valVar(String message) {
        String[] parts = message.split("\\s");//split whole sting into single values/variables
        int cnt = 0;
        if (1 != parts.length) { //make sure this is not a assignment of value
            for (int i = ((parts.length) / 2); i > 0; i--) {//number of calculation
                Pattern pattern;
                pattern = Pattern.compile("[+--*/]{1}");//sign

                while (!pattern.matcher(parts[cnt]).matches()) {
                    stack.push(checkVar(parts[cnt]));
                    cnt++;
                    if (parts.length < cnt) //something went wrong
                        return;
                }
                stack.push(checkVar(parts[cnt]));

                counter();//simple counting
                cnt++;
            }
        }
    }

    private String checkVar(String var) {

        Pattern pattern1;
        pattern1 = Pattern.compile("[a-zA-Z]+");//variable

        Matcher mat1;
        mat1 = pattern1.matcher(var);
        if (mat1.matches()) {
            if (variable.get(var) != null) {//check if it is value or variable
                return (variable.get(var));//value from variable
            } else {
                return "Error";//don't recognize this variable
            }
        } else {
            return (var);//just value
        }
    }

}
