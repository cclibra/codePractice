package leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 */

public class leetcode20_isValidParentheses {
    public boolean isValid(String s){
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        for(Character cha:input){
            if(!map.containsKey(cha)){
                stack.push(cha);
            }
            else{
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()==map.get(cha)){
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        leetcode20_isValidParentheses test = new leetcode20_isValidParentheses();
        System.out.println(test.isValid("((()(())))"));
    }

}
