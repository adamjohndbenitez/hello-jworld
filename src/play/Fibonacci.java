package play;

public class Fibonacci {
    private static boolean checkFibonacci(int num) {
        boolean ans = false;
        // convert integer to string
        String snum = String.valueOf(num);
        int len = snum.length()-1;
        for (int j = 0; j <= len; j++) {
            if (snum.charAt(j) == snum.charAt(len-j))
            {
                ans = true;
            } else {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
