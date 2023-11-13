import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int [][] ar = {{1, 3, 2, 5, 4, 6, 9, 8, 7},
                {4, 6, 5, 8, 7, 9, 3, 2, 1},
                {7, 9, 8, 2, 1, 3, 6, 5, 4},
                {9, 2, 1, 4, 3, 5, 8, 7, 6},
                {3, 5, 4, 7, 6, 8, 2, 1, 9},
                {6, 8, 7, 1, 9, 2, 5, 4, 3},
                {5, 7, 6, 9, 8, 1, 4, 3, 2},
                {2, 4, 3, 6, 5, 7, 1, 9, 8},
                {8, 1, 9, 3, 2, 4, 7, 6, 5}};

        System.out.println(sudoku(ar));

    }

        static boolean sudoku (int [][] grid) {

            int row = grid.length;
            int colum = grid[0].length;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < colum; j++) {
                    int aux = grid[i][j];
                    //check rows
                    for(int k = 0; k < colum; k++) {
                        if (k != j) {
                            System.out.println("Check Row: " + aux);
                            if (aux == grid[i][k]) return false;
                        }
                    }

                    for(int k = 0; k < row; k++) {
                        if (k != j) {
                            if(aux == grid[k][j]) return false;
                        }
                    }

                    int subRow = 0;
                    int subCol = 0;
                    if (j > 2 && j < 6) subRow = 3;
                    if (j > 5 && j < 9) subRow = 6;

                    if (i > 2 && i < 6) subCol = 3;
                    if (i > 5 && i < 9) subCol = 6;

                    for (int k = subRow; k <  3; k++) {
                        for(int l = subCol; l < 3; l++) {

                            if (i != subRow && j != subCol) {
                                System.out.println("Check Subgrid: Aux" + aux);
                                System.out.println("Check Subgrid: SubAux" + grid[k][l]);
                                if (aux == grid[k][l]) return false;
                            }
                        }
                    }
                }
            }


            return true;
        }


    static int[][] spiralNumber(int n) {
        int[][] array = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;

        int iterator = 1;

        for (int counter = 1; counter <= n * n; iterator++ )
        {
            for (int x = left; x <= right; x++){
                System.out.println("[" + iterator + "]i" + " Array" + "[" + top + "][" + x + "] = " + counter);
                array[top][x] = counter++;

            }

            top++;
            System.out.println("TOP: " + top);

            for (int y = top; y <= down; y++){

                System.out.println("[" + iterator + "]i" + "Array" + "[" + y + "][" + right + "] = " + counter);
                array[y][right] = counter++;
            }
            right--;
            System.out.println("RIGHT: " + right);

            for (int x = right; x >= left; x--){
                System.out.println("[" + iterator + "]i" + "Array" + "[" + down + "][" + x + "] = " + counter);
                array[down][x] = counter++;
            }
            down--;
            System.out.println("DOWN: " + down);

            for (int y = down; y >= top; y--){
                System.out.println("[" + iterator + "]i" + "Array" + "[" + y + "][" + left + "] = " + counter);
                array[y][left] = counter++;
            }
            left++;
            System.out.println("LEFT: " + left);
        }

        return array;
    }


    public static String fromBynari(String code) {

            StringBuilder st = new StringBuilder();
            for(int i = 0; i < code.length() ; i +=8) {
                byte byteCode = (byte)  Integer.parseInt(code.substring(i, i + 8), 2);
                char aux = (char) byteCode;
                st.append(aux);

            }

            return st.toString();

    }



    public static String[] fileNaming(String[] names) {

        if (names.length == 1) return names;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {

            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
            } else {
                int count = map.get(names[i]);
                names[i] = names[i] + "(" + count + ")";
                map.put(names[i], count + 1);
            }
        }

        return names;

    }

    public static int deleteDigit(int n) {

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

    public static String solution(String s) {
        StringBuilder stringEncoding = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            char aux = s.charAt(i);
            System.out.println("i: primer while" + i);
            int count = 0;

            while(i < s.length() && aux == s.charAt(i)) {

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
}

