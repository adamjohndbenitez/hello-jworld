package jfjca.chapter7;

public class TestSwitchFallThroughCharLowerCaseVowel {
//    public static void main(String[] args) {
//        java.io.BufferedReader rd = null;
//        try (rd = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("charFile.txt"), java.nio.charset.Charset.forName("UTF-8")))) {
//            char ch = 0;
//            int noOfVowels = 0;
//            while ((ch = (char) rd.read()) > 0) {
//                switch (ch) {
//                    case 'a' :
//                    case 'e' :
//                    case 'i' :
//                    case 'o' :
//                    case 'u' : noOfVowels++;
//                    default : logCharToWhatever(ch);
//                }
//            }
//            System.out.println("Number of vowels received " + noOfVowels);
//        } catch(java.io.IOException ioe) {
//            System.out.println("IOException");
//        } catch(java.io.UnsupportedEncodingException uee) {
//            System.out.println("UnsupportedEncodingException");
//        } catch(java.io.FileNotFoundException fnfe) {
//            System.out.println("FileNotFoundException");
//        } finally {
//            rd.close();
//        }
//    }

    private static void logCharToWhatever(char ch) {
        System.out.println("Log Character - " + ch);
    }
}