package leetcode.Stack;

import java.util.Stack;

/**
题目描述
请设计一个栈结构，支持 push、pop、top以及getMin操作，且每个操作的时间复杂度都是 O(1)。

push(x) – 向栈中压入元素 xx；
pop() – 删除栈顶元素；
top() – 返回栈顶元素；
getMin() – 返回栈中的最小元素；
 */
public class leetcode155_MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public leetcode155_MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
/**压入数据规则，当前数据为x，先压栈到stackData，然后判断stackMin是否为空。
  如果为空，直接压栈；
  如果非空，判断x值与stackMin栈顶值的大小，x小于等于栈顶值时，才将其压栈，否则不操作
 */
    public void push(int x) {
        stackData.push(x);
        if(stackMin.empty()){
            stackMin.push(x);
        }
        else if(x<=stackMin.peek()){
            stackMin.push(x);
        }
    }
/**弹出数据规则，先从stackData中弹出数据，设为value，判断value与stackMin栈顶值的大小
根据压栈规则可知，value只可能大于等于stackMin栈顶值
如果该值等于栈顶值，则stackMin弹出栈顶元素，否则不变
 */
    public int pop() {
        if(stackData.empty())
            throw new RuntimeException("Stack is empty");
        int value = stackData.pop();
        if(value == stackMin.peek())
            stackMin.pop();
        return value;
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        if(stackMin.empty())
            throw new RuntimeException("Stack is empty");
        return stackMin.peek();
    }
}
