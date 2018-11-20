package com.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        while (x > 0) {
            int lastDigit = x%10;
            int remaining = x/10;
            if (reverse - lastDigit >= Integer.MAX_VALUE/10)
                return 0;
            reverse = 10* reverse + lastDigit;
            x = remaining;
        }
        return isNegative? -1 * reverse: reverse;
    }
    
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();

        System.out.println(reverseInteger.reverse(123));
    }
}
