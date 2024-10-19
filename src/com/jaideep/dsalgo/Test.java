package com.jaideep.dsalgo;

public class Test {
    public String handleException(String string1, String string2, String operator) {
        try {
            if (string1 == null || string2 == null) {
                throw new NullPointerException();
            } else if (!operator.equals("+") && !operator.equals("-")) {
                throw new Exception();
            }
            return "No exception found";
        } catch (NullPointerException ne) {
            return "Null value found";
        } catch (Exception e) {
            return operator;
        }
    }

    public String doOperation(String string1, String string2, String operator) {
        if (operator.charAt(0) == '+') {
            return string1 + string2;
        }
        return string1.replaceAll(string2, "");
    }

    public static void main(String[] args) {
        
    }
}
