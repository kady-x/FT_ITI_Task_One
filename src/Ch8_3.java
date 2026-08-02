import java.util.function.BiPredicate;

public class Ch8_3 {

    public static String betterString(String s1, String s2, BiPredicate<String, String> condition) {
        if (condition.test(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    public static void main(String[] args) {
        String string1 = "Java";
        String string2 = "Python";

        String longer = betterString(string1, string2, (a, b) -> a.length() > b.length());
        System.out.println("The longer string is: " + longer);

        String first = betterString(string1, string2, (a, b) -> true);
        System.out.println("The first string is: " + first);
    }

}
