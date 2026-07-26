import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR })
@interface Author {
    String name();
}

@Author(name = "Ahmed (Class)")
class MyTask {

    @Author(name = "Mohamed (Variable)")
    int number;

    @Author(name = "Mahmoud (Method)")
    public void doSomething() {
    }
}

public class Ch6 {
    public static void main(String[] args) throws Exception {
        Class<MyTask> myClass = MyTask.class;

        if (myClass.isAnnotationPresent(Author.class)) {
            Author a = myClass.getAnnotation(Author.class);
            System.out.println("Class Author: " + a.name());
        }

        for (Method m : myClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Author.class)) {
                Author a = m.getAnnotation(Author.class);
                System.out.println("Method Author: " + a.name());
            }
        }
    }
}