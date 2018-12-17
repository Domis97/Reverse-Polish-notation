package zad1;

public class Count {

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    private String first;
    private String second;
    private String sign;

    protected String count() { //calculating value
        int result = 0;
        int f = Integer.parseInt(first);
        int s = Integer.parseInt(second);


        switch (sign) {
            case "+":
                result = f + s;
                break;
            case "-":
                result = f - s;
                break;
            case "*":
                result = f * s;
                break;
            case "/":
                result = f / s;
                break;
        }
        return Integer.toString(result);
    }
}
