package othercode.Stack;

import java.util.Stack;

/**
 * 题目描述：
 * 在一个栈中元素的类型为整型，现在想将该栈从栈顶到栈底按从大到小的顺序排序，只许申请一个栈，
 * 除此之外，可以申请其他变量，但是不能申请额外的数据结构 。
 *
 * 思路：
 * 将要排序的栈记为stack，申请的辅助栈记为help。在stack上执行pop操作，弹出的元素记为cur。
 * *如果cur小于等于help的栈顶元素，将cur入help栈
 * *否则，将help的元素逐一弹出入stack栈，直到cur小于或等于help栈顶元素，再将cur压入help栈。
 * 一直执行上述操作，直到stack中的全部元素都压入到help,此时help从栈顶到栈底是从小到大的顺序，再将help中的元素逐一压入stack栈。
 */
public class sortStackByStack {
    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty()&&help.peek()<cur){
                stack.push(help.pop());
            }
            //只有help为空或者help栈顶元素小于cur时才会直接压到help，故上述循环的条件为该条件的补集
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
