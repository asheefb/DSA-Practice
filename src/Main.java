import Arrays.DeleteNumberInArray;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        List<Object> delete = DeleteNumberInArray.delete(array, num);

        delete.forEach(element -> {
            if (element instanceof int[] arr) {
                Arrays.stream(arr).forEach(System.out::print);
            } else {
                System.out.print(element);
            }
        });

//        findLargestNumber(array);
    }


    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void findLargestNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        System.out.println(max);
    }
}