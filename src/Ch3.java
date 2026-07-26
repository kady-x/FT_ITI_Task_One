import java.util.Arrays;

public class Ch3 {
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = (int) (Math.random() * 1000);
        }

        long startTime = System.nanoTime();

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        long endTime = System.nanoTime();
        System.out.println("min " + min + " | max " + max);
        System.out.println("normal search time: " + (endTime - startTime) + " ns");
        Arrays.sort(numbers);

        int target = numbers[500];

        startTime = System.nanoTime();
        int resultIndex = Arrays.binarySearch(numbers, target);

        endTime = System.nanoTime();
        System.out.println("binary search time: " + (endTime - startTime) + " ns");
    }
}
