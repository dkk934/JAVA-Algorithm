import java.util.Scanner;

// Renamed the class to follow PascalCase
class Counter {
    public void printNumbers() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("What's your name?");
            String name = sc.nextLine();
            Counter counter = new Counter();
            counter.printNumbers();
            System.out.println("Hello, " + name);
        } finally {
            sc.close(); // Closing the Scanner resource
        }
    }
}
