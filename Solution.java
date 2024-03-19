/*
leetcode link: https://leetcode.com/problems/roman-to-integer/
13. Roman to Integer
Solved
Easy
Topics
Companies
Hint
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999]. */
import java.util.ArrayList;

public class Solution{
    private int[] romanToDecimal(String s){
        String[] value = new String[s.length()];
        int[] convertedList = new int[s.length()];
        value = s.split("");
        int num = 0;
        for(int i = 0;i < value.length;i++){
            if(value[i].equals("I")){
                num = 1;
            }else if(value[i].equals("V")){
                num = 5;
            }else if(value[i].equals("X")){
                num = 10;
            }else if(value[i].equals("L")){
                num = 50;
            }else if(value[i].equals("C")){
                num = 100;
            }else if(value[i].equals("D")){
                num = 500;
            }else if(value[i].equals("M")){
                num = 1000;
            }
            convertedList[i] = num;
        }
        return convertedList;
    }
    public int sumOfValues(String s){
        int[] convertedList = new int[s.length()];
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> readed = new ArrayList<>();
        convertedList = romanToDecimal(s);
        int totalSum = 0;
        int i = 0;
        while (i < convertedList.length -1) {
            if(convertedList[i] < convertedList[i + 1]){                
                index.add(convertedList[i + 1] - convertedList[i]);
                readed.add(i);
                readed.add(i + 1);
                if((i + 2) < convertedList.length){
                    i+=2;
                }else{
                    break;
                }
            }else{
                i++;
            }
        }      
        for(int j = 0;j < convertedList.length;j++){
            if (readed.contains(j)) {
                
                continue;
            }else{
                totalSum += convertedList[j];
            }
        }
    
        for(int k : index){
            totalSum += k;
        }

        return totalSum;                                                                      
    }
    public static void main(String[] args) {
        Solution app = new Solution();
        System.out.println(app.sumOfValues("LVIII"));
    }
}
