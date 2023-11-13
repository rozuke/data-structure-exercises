package codesignal.intro;

public class JourneyBegins {

    /*
    Problem 1
    Description:
    Write a function that returns the sum of two numbers.

    Example:
    For param1 = 1 and param2 = 2, the output should be
    solution(param1, param2) = 3.
    */
    public int add(int param1, int param2) {
        return param1 + param2;

    }

    /*
    Problem 2:
    Description:
    Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100,
    the second - from the year 101 up to and including the year 200, etc.

    Example:
    For year = 1905, the output should be solution(year) = 20;
    For year = 1700, the output should be solution(year) = 17.
    */
    public int solution(int year) {
        if (year % 100 == 0 ) return year /100;
        return (year / 100) + 1;
    }

    /*
    Problem 3
    Description:
    Given the string, check if it is a palindrome.

    Example:
    For inputString = "aabaa", the output should be solution(inputString) = true;
    For inputString = "abac", the output should be solution(inputString) = false;
    For inputString = "a", the output should be solution(inputString) = true.
    */
    public boolean checkPalindrome(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i-- ) {
            reverse = reverse + s.charAt(i);
        }

        return s.equals(reverse);

    }



}
