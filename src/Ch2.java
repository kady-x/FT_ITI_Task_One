import java.util.Scanner;

public class Ch2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Write your name: ");
        String name = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("You didn't write anything!");
        } else {
            System.out.println("Welcome " + name);
        }

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Enter a word to repeat it: ");
        String word = sc.next();

        for (int i = 1; i <= num; i++) {
            System.out.println("number " + i + ": " + word);
        }
    }
}