package codesignal.intro;

public class DarkWilderness {

    /*
    Problem 38
    Description:
    Caring for a plant can be hard work, but since you tend to it regularly, you have a plant that grows consistently.
    Each day, its height increases by a fixed amount represented by the integer upSpeed. But due to lack of sunlight,
    the plant decreases in height every night, by an amount represented by downSpeed.
    Since you grew the plant from a seed, it started at height 0 initially. Given an integer desiredHeight, your task
    is to find how many days it'll take for the plant to reach this height.

    Example:

    For upSpeed = 100, downSpeed = 10, and desiredHeight = 910, the output should be
    solution(upSpeed, downSpeed, desiredHeight) = 10.
    #	Day	Night
    1	100	90
    2	190	180
    3	280	270
    4	370	360
    5	460	450
    6	550	540
    7	640	630
    8	730	720
    9	820	810
    10	910	900
    The plant first reaches a height of 910 on day 10.
    */

    public int solution(int upSpeed, int downSpeed, int desiredHeight) {
        int day = 0;
        int height = 0;
        while (height <= desiredHeight ) {
            height += upSpeed;
            if (height >= desiredHeight) {
                day++;
                break;
            }
            height -= downSpeed;
            day++;
        }
        return day ;
    }

    /*
    Problem 39
    Description:
    You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item
    weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming
    that your max weight capacity is maxW and you can't come back for the items later?
    Note that there are only two items and you can't bring more than one item of each type, i.e.
    you can't take two first items or two second items.

    Example:
    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 8, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 10.
    You can only carry the first item.
    For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 9, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 16.
    You're strong enough to take both of the items with you.
    For value1 = 5, weight1 = 3, value2 = 7, weight2 = 4, and maxW = 6, the output should be
    solution(value1, weight1, value2, weight2, maxW) = 7.
    You can't take both items, but you can take any of them.
    */

    public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 > maxW && weight2 > maxW) return 0;
        if ((weight1 + weight2) <= maxW) return value1 + value2;
        if ( value1 > value2 && weight1 <= maxW) return value1;
        else if ( value2 > value1 && weight2 <= maxW) return value2;
        else return value1;
    }

    /*
    Problem 40
    Description:
    Given a string, output its longest prefix which contains only digits.

    Example:
    For inputString = "123aa1", the output should be solution(inputString) = "123".

    Solution:
    Solution by https://app.codesignal.com/profile/pixelstorm
    */

    public static String solution(String inputString) {
        return inputString.replaceAll("^(\\d*).*","$1");
    }

    /*
    Problem 41
    Let's define digit degree of some positive integer as the number of times we need to replace this number with
    the sum of its digits until we get to a one digit number.
    Given an integer, find its digit degree.

    Example:

    - For n = 5, the output should be solution(n) = 0;
    - For n = 100, the output should be solution(n) = 1.
    1 + 0 + 0 = 1.
    - For n = 91, the output should be solution(n) = 2.
    9 + 1 = 10 -> 1 + 0 = 1.
    */
    public static int digitDegree(int n) {
        if (n < 10) return 0;
        int length = String.valueOf(n).length();
        int total = 0;
        while( length > 1) {
            int sum = 0;
            for(int i = 0; i < length; i++) {
                char aux = String.valueOf(n).charAt(i);
                System.out.println("aux : " + aux);
                sum += Character.getNumericValue(aux);
            }
            n = sum;
            total++;
            length = String.valueOf(sum).length();
        }
        return total;
    }

    /*
    Problem 42
    Description:
    Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop
    can capture the pawn in one move.
    The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the
    example below to see how it can move:
    https://codesignal.s3.amazonaws.com/uploads/1664394254/bishop.jpg?raw=true

    Example:
    - For bishop = "a1" and pawn = "c3", the output should be solution(bishop, pawn) = true.
    https://codesignal.s3.amazonaws.com/uploads/1664394255/ex1.jpg?raw=true
    - For bishop = "h1" and pawn = "h3", the output should be solution(bishop, pawn) = false.
    https://codesignal.s3.amazonaws.com/uploads/1664394255/ex2.jpg?raw=true

    Solution:
    Solution by https://app.codesignal.com/profile/ben_s24
    */

    public static boolean solution(String bishop, String pawn) {
        return(Math.abs(bishop.charAt(0) - pawn.charAt(0))) == (Math.abs(bishop.charAt(1) - pawn.charAt(1)));
    }



}
