package codesignal.intro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LandOfLogic {

    /*
    Problem 52
    Description:
    Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

    Example:
    For text = "Ready, steady, go!", the output should be solution(text) = "steady".
    */

    public static String longestWord(String text) {
        String maxWord = "";
        int maxLength = maxWord.length();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int auxChar = text.charAt(i);
            if ((auxChar >= 97 && auxChar <= 122) || (auxChar >= 65 && auxChar <= 90)) {
                st.append(text.charAt(i));
                System.out.println(text.charAt(i));
            } else {
                if (st.toString().length() > maxLength) {
                    System.out.println(maxWord);
                    maxWord = st.toString();
                    maxLength = maxWord.length();
                }
                st = new StringBuilder();
            }
        }
        if (st.length() > maxLength) {
            maxWord = st.toString();
        }
        return maxWord.isEmpty()? text: maxWord;
    }

    /*
    Problem 53
    Description:
    Check if the given string is a correct time representation of the 24-hour clock.

    Example:
    For time = "13:58", the output should be solution(time) = true;
    For time = "25:51", the output should be solution(time) = false;
    For time = "02:76", the output should be solution(time) = false.
    */

    public static boolean validTime(String time) {
        if (time.length() > 5) return false;
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        return (hours >= 0 && hours < 24) && (minutes > 0 && minutes < 60);
    }

    /*
    Problem 54
    Description:
    CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting
    string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going
    to automate it, so he needs a program that sums up all the numbers which appear in the given input.
    Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

    Example:
    For inputString = "2 apples, 12 oranges", the output should be solution(inputString) = 14.
    */

    public static int sumpUp(String inputString) {
        int total = 0;
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber.append(currentChar);
            } else if (currentNumber.length() > 0) {
                total += Integer.parseInt(currentNumber.toString());
                currentNumber.setLength(0);
            }
        }
        if (currentNumber.length() > 0) {
            total += Integer.parseInt(currentNumber.toString());
        }
        return total;
    }

    /*
    Problem 55
    Description:
    Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

    Example:
    For
    matrix = [[1, 2, 1],
              [2, 2, 2],
              [2, 2, 2],
              [1, 2, 3],
              [2, 2, 1]]
    the output should be
    solution(matrix) = 6.
    Here are all 6 different 2 × 2 squares:
    1 2     2 1     2 2     2 2     2 2     2 3
    2 2     2 2     2 2     1 2     2 3     2 1
    */

    public int differentSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<String> total = new HashSet<>();
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int [][] m2x2 = new int [2][2];
                m2x2[0][0] = matrix[i][j];
                m2x2[0][1] = matrix[i][j + 1];
                m2x2[1][0] = matrix[i + 1][j];
                m2x2[1][1] = matrix[i + 1][j + 1];

                String code = generateCodeMatrix(m2x2);
                total.add(code);

            }
        }

        return total.size();

    }
    String generateCodeMatrix (int[][] matrix) {
        StringBuilder st = new StringBuilder();
        st.append("00" + matrix[0][0] + "X");
        st.append("01" + matrix[0][1] + "X");
        st.append("10" + matrix[1][0] + "X");
        st.append("11" + matrix[1][1]);
        return st.toString();
    }

    /*
    Problem 56
    Description:
    Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is
    equal to product. If there is no such integer, return -1 instead.

    Example:
    For product = 12, the output should be solution(product) = 26;
    For product = 19, the output should be solution(product) = -1.

    Solution:
    Solution by https://app.codesignal.com/profile/ben_w6
    */

    public static int digitsProduct(int product) {
        if (product == 0)
            return 10;
        if (product < 10)
            return product;
        String  r = "";
        for (int d = 9; d > 1; d--)
            for (; product % d == 0; product /= d)
                r = d + r;
        return product == 1 ? Integer.parseInt(r) : -1;
    }

    /*
    Problem 57
    Description:
    You are given an array of strings names representing filenames. The array is sorted in order of file creation,
    such that names[i] represents the name of a file created before names[i+1] and after names[i-1]
    (assume 0-based indexing). Because all files must have unique names, files created later with the same name as a
    file created earlier should have an additional (k) suffix in their names, where k is the smallest positive integer
    (starting from 1) that does not appear in previous file names.
    Your task is to iterate through all elements of names (from left to right) and update all filenames based on the
    above. Return an array of proper filenames.

    Example:
    - For names = ["doc", "doc", "image", "doc(1)", "doc"],
    the output should be solution(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].
    Since names[0] = "doc" and names[1] = "doc", update names[1] = "doc(1)"
    Since names[1] = "doc(1)" and names[3] = "doc(1)", update names[3] = "doc(1)(1)"
    Since names[0] = "doc", names[1] = "doc(1)", and names[4] = "doc", update names[4] = "doc(2)"
    */

    public static String[] fileNaming(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
            } else {
                String originalName = names[i];
                int count = map.get(names[i]);
                while (map.containsKey(originalName + "(" + count + ")")) {
                    count++;
                }
                names[i] = originalName + "(" + count + ")";
                map.put(names[i], 1);
                map.put(originalName, count + 1);
            }
        }
        return names;
    }

    /*
    Problem 58
    You are taking part in an Escape Room challenge designed specifically for programmers. In your efforts to find a
    clue, you've found a binary code written on the wall behind a vase, and realized that it must be an encrypted
    message. After some thought, your first guess is that each consecutive 8 bits of the code stand for the character
    with the corresponding extended ASCII code.
    Assuming that your hunch is correct, decode the message.

    Example:

    - For code = "010010000110010101101100011011000110111100100001", the output should be solution(code) = "Hello!".
    The first 8 characters of the code are 01001000, which is 72 in the binary numeral system. 72 stands for H in the
    ASCII-table, so the first letter is H.
    Other letters can be obtained in the same manner.
    */

    public static String messageFromBinaryCode(String code) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < code.length() ; i +=8) {
            byte byteCode = (byte)  Integer.parseInt(code.substring(i, i + 8), 2);
            char aux = (char) byteCode;
            st.append(aux);

        }
        return st.toString();
    }

    /*
    Problem 59
    Description:
    Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order, starting from
    top-left and in clockwise direction.

    Example:
    For n = 3, the output should be
    solution(n) = [[1, 2, 3],
                   [8, 9, 4],
                   [7, 6, 5]]

    Solution:
    Solution by https://app.codesignal.com/profile/62734856293
    */
    int[][] spiralNumbers(int n) {
        int[][] array = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;
        for (int counter = 1; counter <= n * n; )
        {
            for (int x = left; x <= right; x++){
                array[top][x] = counter++;
            }
            top++;
            for (int y = top; y <= down; y++){
                array[y][right] = counter++;
            }
            right--;
            for (int x = right; x >= left; x--){
                array[down][x] = counter++;
            }
            down--;
            for (int y = down; y >= top; y--){
                array[y][left] = counter++;
            }
            left++;
        }
        return array;
    }

    /*
    Problem 60
    Description:
    Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each
    row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.
    This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

    Example:
    - For
    grid = [[1, 3, 2, 5, 4, 6, 9, 8, 7],
            [4, 6, 5, 8, 7, 9, 3, 2, 1],
            [7, 9, 8, 2, 1, 3, 6, 5, 4],
            [9, 2, 1, 4, 3, 5, 8, 7, 6],
            [3, 5, 4, 7, 6, 8, 2, 1, 9],
            [6, 8, 7, 1, 9, 2, 5, 4, 3],
            [5, 7, 6, 9, 8, 1, 4, 3, 2],
            [2, 4, 3, 6, 5, 7, 1, 9, 8],
            [8, 1, 9, 3, 2, 4, 7, 6, 5]]
    the output should be solution(grid) = true;
    - For
    grid = [[8, 3, 6, 5, 3, 6, 7, 2, 9],
            [4, 2, 5, 8, 7, 9, 3, 8, 1],
            [7, 9, 1, 2, 1, 4, 6, 5, 4],
            [9, 2, 1, 4, 3, 5, 8, 7, 6],
            [3, 5, 4, 7, 6, 8, 2, 1, 9],
            [6, 8, 7, 1, 9, 2, 5, 4, 3],
            [5, 7, 6, 9, 8, 1, 4, 3, 2],
            [2, 4, 3, 6, 5, 7, 1, 9, 8],
            [8, 1, 9, 3, 2, 4, 7, 6, 5]]
    the output should be solution(grid) = false.
    The output should be false: each of the nine 3 × 3 sub-grids should contain all of the digits from 1 to 9.
    These examples are represented on the image below.
    */
    public static boolean sudoku(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int aux = grid[i][j];
                // Check rows
                for (int k = 0; k < col; k++) {
                    if (k != j && aux == grid[i][k]) {
                        return false;
                    }
                }
                // Check columns
                for (int k = 0; k < row; k++) {
                    if (k != i && aux == grid[k][j]) {
                        return false;
                    }
                }
                // Check subgrids
                int subRow = (i / 3) * 3;
                int subCol = (j / 3) * 3;
                for (int k = subRow; k < subRow + 3; k++) {
                    for (int l = subCol; l < subCol + 3; l++) {
                        if (k != i && l != j && aux == grid[k][l]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
