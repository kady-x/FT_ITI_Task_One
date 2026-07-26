class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

public class Ch7 {

    public static void checkAge(int age) throws MyCustomException {
        if (age < 18) {
            throw new MyCustomException("Age is less than 18!");
        }
        System.out.println("Age is valid.");
    }

    public static void checkPassword(String pass) throws MyCustomException {
        if (pass.length() < 6) {
            throw new MyCustomException("Password is too short!");
        }
        System.out.println("Password is valid.");
    }

    public static void checkScore(int score) throws MyCustomException {
        if (score < 0) {
            throw new MyCustomException("Negative Score!");
        }
        System.out.println("Score is valid.");
    }

    public static void main(String[] args) {
        try {
            checkAge(20);
            checkScore(-5);
            checkPassword("123");
        } catch (MyCustomException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Done.");
        }
    }
}