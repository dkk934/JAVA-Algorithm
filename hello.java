import java.util.*;

class count {
    public void count() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("what`s your name?");
        String name = sc.nextLine();
        count c = new count();
        c.count();
        System.out.println("Hello, " + name);
    }
}