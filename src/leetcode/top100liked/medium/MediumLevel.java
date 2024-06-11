package leetcode.top100liked.medium;

import leetcode.top100liked.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class MediumLevel {

    /*
    2. Add Two Numbers

    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
    https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    /*
    3. Longest Substring Without Repeating Characters

    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and its index is greater than or equal to start
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Update start to the next position after the last occurrence
                start = map.get(currentChar) + 1;
            }

            // Update the last index of the current character
            map.put(currentChar, end);

            // Calculate the length of the current substring and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;

    }

    public static void main(String[] args) {
        MediumLevel test = new MediumLevel();

        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
