public class Ch8_4 {
    public static boolean isOnlyLetters(String text) {

        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);

            if (!Character.isLetter(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text1 = "ITI";
        String text2 = "Java 2025";

        System.out.println("Is 'ITI' only letters? " + isOnlyLetters(text1));
        System.out.println("Is 'Java 2025' only letters? " + isOnlyLetters(text2));
    }
}
