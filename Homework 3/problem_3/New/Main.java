//new version


import java.util.Arrays;

//added comments explaining what I have done so can be looked back in 10 years and even I would understand. God would not be the only one understanding my code
// also changed some variable names to be more understanding

public class Main {
    public static void main(String[] args) {
        //System.out.println("testColorSort " + (Tests.testColorSort() ? "PASSED" : "FAILED"));
    }
	
	//Am using 2 pointers to keep track. Push "0" to the beginning, leave "1" as it is, move "2"s to the end 
    public static void colorSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        int red = 0;
        int blue = nums.length - 1;
         
        int index = 0;
        while (index <= blue) {
            if (nums[i] == 0) {
                swap(nums, index, red);
                red++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, blue);
                blue--;
            } else {
                index++;
            }
        }
    }
     
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
