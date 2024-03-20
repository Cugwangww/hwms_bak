package 栈.有效的括号;

import com.sun.javafx.collections.MappingChange;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/12
 */
public class IsValid {

    /**
     *
     * https://leetcode.cn/problems/valid-parentheses/description/
     *
     * 给定一个只包括 ‘(’，‘)’，‘{’，‘}’，‘[’，‘]’ 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
     *
     * 遍历将元素压入栈底，如果有对应的右括号 从栈底取出元素弹出匹配的上的话
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]"));
    }

}
