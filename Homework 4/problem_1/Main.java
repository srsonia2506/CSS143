/*
CSS143B homework 4, problem 1
by Saravanan Sonia
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("testBinarySearch " + (testBinarySearch() ? "PASSED" : "FAILED"));
    }

    // helper function
    public static int binarySearch(int[] data, int target, int start, int end) {
      int middle = start+(end-start)/2;
		
      if(end < start){
        return -1;
      } 
      
      if (target < data[middle]){
        return binarySearch(data, target, start, middle - 1);
      }
      
      if (target > data[middle]){
        return binarySearch(data, target, middle + 1, end);
      }
      
      if (target == data[middle]){
        return middle;
      }
      
      return -1;
    }

    // binarySearch returns the index of the target location found in the array
    // returns -1 if target not found.
    public static int binarySearchRecursive(int[] data, int target) {
       return binarySearch(data, target, 0, data.length-1);
    }

    public static int binarySearchIterative(int[] data, int target) {
        if (data.length<=0) {
          return -1;
        }
        
        int index = -1;
        int low=0,high=data.length-1;
         
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] < target) {
                low = mid + 1;
            } else if (data[mid] > target) {
                high = mid - 1;
            } else if (data[mid] == target) {
                index = mid;
                break;
            }
        }
        
        return index;
    }

    public static boolean testBinarySearch() {
        int inputs[][] = {
                {},
                {3},
                {3},
                {1,3},
                {1,3},
                {4,6,8},
                {4,6,8},
                {4,6,8},
                {3,5,7,9,20},
                {3,5,7,9,20},
        };
        int targets[] = {9, 1, 3, 1, 3, 4, 6, 8, 3, 9};
        int answer[] = {-1, -1, 0, 0, 1, 0, 1, 2, 0, 3};

        for (int i=0; i<inputs.length; i++) {
            int iterativeAnswer = binarySearchIterative(inputs[i], targets[i]);
            int recursiveAnswer = binarySearchRecursive(inputs[i], targets[i]);
            int expected = answer[i];
            if (iterativeAnswer!=expected || recursiveAnswer!=expected) {
                System.out.printf("testBinarySearch: case %d, expected %d, iterativeAnswer %d, recursiveAnswer %d\n",
                                    i, expected, iterativeAnswer, recursiveAnswer);
                return false;
            }
        }
        return true;
    }
}
