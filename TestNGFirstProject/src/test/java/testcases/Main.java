package testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "sreedhar123us456";

        // Define a regex pattern to match words (letters only)
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);

        // Iterate through matches and print each word
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }
    }
}