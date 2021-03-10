package play;

/*
* Run Length Encoding Problem
* input: aaaabbccca
* output: 4a2b3c1a
*
* */
public class RunLengthEncoding {
    public String encode(String input) {
        //check for null input
        if (input == null || input.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        char[] inputChars = input.toCharArray();
        char prevChar = 0;
        int counter = 0;
        // iterate over input
        for (char c : inputChars) {
            if (c == prevChar)
                counter++;
            else {
                if (prevChar != 0)
                    stringBuilder.append(counter).append(prevChar);
                prevChar = c;
                counter = 1;
            }
        }
        stringBuilder.append(counter).append(prevChar);
        return stringBuilder.toString();
    }
}
