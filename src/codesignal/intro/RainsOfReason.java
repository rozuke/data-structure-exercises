package codesignal.intro;

public class RainsOfReason {
    /*
    Problem 25
    Description:
    Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

    Example
    For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
    solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
    */

    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }

    /*
    Problem 26
    Description:
    Check if all digits of the given integer are even.

    Example:

    For n = 248622, the output should be solution(n) = true;
    For n = 642386, the output should be solution(n) = false.
    */

    public static boolean evenDigitsOnly(int n) {
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            int aux = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (aux % 2 != 0) return false;
        }
        return true;
    }

    /*
    Problem 27
    Description:
    Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.
    Check if the given string is a correct variable name.

    Example:
    For name = "var_1__Int", the output should be solution(name) = true;
    For name = "qq-q", the output should be solution(name) = false;
    For name = "2w2", the output should be
    solution(name) = false.
    */

    public static boolean variableName(String name) {
        if (name.matches("^\\d.*")) return false;
        name = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            int ascii = name.charAt(i);
            if ( !((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57) || ascii == 95 ) ) return false;
        }
        return true;
    }

    /*
    Problem 28
    Description:
    Given a string, your task is to replace each of its characters by the next one in the English alphabet; i.e.replace
    a with b, replace b with c, etc (z would be replaced by a).

    Example:
    For inputString = "crazy", the output should be solution(inputString) = "dsbaz".
    */

    public static String alphabeticShift(String inputString) {
        StringBuilder newString = new StringBuilder();
        char newLetter = ' ';
        for (int i = 0; i < inputString.length(); i++) {
            int aux = inputString.charAt(i);
            if (aux == 122) {
                newLetter = (char) 97;
                newString.append(newLetter);
            } else {
                newLetter = (char) (aux + 1);
                newString.append(newLetter);
            }
        }
        return newString.toString();
    }

    /*
    Problem 29
    Description:
    Given two cells on the standard chess board, determine whether they have the same color or not.

    Example:
    For cell1 = "A1" and cell2 = "C3", the output should be solution(cell1, cell2) = true.
    https://codesignal.s3.amazonaws.com/uploads/1664318508/example1.png?raw=true
    For cell1 = "A1" and cell2 = "H3", the output should be solution(cell1, cell2) = false.
    https://codesignal.s3.amazonaws.com/uploads/1664318508/example2.png?raw=true
    */

    public static boolean solution(String cell1, String cell2) {
        if (cell1.equals(cell2)) return true;

        boolean firstCell = isCellBlack(cell1.toLowerCase());
        boolean secondCell = isCellBlack(cell2.toLowerCase());

        return !(firstCell ^ secondCell);

    }
    boolean isCellBlack(String cell) {
        int letter = (char) cell.charAt(0);
        int number = Integer.parseInt(String.valueOf(cell.charAt(1)));
        return ((letter % 2 != 0) && (number % 2 != 0)) || ((letter % 2 == 0) && (number % 2 == 0));
    }
}
