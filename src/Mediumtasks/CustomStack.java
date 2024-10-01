package Mediumtasks;

import java.util.Stack;

class CustomStack {
    private int maxSize;
    private Stack<Integer> stack;
    private int[] inc;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Stack<>();
        this.inc = new int[maxSize];
    }
    public void push(int x) {
        if(stack.size() < maxSize){
            stack.push(x);
        }
    }
    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        int index = stack.size() - 1;
        int topValue = stack.pop() + inc[index];
        if(index > 1){
            inc[index - 1] += inc[index] ;
        }
        inc[index] = 0;
        return topValue;
    }
    public void inc(int k, int val){
        int limit = Math.min(k, stack.size());
        if(limit > 0){
            inc[limit- 1] += val;
        }
    }
}
