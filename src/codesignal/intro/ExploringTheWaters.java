package codesignal.intro;

import java.util.HashSet;
import java.util.Set;

public class ExploringTheWaters {
    /*
    Problem 14
    Description:
    Several people are standing in a row and need to be divided into two teams. The first person goes into team 1
    the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.
    You are given an array of positive integers - the weights of the people. Return an array of two integers,
    where the first element is the total weight of team 1, and the second element is the total weight of team 2
    after the division is complete.

    Example:
    For a = [50, 60, 60, 45, 70], the output should be solution(a) = [180, 105].
    */

    public static int[] alternatingSums(int[] a) {
        if (a.length == 2 ) return a;
        int totalA = 0;
        int totalB = 0;

        for(int i = 0; i < a.length; i++) {

            if((i + 1) % 2 == 0) {
                totalB+= a[i];
            } else {
                totalA+= a[i];
            }

        }
        return new int [] {totalA, totalB};
    }

    /*
    Problem 15
    Description:
    Given a rectangular matrix of characters, add a border of asterisks(*) to it.

    Example:
    For picture = ["abc",
                   "ded"]
    the output should be:
    solution(picture) = ["*****",
                         "*abc*",
                         "*ded*",
                         "*****"]
    */

    public static String[] addBorder(String[] picture) {
        String [] sol = new String[picture.length + 2];
        String aux = "";
        String asterisk = "";
        for (int i = 0; i < picture[0].length() + 2; i++) {
            asterisk+= "*";
        }
        sol[0] = asterisk;
        sol[sol.length - 1] = asterisk;

        for (int i = 1; i < sol.length - 1; i++) {
            aux = "*" + picture[i - 1] + "*";
            sol[i] = aux;
        }
        return sol;
    }

    /*
    Problem 16
    Description:
    Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one
    of the arrays.
    Given two arrays a and b, check whether they are similar.

    Example:
    For a = [1, 2, 3] and b = [1, 2, 3], the output should be solution(a, b) = true.
    The arrays are equal, no need to swap any elements.
    For a = [1, 2, 3] and b = [2, 1, 3], the output should be solution(a, b) = true.
    We can obtain b from a by swapping 2 and 1 in b.
    For a = [1, 2, 2] and b = [2, 1, 1], the output should be solution(a, b) = false.
    Any swap of any two elements either in a or in b won't make a and b equal.
    */

    public static boolean areSimilar(int[] a, int[] b) {
        if (a.length == 1 && b.length == 1) return a[0] == b[0];
        int rs = 0, s1 = 1, s2 = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                rs++;
            s1 *= a[i];
            s2 *= b[i];
        }
        return rs <= 2 && s1 == s2;
    }

    /*
    Problem 17
    Description:
    You are given an array of integers. On each move you are allowed to increase exactly one of its element by one.
    Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

    Example:
    For inputArray = [1, 1, 1], the output should be solution(inputArray) = 3.
    */

    public static int arrayChange(int[] inputArray) {

        if (inputArray.length == 1) return 0;
        int mov = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] >= inputArray[i + 1]) {
                int aux = inputArray[i + 1];
                mov += (-1 * aux) + inputArray[i] + 1;
                inputArray[i + 1] = inputArray[i] + 1;
            }
        }
        return mov;
    }

    /*
    Problem 18
    Description:
    Given a string, find out if its characters can be rearranged to form a palindrome.

    Example:
    For inputString = "aabb", the output should be solution(inputString) = true.
    We can rearrange "aabb" to make "abba", which is a palindrome.
    */

    public static boolean palindromeRearranging(String inputString) {
        if (inputString.length() == 1) return true;

        Set<Character> chars = new HashSet<Character>();

        for (int i = 0; i < inputString.length();  ++i) {
            char c = inputString.charAt(i);
            if (chars.contains(c)) {
                chars.remove(c);
            }
            else {
                chars.add(c);
            }
        }
        return chars.size() <= 1 ? true : false;
    }

}
