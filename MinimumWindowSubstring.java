import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) 
    {
		// write code here
        int[] bitChar = new int[128];

        for (Character ch : t.toCharArray()) bitChar[ch]++;

        int start = 0, end = 0, minLen = Integer.MAX_VALUE, count = t.length();
        int minStart = 0;

        while (end < s.length())
        {
            char ch = s.charAt(end);

            if (bitChar[ch] > 0) count--;
            bitChar[ch]--;

            end++;

            while (count == 0)
            {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }

                char ch1 = s.charAt(start);
                bitChar[ch]++;

                if(bitChar[ch] > 0) count++;

                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, start + minLen);
    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}