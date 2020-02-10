/*
CSS143B homework 1, problem 2
by Saravanan Sonia
 */
 
 import java.util.Arrays; 

public class Main {
    public static void main(String[] args) {
        System.out.println("testBubbleSort " + (testBubbleSort() ? "PASSED" : "FAILED"));
    }

    public static void bubbleSort(int[] data) {
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

    public static boolean testBubbleSort() {
        int inputs[][] = {
			{},                              
            {1,7,99,2,0,12,15},      
            {8,5,3,1,6,0,7,4,2,5},              
            {64,34,25,12,22,11,90}        
		};
		
        int output[][] = {
			{},                              
            {0,1,2,7,12,15,99},      
            {0,1,2,3,4,5,5,6,7,8},              
            {11,12,22,25,34,64,90}       
		};
		
        for (int i=0; i<inputs.length; i++) {
			bubbleSort(inputs[i]);
        } 

        // compare answer. return false if any case fails. true otherwise
        for (int i=0; i<inputs.length; i++) {

            if (!Arrays.equals(inputs[i], output[i])) {
                System.out.printf("Case %d: Expected: ", i);
				System.out.print(Arrays.toString(output[i]));
				System.out.print(", Actual: ");
				System.out.println(Arrays.toString(inputs[i]));
                return false;
            }
        }
        return true;
    }
}