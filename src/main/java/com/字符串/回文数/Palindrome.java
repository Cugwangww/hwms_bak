package 字符串.回文数;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author author
 * @description
 * @date 2024/3/13
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * https://leetcode.cn/problems/palindrome-number/
     *
     * 回文数
     * 如果一个整数向前和向后读都相同，则它是一个 回文数。 例如，121 是回文数，而 123 不是。
     * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){
        if(x<0)return false;
        int div = 1;
        while (x/div>=10) div*=10;
        while(x>0){
            int left = x/div;
            int right = x % 10;
            if(left != right)return false;
            x = (x % div) /10 ;
            div/=100;
        }
        return true;
    }
}
