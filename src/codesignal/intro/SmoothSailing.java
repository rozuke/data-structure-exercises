package codesignal.intro;

import java.util.ArrayList;

public class SmoothSailing {

    /*
    Problem 9
    Description:
    Given an array of strings, return another array containing all of its longest strings.

    Example:
    For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
    solution(inputArray) = ["aba", "vcd", "aba"].
    */

    public String[] allLongestStrings(String[] inputArray) {
        if (inputArray.length == 1) return inputArray;
        int maxLenght = inputArray[0].length();
        ArrayList<String> outputArray = new ArrayList<>();
        outputArray.add(inputArray[0]);
        for(int i = 1; i < inputArray.length; i++) {
            if (maxLenght < inputArray[i].length()) {
                maxLenght = inputArray[i].length();
                outputArray.clear();
                outputArray.add(inputArray[i]);
            } else if (maxLenght == inputArray[i].length()) {
                outputArray.add(inputArray[i]);
            }
        }
        return outputArray.toArray(new String[0]);
    }

    /*
    Problem 10
    Description:
    Given two strings, find the number of common characters between them.

    Example:
    For s1 = "aabcc" and s2 = "adcaa", the output should be solution(s1, s2) = 3.
    Strings have 3 common characters - 2 "a"s and 1 "c".
    */

    public int commonCharacterCount(String s1, String s2) {
        if ( s1.length() == 1 && s2.length() == 2 && s1 == s2) return 1;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s2.contains(Character.toString(s1.charAt(i))));
            System.out.println(s1.charAt(i));
            if (s2.contains(Character.toString(s1.charAt(i)))) {
                count++;
                s2 = s2.replaceFirst(Character.toString(s1.charAt(i)), "");
                System.out.println("s2 " + s2);
            }
        }
        return count;
    }

    /*
    Problem 11
    Description:
    Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the
    first half of the digits is equal to the sum of the second half.
    Given a ticket number n, determine if it's lucky or not.

    Example:
    For n = 1230, the output should be solution(n) = true;
    For n = 239017, the output should be solution(n) = false.
    */
    public boolean isLucky(int n) {
        String number = Integer.toString(n);
        if ( number.length() % 2 != 0) return false;
        int right = 0;
        int left = 0;
        for (int i = 0; i < number.length(); i++) {
            int aux = Integer.parseInt(Character.toString(number.charAt(i)));
            if (i < number.length()/2) {
                left+= aux;
            } else {
                right+= aux;
            }
        }
        return right == left;
    }

    /*
    Problem 12
    Description:
    Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to
    rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

    Example:
    For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
    solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
    */

    public int[] sortByHeight(int[] a) {
        if (a.length == 1) return a;
        int aux = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == -1) continue;
            for (int j = i; j < a.length - 1; j++) {
                if (a[i] > a[j + 1] && a[j + 1] != -1) {
                    aux = a[i];
                    a[i] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
        return a;
    }

    /*
    Problem 13
    Description:
    Write a function that reverses characters in (possibly nested) parentheses in the input string.
    Input strings will always be well-formed with matching ()s.

    Example:
    For inputString = "(bar)", the output should be solution(inputString) = "rab";
    For inputString = "foo(bar)baz", the output should be solution(inputString) = "foorabbaz";
    For inputString = "foo(bar)baz(blim)", the output should be solution(inputString) = "foorabbazmilb";
    For inputString = "foo(bar(baz))blim", the output should be solution(inputString) = "foobazrabblim".
    Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
    */

    public String reverseInParentheses(String inputString) {
        if (inputString.indexOf('(') == -1) return inputString;
        StringBuilder str = new StringBuilder(inputString);
        int start, end;
        while(str.indexOf("(") != -1){
            start = str.lastIndexOf("(");
            end = str.indexOf(")", start);
            str.replace(start, end + 1, new StringBuilder(str.substring(start+1, end)).reverse().toString());
        }
        return str.toString();

    }





}
