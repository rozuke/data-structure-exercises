package leetcode.top100liked.easy;


import com.sun.source.tree.Tree;

import java.util.*;

public class EasyLevel {
    /*
    1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    */
    public int[] mysolutionTwoSum(int [] nums, int target) {
            int [] res = new int [2];
            for (int i = 0; i < nums.length ; i++){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target){
                        res[0] = i;
                        res[1] = j;

                    }
                    continue;
                }
                continue;
            }
            return res;
    }

    /*
    13. Roman to Integer
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is
    simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
    IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is
    used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    Example 1:
    Input: s = "III"
    Output: 3
    Explanation: III = 3.
    */
    public int romanToInt(String s) {
        Map<String, Integer> romanNumbers= new HashMap<>();
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += romanNumbers.get(String.valueOf(s.charAt(i)));
        }


        return result;

    }

    /*
    14. Longest Common Prefix

    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    */

    public String longestCommonPrefix(String[] sts) {
        String prefix = sts[0];
        for (int i = 1; i < sts.length; i++) {
            while (sts[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /*
    20. Valid Parentheses

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
    valid. An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false
     */
//  This is the first intent, this code passed  87/97 test cases :,v
    public boolean isValid1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 0);
        map.put(")", 0);
        map.put("[", 0);
        map.put("]", 0);
        map.put("{", 0);
        map.put("}", 0);

        for (int i = 0; i < s.length(); i++) {
            switch (String.valueOf(s.charAt(i))) {
                case "(" -> map.put("(", map.get("(") + 1);
                case ")" -> map.put(")", map.get(")") + 1);
                case "[" -> map.put("[", map.get("[") + 1);
                case "]" -> map.put("]", map.get("]") + 1);
                case "{" -> map.put("{", map.get("{") + 1);
                case "}" -> map.put("}", map.get("}") + 1);
            }
        }
        return (map.get("(") == map.get(")")) && (map.get("[") == map.get("]")) && (map.get("{") == map.get("}"));
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '}') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


    /*
    21. Merge Two Sorted Lists

    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = returnNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                returnNode.next = list1;
                list1 = list1.next;
            } else {
                returnNode.next = list2;
                list2 = list2.next;
            }

        }
        if (list1 == null) {
            returnNode.next = list2;
        }
        if (list2 == null) {
            returnNode.next = list1;
        }
        return headNode.next;
    }
    public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    /*
    35. Search Insert Position
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
    return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4
    */

    public static int searchInsert(int[] array, int target) {

        int left = 0;
        int right = array.length -1 ;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid -1;
            } else {
                return mid;
            }
        }

        return left;

    }

    /*
    70. Climbing Stairs

    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
    */
    public int climbStairs(int n) {

        if (n == 1 || n == 2) return n;

        int nFib = fib(n);


        return nFib;
    }

    public int fib(int n ) {
        int n1 = 1;
        int n2 = 2;


        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
    /*
    94. Binary Tree Inorder Traversal

    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example 1:
        1
         \
          2
         /
        3
    Input: root = [1,null,2,3]
    Output: [1,3,2]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [1]
    Output: [1]`
     */

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if ( root == null ) return list;
        return inorderTraversal(root,list);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);

            list.add(root.val);

            inorderTraversal(root.right, list);
        }
        return list;
    }

    /*
    101. Symmetric Tree

    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Example 1:

            1
           / \
          2   2
         / \ / \
        3  4 3  4
    Input: root = [1,2,2,3,4,4,3]
    Output: true

    Example 2:

            1
           / \
          2   2
           \   \
           3    3

    Input: root = [1,2,2,null,3,null,3]
    Output: false
     */

    public boolean isSymmetric(TreeNode root) {
        return isSymetricTree(root, root);
    }
    public boolean isSymetricTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.val == node2.val && isSymetricTree(node1.left, node2.right) && isSymetricTree(node1.right, node2.left));
    }

    /*
    104. Maximum Depth of Binary Tree

    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
    leaf node.

    Example 1:

            3
           / \
          9  20
             / \
            15  7

    Input: root = [3,9,20,null,null,15,7]
    Output: 3

    Example 2:

    Input: root = [1,null,2]
    Output: 2
     */

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    118. Pascal's Triangle

    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
                            1
                           1 1
                          1 2 1
                         1 3 3 1
                        1 4 6 4 1
    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:

    Input: numRows = 1
    Output: [[1]]
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(Arrays.asList(1));
        if (numRows == 1 ) return pascalTriangle;
        pascalTriangle.add(Arrays.asList(1,1));

        for(int i = 1; i <= numRows - 2; i++) {
            int auxCount = pascalTriangle.get(i).size();
            List<Integer> auxList = new ArrayList<>();
            auxList.add(1);
            for(int j = 0; j < auxCount - 1; j++) {
                int a = pascalTriangle.get(i).get(j);
                int b = pascalTriangle.get(i).get(j + 1);
                int c = a + b;
                auxList.add(c);
            }
            auxList.add(1);
            pascalTriangle.add(auxList);
        }

        return pascalTriangle;
    }

    /*
    121. Best Time to Buy and Sell Stock

    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
     */

    public int maxProfit(int[] prices) {
        int profit = 0;
        int bestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bestPrice) {
                bestPrice = prices[i];
            } else {
                int aux = prices[i] - bestPrice;
                profit = Math.max(aux, profit);

            }
        }
        return profit;
    }

    public static void main(String[] args) {

        EasyLevel test = new EasyLevel();
        test.maxProfit(new int [] {7, 1, 5, 3, 6, 4});

    }
}
