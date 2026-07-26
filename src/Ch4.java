import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ch4 {
    public static void main(String[] args) {
        String text = "Java is fun, learning Java is easy";
        String word = "Java";

        // using split
        String[] parts = text.split(word);
        int count1 = parts.length - 1;
        System.out.println("The number of " + word + " is " + count1 + " using split");

        // using indexOf
        int count2 = 0;
        int index = 0;
        while (true) {
            index = text.indexOf(word, index);
            if (index == -1)
                break;
            count2++;
            index += word.length();
        }
        System.out.println("The number of " + word + " is " + count2 + " using indexOf");

        // using StringTokenizer
        int count3 = 0;
        StringTokenizer tokenizer = new StringTokenizer(text, " ,");
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equals(word)) {
                count3++;
            }
        }
        System.out.println("The number of " + word + " is " + count3 + " using StringTokenizer");

        // using Regex
        int count4 = 0;
        Pattern pattern = Pattern.compile("\\b" + word + "\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count4++;
        }
        System.out.println("The number of " + word + " is " + count4 + " using Regex");
    }
}