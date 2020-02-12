import java.util.Arrays;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        testSort();
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[low]; // taking first element as pivot

        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            
            while (arr[high] > pivot) {
                high--;
            }

            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                //increment left index and decrement right index
                low++;
                high--;
            }
        }
        return low;
    }

    private static void quickSort(int[] data, int low, int high) {
        int index = partition(data, low, high);

        if (low < index - 1) {
            quickSort(data, low, index - 1);
        }

        if (high > index) {
            quickSort(data, index, high);
        }
    }

    public static void bubbleSort(int data[]) {
      int n = data.length;
      for (int i = 0; i < n-1; i++){
        for (int j = 0; j < n-i-1; j++){
          if (data[j] > data[j+1]){
            int temp = data[j];
            data[j] = data[j+1];
            data[j+1] = temp;
          }
			  }
		  }
    }

    public static void quickSort(int data[]) {
        quickSort(data, 0, data.length - 1);
    }

    public static int[] newArray() {
      int arrLength=getRandomNumberInRange(0, 100);
      int[] arr = new int[arrLength];
      for(int i=0;i<arrLength;i++){
        arr[i]=getRandomNumberInRange(Integer. MIN_VALUE, Integer. MAX_VALUE);
      }
      return arr;
    }

    public static void testSort() {
      int inputs[][] = new int[5][];
      int arraySort[][]= new int[5][];
      int bubblesort[][] = new int[5][];
      int quicksort[][] = new int[5][];

      for (int i=0;i<5;i++){
        int[] arr = newArray();
        inputs[i]= arr;
        bubblesort[i]= arr;
        quicksort[i]= arr;
        arraySort[i]= arr;
      }

      for (int i=0; i<inputs.length; i++) {
        Arrays.sort(inputs[i]); 
	bubbleSort(bubblesort[i]);
        quickSort(quicksort[i]);
      }
      
      for (int i=0; i<bubblesort.length; i++) {
	if (!Arrays.equals(bubblesort[i],quicksort[i])) {
          System.out.println("testSort FAILED"); 
          System.out.printf("Case %d: Array: ", i);
	  System.out.println(Arrays.toString(inputs[i]));
          System.out.print(", BubbleSort Output: ");
	  System.out.print(Arrays.toString(bubblesort[i]));
	  System.out.print(", QuickSort Output: ");
	  System.out.println(Arrays.toString(quicksort[i]));
          return;
        }
      }

      for (int i=0; i<inputs.length; i++) {
	if (!Arrays.equals(bubblesort[i],inputs[i])) {
          System.out.println("testSort FAILED"); 
          System.out.printf("Case %d: Array: ", i);
	  System.out.println(Arrays.toString(inputs[i]));
          System.out.print(", BubbleSort Output: ");
	  System.out.print(Arrays.toString(bubblesort[i]));
	  System.out.print(", QuickSort Output: ");
	  System.out.println(Arrays.toString(quicksort[i]));
          return;
        }
      }
      System.out.println("testSort PASSED"); 
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
