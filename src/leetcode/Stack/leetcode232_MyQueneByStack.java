package leetcode.Stack;

import java.util.Stack;

/**
 * 题目描述
 * 请用栈实现队列的如下四种操作：
 *
 * push(x) – 将x插入队尾；
 * pop() – 弹出队首元素；
 * peek() – 返回队首元素；
 * empty() – 返回队列是否为空；
 *
 * 思路：
 * 两个栈实现，一个栈stackPush负责压入，一个stackPop负责弹出，实现先入先出功能
 * 注意点：1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入；
 *        2.如果stackPop不为空，则不能向其中压入数据。
 *
 */
public class leetcode232_MyQueneByStack {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /** Initialize your data structure here. */
    public leetcode232_MyQueneByStack() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackPop.empty()){
            if (stackPush.empty())
                throw new RuntimeException("Stack is empty");
            else{
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackPush.empty()&&stackPop.empty())
            throw new RuntimeException("Stack is empty");
        else{
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPush.empty()&&stackPop.empty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
