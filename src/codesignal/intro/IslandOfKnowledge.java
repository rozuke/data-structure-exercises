package codesignal.intro;

import java.util.HashSet;
import java.util.Set;

public class IslandOfKnowledge {
    /*
    Problem 19
    Description:
    Call two arms equally strong if the heaviest weights they each are able to lift are equal.
    Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both
    the right and the left), and so are their weakest arms.
    Given your and your friend's arms' lifting capabilities find out if you two are equally strong.

    Example:
    For yourLeft = 10, yourRight = 15, friendsLeft = 15, and friendsRight = 10, the output should be
    solution(yourLeft, yourRight, friendsLeft, friendsRight) = true;
    For yourLeft = 15, yourRight = 10, friendsLeft = 15, and friendsRight = 10, the output should be
    solution(yourLeft, yourRight, friendsLeft, friendsRight) = true;
    For yourLeft = 15, yourRight = 10, friendsLeft = 15, and friendsRight = 9, the output should be
    solution(yourLeft, yourRight, friendsLeft, friendsRight) = false.
    */

    public static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        Set<Integer> set = new HashSet<>();
        set.add(yourLeft);
        set.add(yourRight);
        set.add(friendsLeft);
        set.add(friendsRight);
        return set.size() <= 2 && (yourLeft + yourRight) == (friendsLeft + friendsRight);
    }

    /*
    Problem 20
    Description:
    Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

    Example:
    For inputArray = [2, 4, 1, 0], the output should be solution(inputArray) = 3.
    */

    public static int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max = 0, aux = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            aux = Math.abs(inputArray[i] - inputArray[i + 1] );
            if (aux > max) {
                max = aux;
            }
        }
        return max;
    }

    /*
    Problem 21
    Description:
    An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a
    computer network that uses the Internet Protocol for communication. There are two versions of the Internet
    protocol, and thus two versions of addresses. One of them is the IPv4 address.
    Given a string, find out if it satisfies the IPv4 address naming rules.

    Example:
    For inputString = "172.16.254.1", the output should be solution(inputString) = true;
    For inputString = "172.316.254.1", the output should be solution(inputString) = false.
    316 is not in range [0, 255].
    For inputString = ".254.255.0", the output should be solution(inputString) = false.

    There is no first number.
    */

    public static boolean isIPv4Address(String inputString) {
        String[] octets = inputString.split("\\.");

        if (octets.length != 4) {
            return false;
        }
        for (String octet : octets) {
            try {
                if (octet.startsWith("0") && octet.length() > 1) return false;

                int value = Integer.parseInt(octet);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /*
    Problem 22
    Description:
    You are given an array of integers representing coordinates of obstacles situated on a straight line.
    Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps
    of the same length represented by some integer.
    Find the minimal length of the jump enough to avoid all the obstacles.

    Example:
    For inputArray = [5, 3, 6, 7, 9], the output should be solution(inputArray) = 4.
    Check out the image below for better understanding:
    https://codesignal.s3.amazonaws.com/uploads/1667239739797/example.png?raw=true
    */

    public static int avoidObstacles(int[] inputArray) {
        int max_value = Integer.MIN_VALUE;
        for (int obstacle : inputArray) {
            max_value = Math.max(max_value, obstacle);
        }
        int jump_length = 1;
        while (true) {
            boolean obstacleFound = false;
            for (int obstacle : inputArray) {
                if (obstacle % jump_length == 0) {
                    obstacleFound = true;
                    break;
                }
            }
            if (obstacleFound) {
                jump_length++;
            } else {
                return jump_length;
            }
        }
    }

    /*
    Problem 23
    Description:
    Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral!
    You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its
    content.
    The pixels in the input image are represented as integers. The algorithm distorts the input image in the
    following way: Every pixel x in the output image has a value equal to the average value of the pixel values from
    the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.
    Return the blurred image as an integer, with the fractions rounded down.

    Example:

    For
    image = [[1, 1, 1],
             [1, 7, 1],
             [1, 1, 1]]
    the output should be solution(image) = [[1]].
    To get the value of the middle pixel in the input 3 × 3
    square: (1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1. The border pixels are cropped from the
    final result.
    For
    image = [[7, 4, 0, 1],
             [5, 6, 2, 2],
             [6, 10, 7, 8],
             [1, 4, 2, 0]]
    the output should be
    solution(image) = [[5, 4],
                       [4, 4]]
    There are four 3 × 3 squares in the input image, so there should be four integers in the blurred output.
    To get the first value: (7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5. The other three integers are
    obtained the same way, then the surrounding integers are cropped from the final result
    */

    public static int[][] boxBlur(int[][] image) {
        int[][] result = new int[image.length-2][image[0].length-2];
        for (int i = 1; i < image.length-1; i++) {
            for (int j = 1; j < image[i].length-1; j++) {
                result[i-1][j-1] = avg(image, i, j);
            }
        }
        return result;
    }
    static int avg(int[][] image, int x, int y) {
        int sum = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                sum += image[i][j];
            }
        }
        return sum / 9;
    }

    /*
    Problem 24
    Description:
    In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have
    a number in it that indicates the total number of mines in the neighboring cells. Starting off with some
    arrangement of mines we want to create a Minesweeper game setup.

    Example
    For
    matrix = [[true, false, false],
              [false, true, false],
              [false, false, false]]
    the output should be
    solution(matrix) = [[1, 2, 1],
                        [2, 1, 1],
                        [1, 1, 1]]
    Check out the image below for better understanding:
    https://codesignal.s3.amazonaws.com/uploads/1667239798707/example.png?raw=true
    https://codesignal.s3.amazonaws.com/uploads/1667239798707/example.png?raw=true
    */

    int[][] minesweeper(boolean[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int neighbors = 0;

                for (int k = 0; k < 8; k++) {
                    int newRow = i + dx[k];
                    int newCol = j + dy[k];

                    if (isValidCell(matrix, newRow, newCol) && matrix[newRow][newCol]) {
                        neighbors++;
                    }
                }
                result[i][j] = neighbors;
            }
        }
        return result;
    }
    boolean isValidCell(boolean[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }




}
