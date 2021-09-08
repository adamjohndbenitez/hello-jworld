package oca;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringClass {
    public static void main(String[] args) {
        String str = "String";
        int length = str.length();
        System.out.println("Length: " + length);
        boolean isContains = str.contains("ri");
        System.out.println(isContains ? "it contains ri" : "no ri");
        char c = str.charAt(0);
        System.out.println(c + "character at index 0");
        boolean isEquals = str.equals(new String(new char[]{'S', 't', 'i', 'n', 'g'}));
        System.out.println(isEquals ? "same in set of characters" : "no equal");
        int lexi = str.compareTo("String");
        if (lexi < 0) {
            System.out.println("Comparing lexi to 0The result is a negative integer if this String object lexicographically precedes the argument string.");
        } else if (lexi > 0) {
            System.out.println("The result is a positive integer if this String object lexicographically follows the argument string.");
        } else if (lexi == 0) {
            System.out.println("The result is zero if the strings are equal");
        }
        // The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true.
        boolean same = str.equalsIgnoreCase("STRING");
        System.out.println(same ? "Same strings even though all capital letters" : "not the same");
        String[] rs = str.split("r");
        for (String r : rs) {
            System.out.println("splitted - " + r);
        }
        String[] rs1 = str.split("r",1);
        for (String r : rs1) {
            System.out.println("(limit:1) splitted - " + r);
        }
        boolean isStart = str.startsWith("S");
        System.out.println(str + "is starts with S: " + (isStart ? "yes" : "no"));
        boolean isStart1 = str.startsWith("S", 3);
        System.out.println(str + "is starts with S after index 3: " + (isStart1 ? "yes" : "no"));
        boolean contentsStr = str.contentEquals("Str");
        System.out.println(str + " contains Str " + (contentsStr ? "YES" : "NO"));
        boolean contentsStr1 = str.contentEquals(new StringBuffer("String"));
        System.out.println(str + " contains String " + (contentsStr1 ? "YES" : "NO"));
        String str1 = str.concat("s");
        System.out.println("Plural of " + str + " is " + str1);
        boolean isEmpty = str.isEmpty();
        System.out.println("variable str is " + (isEmpty ? "Empty" : "not Empty"));
        String upperCase = str.toUpperCase();
        System.out.println("Uppercase of " + str + " is " + upperCase);
        String usUpperCase = str.toUpperCase(new Locale("us"));
        System.out.println("(Locale - us) Uppercase of " + str + " is " + upperCase);
        char[] strChars = str.toCharArray();
        for (char ch : strChars) {
            System.out.println("char - " + ch);
        }
        byte[] strBytes = str.getBytes();
        for (byte b : strBytes) {
            System.out.println("byte - " + b);
        }
        try {
            byte[] strBytes1 = str.getBytes("UTF-8");
            System.out.println("bytes of str with charsetName");
            for (byte b : strBytes1) {
                System.out.println("byte - " + b);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        char[] charStrs = new char[str.length()];
        str.getChars(0, str.length(), charStrs, 0);
        System.out.println("Transferred from str=" + str + " to new charStrs=" + charStrs);
        String replaceFirst = str.replaceFirst("S", "LL");
        System.out.println(str + " is replace at First with STR = " + replaceFirst);
        String replaceOldNew = str.replace('i', 'e');
        System.out.println("Replace old to new " + replaceOldNew);
        String replaceOldNew1 = str.replace("Str", "Talk");
        System.out.println("Replace old to new " + replaceOldNew1);
        String replaceAll = str.replaceAll(replaceFirst, "S");
        System.out.println(replaceFirst + " Replace all with = " + replaceAll);
        String substring = str.substring(1);
        System.out.println(str + " substring = " + substring);
        String substring1 = str.substring(2);
        System.out.println(str + " substring = " + substring1);
        boolean matches = str.matches(".*tr.*");
        System.out.println("matches = " + matches);
        boolean endsWithg = str.endsWith("g");
        System.out.println(str + " ends with " + endsWithg);
        String strSpaces = "   " + str;
        String strSpaces1 = strSpaces.concat("   ");
        System.out.println("Spaces are appended at beginning and at end" + strSpaces1);
        System.out.println("Trimming spaces = " + strSpaces1.trim());
        CharSequence subSequence = str.subSequence(0, str.length()-2);
        System.out.println("Sub sequence = " + subSequence);
        String intern = str.intern();
        System.out.println("canonical representation for the string '" + str +  "' str = " + intern);
    }
}
