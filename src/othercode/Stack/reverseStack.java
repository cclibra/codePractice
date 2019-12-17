package othercode.Stack;

import java.util.Stack;

/**
 * 题目描述：
 * 仅用递归函数和栈操作逆序一个栈
 * 一个栈以此压入1，2，3，4，5，从栈顶到栈底分别为5，4，3，2，1。
 * 将这个栈转置后，从栈顶到栈底为1，2，3，4，5，也就是实现栈中元素的逆序。
 * 只能使用递归函数实现，不能使用其他数据结构。
 *
 * 思路：
 * 两个递归函数：
 * 1.将栈stack的栈底元素返回并移除
 * 2.逆序一个栈，调用递归函数1实现
 */
public class reverseStack {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        else{
            int last = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(last);
        }
    }
}
