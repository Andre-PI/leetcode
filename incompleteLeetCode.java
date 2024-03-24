/*20. Valid Parentheses
leetcode link: https://leetcode.com/problems/valid-parentheses/description/
Solved
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

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
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


Accepted
Solution
Runtime 1ms
Beats 98.66% of users with Java

Memory
41.43 MB 
Beats
46.12%
of users with Java
*/
class Solution {
 
    Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {
        for (char value : s.toCharArray()) {
            if (value == '(' || value == '[' || value == '{') {
                stack.push(value);
            } else {
                if (stack.empty() ||
                        value == ')' && stack.peek() != '(' ||
                        value == ']' && stack.peek() != '[' ||
                        value == '}' && stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
