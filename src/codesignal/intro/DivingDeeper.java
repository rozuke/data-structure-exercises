package codesignal.intro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivingDeeper {
    /*
    Problem 34
    Description:
    Given array of integers, remove each kth element from it.

    Example:
    For inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 3, the output should be
    solution(inputArray, k) = [1, 2, 4, 5, 7, 8, 10].
    */

    public int[] extractEachKth(int[] inputArray, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k != 0) list.add(inputArray[i]);
        }
        int [] sol = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            sol[j] = list.get(j);
        }
        return sol;
    }

    /*
    Problem 35
    Description:
    Find the leftmost digit that occurs in a given string.

    Example:
    For inputString = "var_1__Int", the output should be solution(inputString) = '1';
    For inputString = "q2q-q", the output should be solution(inputString) = '2';
    For inputString = "0ss", the output should be solution(inputString) = '0'.
    */
    char firstDigit(String inputString) {
        char res = ' ';
        for (int i = 0; i < inputString.length(); i++) {
            int aux = inputString.charAt(i);
            if ( aux >= 48 && aux <= 57) {
                res = (char) aux;
                break;
            }
        }
        return res;
    }

    /*
    Problem 36
    Description:
    Given a string, find the number of different characters in it.

    Example:
    For s = "cabca", the output should be solution(s) = 3.
    There are 3 different characters a, b and c.
    */
    int solution(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();

    }

    /*
    Problem 37
    Description:
    Given array of integers, find the maximal possible sum of some of its k consecutive elements.

    Example:
    For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be solution(inputArray, k) = 8.
    All possible sums of 2 consecutive elements are:
    2 + 3 = 5;
    3 + 5 = 8;
    5 + 1 = 6;
    1 + 6 = 7.
    Thus, the answer is 8.
    */

    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < inputArray.length; i++) {
            int index = 0;
            int auxSum = 0;
            if (i == (inputArray.length + 1 - k)) break;
            for (int j = i; index < k; j++) {
                auxSum += inputArray[j];
                index++;
            }
            if (auxSum > maxSum) {
                maxSum = auxSum;
            }
        }
        return maxSum;
    }




}
