class Complex<C extends Number> {
    private Number real;
    private Number imaginary;

    public Complex(C real, C imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Number getReal() {
        return real;
    }

    public Number getImaginary() {
        return imaginary;
    }

    public Complex<Number> add(Complex<?> other) {
        Number newReal = this.real.doubleValue() + other.real.doubleValue();
        Number newImg = this.imaginary.doubleValue() + other.imaginary.doubleValue();
        return new Complex<>(newReal, newImg);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class Ch8_2 {
    public static void printComplex(Complex<? extends Number> complex) {
        System.out.println("Real part: " + complex.getReal());
        System.out.println("Imaginary part: " + complex.getImaginary());
    }

    public static void main(String[] args) {
        Complex<Integer> complex = new Complex<>(1, 2);
        printComplex(complex);

        Complex<Double> complexDouble = new Complex<>(1.0, 2.0);
        printComplex(complexDouble);

        Complex<Number> result = complex.add(complexDouble);
        System.out.println("|--------------------------------------|\n" + result);
        printComplex(result);
    }
}
