import java.util.Scanner;

public class ArrayImplementation {
    public static void main(String[] args) {
        // Create an array
        int[] array = new int[5]; // Array with a fixed size of 5
        Scanner scanner = new Scanner(System.in);

        // Input elements into the array
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        // Display the array elements
        System.out.println("The elements of the array are:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Perform basic operations
        // 1. Accessing an element
        System.out.println("Accessing the 3rd element (index 2): " + array[2]);

        // 2. Updating an element
        System.out.println("Updating the 3rd element to 100.");
        array[2] = 100;

        // Display the updated array
        System.out.println("Updated array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // 3. Searching for an element
        System.out.println("Enter an element to search:");
        int target = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("Element " + target + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + target + " not found in the array.");
        }

        // 4. Deleting an element (logical deletion)
        System.out.println("Enter the index of the element to delete (logical deletion):");
        int indexToDelete = scanner.nextInt();
        if (indexToDelete >= 0 && indexToDelete < array.length) {
            array[indexToDelete] = 0; // Setting it to 0 for logical deletion
            System.out.println("Element at index " + indexToDelete + " deleted.");
        } else {
            System.out.println("Invalid index.");
        }

        // Display the array after deletion
        System.out.println("Array after deletion:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
