package algoexpert;

//All operations are O(1) with space O(n).
public class MinMaxStackUsingArray {

    class MinMaxPair{
        int min,max;

        public MinMaxPair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    private int[] stack;
    private int current;
    private int currentMin = Integer.MAX_VALUE, currentMax = Integer.MIN_VALUE;
    private MinMaxPair[] minMax;

    public MinMaxStackUsingArray(int capacity){
        stack = new int[capacity];
        minMax = new MinMaxPair[capacity];
    }

    public void push(int num){
        if(stack.length - 1 < current)
            throw new IllegalArgumentException("Stack full");
        if(currentMin > num)
            currentMin = num;
        if(currentMax < num)
            currentMax = num;

        MinMaxPair pair = new MinMaxPair(currentMin, currentMax);
        minMax[current] = pair;
        stack[current ++] = num;
    }

    public int pop(){
        if(current <= 0)
            return -1;
        minMax[current - 1] = null;
        return stack[--current];
    }

    public int peek(){
        if(current == 0)
            return -1;
        return stack[current - 1];
    }

    public int max(){
        if(current == 0)
            return -1;
        return minMax[current - 1].max;
    }

    public int min(){
        if(current == 0)
            return -1;

        return minMax[current - 1].min;
    }

    public static void main(String[] args){
        MinMaxStackUsingArray obj = new MinMaxStackUsingArray(5);
        obj.pop();
        obj.push(7);
        obj.push(5);
        obj.push(2);
        System.out.println("Min -> " + obj.min());
        obj.push(9);
        obj.push(-2);
        System.out.println("Min -> " + obj.min());
        System.out.println("Peek ->"+obj.peek());
        System.out.println("Pop -> "+obj.pop());
        System.out.println("Max -> "+obj.max());
        System.out.println("Min -> " + obj.min());
    }
}
