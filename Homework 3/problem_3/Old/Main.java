//old version

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println("testColorSort " + (Tests.testColorSort() ? "PASSED" : "FAILED"));
    }

    public static void colorSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        int red = 0;
        int blue = nums.length - 1;
         
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                swap(nums, i, red);
                red++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, blue);
                blue--;
            } else {
                i++;
            }
        }
    }
     
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
