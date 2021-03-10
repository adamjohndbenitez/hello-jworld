package play;

public class Palindrome {
    public void checkPalindrome() {
        int total = 0;
        boolean ans = false;

        for (int i = 9999; i <= 10000; i--) {
            total += i;

            // convert integer to string
            String snum = String.valueOf(i);
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
        }
        System.out.println("answer is : " + total);
    }


}
