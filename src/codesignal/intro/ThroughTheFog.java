package codesignal.intro;

public class ThroughTheFog {
    /*
    Problem 30
    Description:
    Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between
    any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).
    Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

    Example:
    For n = 10 and firstNumber = 2, the output should be solution(n, firstNumber) = 7.
    https://codesignal.s3.amazonaws.com/uploads/1664318506/example.png?raw=true
    */

    public static int circleOfNumbers(int n, int firstNumber) {
        int result = firstNumber + (n/2);
        if (result > n - 1) {
            return result - n;
        }
        return result;
    }

    /*
    Problem 31
    Description:
    You have deposited a specific amount of money into your bank account. Each year your balance increases at the same
    growth rate. With the assumption that you don't make any additional deposits, find out how long it would take for
    your balance to pass a specific threshold.

    Example:
    For deposit = 100, rate = 20, and threshold = 170, the output should be solution(deposit, rate, threshold) = 3.
    Each year the amount of money in your account increases by 20%. So throughout the years, your balance would be:
    year 0: 100;
    year 1: 120;
    year 2: 144;
    year 3: 172.8.
    Thus, it will take 3 years for your balance to pass the threshold, so the answer is 3.
    */

    public static int depositProfit(int deposit, int rate, int threshold) {
        double percent = (double) rate / 100;
        double totalPass = deposit;
        int year = 0;
        while(totalPass < threshold) {
            totalPass = totalPass + totalPass * percent;
            year++;
        }
        return year;
    }

    /*
    Problem 32
    Description:
    Given a sorted array of integers a, your task is to determine which element of a is closest to all other
    values of a. In other words, find the element x in a, which minimizes the following sum:
    abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x) (where abs denotes the absolute value)
    If there are several possible answers, output the smallest one.

    Example:
    For a = [2, 4, 7], the output should be solution(a) = 4.
    for x = 2, the value will be abs(2 - 2) + abs(4 - 2) + abs(7 - 2) = 7.
    for x = 4, the value will be abs(2 - 4) + abs(4 - 4) + abs(7 - 4) = 5.
    for x = 7, the value will be abs(2 - 7) + abs(4 - 7) + abs(7 - 7) = 8.
    The lowest possible value is when x = 4, so the answer is 4.
    For a = [2, 3], the output should be solution(a) = 2.
    for x = 2, the value will be abs(2 - 2) + abs(3 - 2) = 1.
    for x = 3, the value will be abs(2 - 3) + abs(3 - 3) = 1.
    Because there is a tie, the smallest x between x = 2 and x = 3 is the answer.
    */

    public static int absoluteValuesSumMinimization(int[] a) {
        if (a.length == 1) return a[0];
        int result = Integer.MAX_VALUE;
        int pos = 0;
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            int aux = a[i];
            sum = 0;
            for(int j = 0; j < a.length; j++) {
                sum += Math.abs(aux - a[j]);
            }
            if (sum < result) {
                pos = a[i];
                result = sum;
            }
        }
        return pos;
    }

    /*
    Problem 33
    Description:
    Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements
    in such a way that each consecutive pair of strings differ by exactly one character. Return true if it's possible
    and false if not.
    Note: You're only rearranging the order of the strings, not the order of the letters within the strings!

    Example:
    For inputArray = ["aba", "bbb", "bab"], the output should be
    solution(inputArray) = false.
    There are 6 possible arrangements for these strings:
    ["aba", "bbb", "bab"]
    ["aba", "bab", "bbb"]
    ["bbb", "aba", "bab"]
    ["bbb", "bab", "aba"]
    ["bab", "bbb", "aba"]
    ["bab", "aba", "bbb"]
    None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is false.
    For inputArray = ["ab", "bb", "aa"], the output should be
    solution(inputArray) = true.
    It's possible to arrange these strings in a way that each consecutive pair of strings differ by 1 character
    (eg: "aa", "ab", "bb" or "bb", "ab", "aa"), so return true.

    Solution:
    Solution by https://app.codesignal.com/profile/dcoles
    */
    public boolean stringsRearrangement(String[] inputArray) {

        boolean[] used = new boolean[inputArray.length];
        findSequence(inputArray, null, used, 0);
        return success;
    }
    boolean success = false;

    private void findSequence(String[] a, String prev, boolean[] used, int n) {
        if (n == a.length) {
            success = true;
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!used[i] && (prev == null || differByOneChar(prev, a[i]))) {
                used[i] = true;
                findSequence(a, a[i], used, n+1);
                used[i] = false;
            }
        }
    }

    private boolean differByOneChar(String str1, String str2) {
        int countDiff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                countDiff++;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return countDiff == 1;
    }
}
