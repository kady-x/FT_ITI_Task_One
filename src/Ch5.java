import java.util.function.Function;

public class Ch5 {
    public static void main(String[] args) {

        Function<Double, Double> convertTemp = (celsius) -> (celsius * 9 / 5) + 32;

        double c = 30.0;
        double f = convertTemp.apply(c);
        System.out.println("30 celsius in fahrenheit: " + f);
        Function<double[], double[]> solveEquation = (numbers) -> {
            double A = numbers[0];
            double B = numbers[1];
            double C = numbers[2];

            double underRoot = (B * B) - (4 * A * C);

            double root1 = (-B + Math.sqrt(underRoot)) / (2 * A);
            double root2 = (-B - Math.sqrt(underRoot)) / (2 * A);

            return new double[] { root1, root2 };
        };

        double[] abc = { 1, -5, 6 };
        double[] results = solveEquation.apply(abc);

        System.out.println("the result for the equation is: x1=" + results[0] + ", x2=" + results[1]);
    }
}
