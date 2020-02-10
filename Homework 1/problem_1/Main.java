/*
CSS143B homework 1, problem 1
by Saravanan Sonia
*/

import java.util.Objects;

class BinarySearchAnswer{
    int index;
    boolean empty;

    public BinarySearchAnswer(int index, boolean empty) {
        this.index = index;
        this.empty = empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchAnswer that = (BinarySearchAnswer) o;
        return index == that.index && empty == that.empty;
    }

    @Override
    public String toString() {
        return "BinarySearchAnswer{" + "index=" + index + ", isEmpty=" + empty + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("testBinarySearch " + (testBinarySearch() ? "PASSED" : "FAILED"));
    }

    public static BinarySearchAnswer binarySearch(int[] data, int target) {
        
        if (data.length<=0) {
          return new BinarySearchAnswer(-1, true);
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
        
        return new BinarySearchAnswer(index, false);
    }

    public static boolean testBinarySearch() {
        //assumed that all inputs are previously sorted in asending order
        //returns first index obtained in case of repeated values
        int inputs[][] = {
            {},                              // Empty Array
            {1},                             // One Element Array
            {0,2,4,6,12,14,16},              // Not Found In Sorted Odd Array
            {2,4,8,11,12,17,26,38},          // Not Found In Sorted Even Array 
            {3,7,8,11,18,22,35,39},          // Found At First In Sorted Array
            {3,7,8,11,18,22,35,39},         // Found In Middle In Sorted Array
            {3,7,8,11,18,22,35,39},         // Found At End In Sorted Array
            /*
            {0,2,4,6,12,14,16}               // Tests for Wrong Answer
            */
        };
        
        int[] targets = {2,1,9,9,3,18,39/*,9*/};
        int values[] = {-1, 0,-1,-1,0,4,7/*,5*/};
        BinarySearchAnswer[] answers = new BinarySearchAnswer[inputs.length];
        for (int i=0; i<inputs.length; i++) {
            answers[i] = new BinarySearchAnswer(values[i], (i==0 ? true:false));
        }

        // compare answer. return false if any case fails. true otherwise
        for (int i=0; i<inputs.length; i++) {

            BinarySearchAnswer expected = binarySearch(inputs[i],targets[i]);
            BinarySearchAnswer actual = answers[i];

            if (!expected.equals(actual)) {
                System.out.printf("Case %d: Expected %s, actual %s\n", i+1, expected, actual);
                return false;
            }
        }
        return true;
    } 
    
}