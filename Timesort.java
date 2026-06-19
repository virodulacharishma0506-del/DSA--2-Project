import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[] = {3, 7, 11, 5, 4, 6, 9, 12, 1, 2, 8, 10, 13, 14};

        System.out.println("Original Array:");
        for(int x : arr)
            System.out.print(x + " ");

        Arrays.sort(arr);   // Java uses Timsort for Object arrays

        System.out.println("\n\nSorted Array:");
        for(int x : arr)
            System.out.print(x + " ");
    }
}