/*
CSS143B homework 1, problem 3
by Saravanan Sonia
 */

import java.util.Arrays; 

class Answer {
    private int val;
    private boolean isValid;

    public Answer(int maxNumber, boolean foundAnswer) {
        this.val = maxNumber;
        this.isValid = foundAnswer;
    }

    public boolean equals(Answer anotherAnswer) {
        return val == anotherAnswer.val &&
                isValid == anotherAnswer.isValid;
    }

    @Override
    public String toString() {
        return "MaxNumberAnswer{" +
                "maxNumber=" + val +
                ", foundAnswer=" + isValid +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("testFindHighestFrequencyNumber " + (testFindHighestFrequencyNumber() ? "PASSED" : "FAILED"));
    }

    public static Answer findHighestFrequencyNumber(int[] data) {
        Arrays.sort(data); 
          
        int max = 1, curr = 1, n = data.length;

        if (n == 0){
          return new Answer(-1, false);
        }

        int res = data[0];
          
        for (int i = 1; i < n; i++){ 
            if (data[i] == data[i - 1]){ 
                curr ++; 
            }else{ 
                if (curr > max){ 
                    max = curr; 
                    res = data[i - 1]; 
                } 
                curr = 1; 
            } 
        } 
      
        if (curr > max){ 
            max = curr; 
            res = data[n - 1]; 
        } 
      
        return new Answer(res, true); 
    }

    public static boolean testFindHighestFrequencyNumber() {
        // prepare the answers
        int inputs[][] = {
                {},
                {7},
                {-1},
                {2, 2},
                {4, 4, 3},
                {6, 5, -1, 6},
                {7, 8, 9, 8, 8},
                {5, 5, 5, 6, 6},
                {5, 5, 6, 6, 6},
                {4, 4, 5, 5, 5, 6, 6, 6},
                {2, 2, 1, 1, 2}};
				
        int values[] = {-1, 7, -1, 2, 4, 6, 8, 5, 6, 5, 2};
        Answer[] answers = new Answer[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            answers[i] = new Answer(values[i], (i == 0 ? false : true));
        }

        // compare answer. return false if any case fails. true otherwise
        for (int i = 0; i < inputs.length; i++) {

            Answer actual = findHighestFrequencyNumber(inputs[i]);
            Answer expected = answers[i];

            if (!expected.equals(actual)) {
                System.out.printf("Case %d: Expected %s, actual %s\n", i, expected, actual);
                return false;
            }
        }
        return true;
    }
}