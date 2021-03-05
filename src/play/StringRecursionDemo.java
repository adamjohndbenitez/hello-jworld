package practice;

public class StringRecursionDemo {
    public String recursiveString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return recursiveString(s.substring(1)) + s.charAt(0);
    }
}
