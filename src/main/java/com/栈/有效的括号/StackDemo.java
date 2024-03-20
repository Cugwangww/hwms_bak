package 栈.有效的括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/13
 */
public class StackDemo {

    public static void main(String[] args) {
        System.out.println(isStack("({)"));
    }

    public static boolean isStack(String s){
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new LinkedList<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char charat =s.charAt(i);
            if(map.containsKey(charat)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(charat))){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(charat);
            }
        }
        return stack.isEmpty();
    }
}
