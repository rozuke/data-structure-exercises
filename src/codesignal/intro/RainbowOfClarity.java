package codesignal.intro;

public class RainbowOfClarity {
    /*
    Problem 48
    Description:
    Determine if the given character is a digit or not.

    Example:
    - For symbol = '0', the output should be solution(symbol) = true;
    - For symbol = '-', the output should be solution(symbol) = false.
    */
    public static boolean isDigit(char symbol) {
        return (int) symbol >= 48 && (int) symbol <= 57;
    }

    /*
    Problem 49
    Description:
    Given a string, return its encoding defined as follows:
    First, the string is divided into the least possible number of disjoint substrings consisting of identical
    characters for example, "aabbbc" is divided into ["aa", "bbb", "c"]
    Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating
    character for example, substring "bbb" is replaced by "3b"
    Finally, all the new strings are concatenated together in the same order and a new string is returned.

    Example:
    For s = "aabbbc", the output should be solution(s) = "2a3bc".
    */

    public static String lineEncoding(String s) {
        StringBuilder stringEncoding = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char aux = s.charAt(i);
            int count = 0;
            while (i < s.length() && aux == s.charAt(i)) {
                count++;
                i++;
            }
            if (count > 1) {
                stringEncoding.append(count);
            }
            stringEncoding.append(aux);
        }
        return stringEncoding.toString();
    }

    /*
    Problem 50
    Description:
    Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.
    The knight can move to a square that is two squares horizontally and one square vertically, or two squares
    vertically and one square horizontally away from it. The complete move therefore looks like the letter L.
    Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.
    https://codesignal.s3.amazonaws.com/uploads/1664394255/knight.jpg?raw=true

    Example:
    - For cell = "a1", the output should be solution(cell) = 2.
    https://codesignal.s3.amazonaws.com/uploads/1664394255/ex_1.jpg?raw=true
    - For cell = "c2", the output should be solution(cell) = 6.
    https://codesignal.s3.amazonaws.com/uploads/1664394255/ex_2.jpg?raw=true
    */

    public static int chessKnight(String cell) {
        int letter = cell.charAt(0);
        int number = cell.charAt(1);
        int total = 0;
        if (((letter - 2) >= 97 && (letter - 2) <= 104) && ((number + 1) >= 49 && (number + 1) <= 56)) total++;
        if (((letter - 2) >= 97 && (letter - 2) <= 104) && ((number - 1) >= 49 && (number - 1) <= 56)) total++;
        if (((letter + 2) >= 97 && (letter + 2) <= 104) && ((number + 1) >= 49 && (number + 1) <= 56)) total++;
        if (((letter + 2) >= 97 && (letter + 2) <= 104) && ((number - 1) >= 49 && (number - 1) <= 56)) total++;
        if (((letter + 1) >= 97 && (letter + 1) <= 104) && ((number + 2) >= 49 && (number + 2) <= 56)) total++;
        if (((letter - 1) >= 97 && (letter - 1) <= 104) && ((number + 2) >= 49 && (number + 2) <= 56)) total++;
        if (((letter + 1) >= 97 && (letter + 1) <= 104) && ((number - 2) >= 49 && (number - 2) <= 56)) total++;
        if (((letter - 1) >= 97 && (letter - 1) <= 104) && ((number - 2) >= 49 && (number - 2) <= 56)) total++;
        return total;
    }

    /*
    Problem 51
    Description:
    Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

    Example:
    - For n = 152, the output should be solution(n) = 52;
    - For n = 1001, the output should be solution(n) = 101.
    */
    public static int solution(int n) {
        StringBuilder number = new StringBuilder(String.valueOf(n));
        int [] numbers = new int [number.toString().length()];
        int maxNumber = Integer.MIN_VALUE;
        for(int i = 0; i < number.length(); i++ ) {
            number.deleteCharAt(i);
            numbers[i] = Integer.parseInt(number.toString());
            number = new StringBuilder(String.valueOf(n));;
        }
        for(int j = 0; j < numbers.length; j++) {
            if (numbers[j] > maxNumber) {
                maxNumber = numbers[j];
            }
        }
        return maxNumber;
    }
}
