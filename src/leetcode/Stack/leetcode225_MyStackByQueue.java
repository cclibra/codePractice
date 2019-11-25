package leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 思路：可通过两个队列，一个为单个直接压入，另外一个为该次压入的倒序排列，然后两队列反复交替实现。
 *      这里使用单个队列，每次压入后，循环将队列首个值压入队尾，直至将本次压入的值上浮到队首，实现每次压入后倒序的调整。
 */
public class leetcode225_MyStackByQueue {
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public leetcode225_MyStackByQueue() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if(queue.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
