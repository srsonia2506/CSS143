import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSort();
    }

    private static int partition(int arr[], int low, int high) {
        // homework
        return -1; // place holder
    }

    private static void quickSort(int data[], int low, int high) {
        // homework
        // this should call the above partition(...)
    }

    public static void bubbleSort(int data[]) {
        // use code from homework 1
    }

    public static void quickSort(int data[]) {
        quickSort(data, 0, data.length - 1);
    }

    public static void testSort() {
        // homework
        // compare both
        // 1. bubble sort and quick sort result match
        // 2. both result match the result of Arrays.sort()
        System.out.println("testSort FAILED"); // placeholder
    }

    //https://mkyong.com/java/java-generate-random-integers-in-a-range/
    // generate a random number between min and max
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
