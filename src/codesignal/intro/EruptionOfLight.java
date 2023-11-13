package codesignal.intro;

public class EruptionOfLight {

    /*
    Problem 43
    Description:
    A string is said to be beautiful if each letter in the string appears at most as many times as the previous letter
    in the alphabet within the string; ie: b occurs no more times than a; c occurs no more times than b; etc.
    Note that letter a has no previous letter.
    Given a string, check whether it is beautiful.

    Example:
    - For inputString = "bbbaacdafe", the output should be solution(inputString) = true.
    This string contains 3 as, 3 bs, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter), so since there aren't any
    letters that appear more frequently than the previous letter, this string qualifies as beautiful.
    - For inputString = "aabbb", the output should be solution(inputString) = false.
    Since there are more bs than as, this string is not beautiful.
    - For inputString = "bbc", the output should be solution(inputString) = false.
    Although there are more bs than cs, this string is not beautiful because there are no as,
    so therefore there are more bs than as.

    Solution:
    Solution by https://app.codesignal.com/profile/thucnguyen
    */

    public static boolean isBeautifulString(String s) {
        int [] c = new int[26];
        for (int i : s.getBytes()) c[i-'a'] ++;
        for (int i = 1; i < 26; i ++)
            if (c[i] > c[i-1]) return false;
        return true;
    }

    /*
    Problem 44
    Description:
    An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"), an "@" symbol,
    then a domain part ("example.com").
    The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part,
    however, also allows a lot of different special characters. Here you can look at several examples of correct and
    incorrect email addresses.
    Given a valid email address, find its domain part.

    Example:
    - For address = "prettyandsimple@example.com", the output should be solution(address) = "example.com";
    - For address = "fully-qualified-domain@codesignal.com", the output should be solution(address) = "codesignal.com".
    */
    public static String findEmailDomain(String address) {
        int index = 0;
        for (int i = address.length() - 1; i >= 0 ; i--) {
            if (String.valueOf(address.charAt(i)).equals("@")) {
                index = i;
                break;
            }
        }
        return address.substring(index + 1, address.length());
    }

    /*
    Problem 45
    Description:
    Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial
    string to make it a palindrome.

    Example:
    For st = "abcdc", the output should be solution(st) = "abcdcba".
    */

    public static String buildPalindrome(String s) {
        if (s.length() == 1 ) return s;
        StringBuilder palindrome = new StringBuilder(s);
        palindrome.reverse();
        if (s.equals(palindrome.toString())) return s;
        String aux = String.valueOf(s.charAt(0));
        StringBuilder newPalindrome = new StringBuilder(s + aux);
        for(int i = 0; i < s.length() - 1; i++) {
            palindrome = new StringBuilder(newPalindrome).reverse();
            if (palindrome.toString().equals(newPalindrome.toString())) break;
            aux = (s.charAt(i + 1)) + aux;
            newPalindrome = new StringBuilder(s + aux);
        }
        return newPalindrome.toString();
    }

    /*
    Problem 46
    Description:
    Elections are in progress!
    Given an array of the numbers of votes given to each of the candidates so far, and an integer k equal to the number
    of voters who haven't cast their vote yet, find the number of candidates who still have a chance to win the
    election.
    The winner of the election must secure strictly more votes than any other candidate. If two or more candidates
    receive the same (maximum) number of votes, assume there is no winner at all.

    Example:
    For votes = [2, 3, 5, 2] and k = 3, the output should be solution(votes, k) = 2.
    The first candidate got 2 votes. Even if all of the remaining 3 candidates vote for him, he will still have only 5
    votes, i.e. the same number as the third candidate, so there will be no winner.
    The second candidate can win if all the remaining candidates vote for him (3 + 3 = 6 > 5).
    The third candidate can win even if none of the remaining candidates vote for him. For example, if each of the
    remaining voters cast their votes for each of his opponents, he will still be the winner (the votes array will
    thus be [3, 4, 5, 3]).
    The last candidate can't win no matter what (for the same reason as the first candidate).
    Thus, only 2 candidates can win (the second and the third), which is the answer.
    */

    public static int electionsWinner(int[] votes, int k) {
        if (votes.length == 1) return 0;
        int winner = 0;
        int maxVotes = votes[0];
        for (int i = 0; i < votes.length - 1; i++ ) {
            if (votes[i + 1] > maxVotes) {
                maxVotes = votes[i + 1];
            }
        }
        if (k == 0) {
            for(int v: votes) {
                if (v == maxVotes) winner++;
            }
            if (winner == 1) return winner;
        }
        winner = 0;
        for (int v: votes) {
            if(v + k > maxVotes) {
                winner++;
            }
        }
        return winner;
    }

    /*
    Problem 47
    Description:
    A media access control address (MAC address) is a unique identifier assigned to network interfaces for
    communications on the physical network segment.
    The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two
    hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).
    Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

    Example:
    - For inputString = "00-1B-63-84-45-E6", the output should be solution(inputString) = true;
    - For inputString = "Z1-1B-63-84-45-E6", the output should be solution(inputString) = false;
    - For inputString = "not a MAC-48 address", the output should be solution(inputString) = false.
    */

    public static boolean isMAC48Address(String inputString) {
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char aux = inputString.charAt(i);
            if (((i + 1) % 3 == 0 && ((int) aux == 45))) {
                count1++;
            }
            if((((int) aux) >= 48 && ((int) aux) <= 57 )) {
                System.out.println(aux);
                System.out.println((int) aux);
                count++;
            }
            if ((((int) aux) >= 65 && ((int) aux) <= 70 )) {
                System.out.println(aux);
                System.out.println((int) aux);
                count++;
            }
        }
        return count == 12 && count1==5;
    }
}
