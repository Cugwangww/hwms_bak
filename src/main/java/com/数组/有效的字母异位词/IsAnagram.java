package 数组.有效的字母异位词;

import java.util.Arrays;

/**
 * @author author
 * @description
 * @date 2024/3/14
 */
public class IsAnagram {

    /**
     *https://leetcode.cn/problems/valid-anagram/description/
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     * 输入: s = “anagram”, t = “nagaram”
     * 输出: true
     *
     * 转换成char  然后再排序
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ABC","abc"));
    }
}
