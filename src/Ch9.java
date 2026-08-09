import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ch9 {
    
    static Map<Character, List<String>> dictionary = new TreeMap<>();

    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Apricot", "Cat", "Avocado", "Car", "Bat"};

        for (String word : words) {
            char firstLetter = Character.toUpperCase(word.charAt(0));
            if (!dictionary.containsKey(firstLetter)) {
                dictionary.put(firstLetter, new ArrayList<>());
            }

            dictionary.get(firstLetter).add(word);
        }

        for (List<String> list : dictionary.values()) {
            Collections.sort(list); 
        }

        System.out.println("--- Dictionary ---");
        printAll();

        System.out.println("\n--- Words start with A only ---");
        printLetterWords('A');
    }

    public static void printAll() {
        for (Character letter : dictionary.keySet()) {
            System.out.println("letter " + letter + " : " + dictionary.get(letter));
        }
    }

    public static void printLetterWords(char letter) {
        char upperLetter = Character.toUpperCase(letter);
        if (dictionary.containsKey(upperLetter)) {
            System.out.println(dictionary.get(upperLetter));
        } else {
            System.out.println("no words started with this letter");
        }
    }
}