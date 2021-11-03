package datastructure.sept2021;

import java.util.Arrays;

public class Heapify {

    public int[] heapify(int[] items){
        if (items == null || items.length == 0)
            throw new IllegalStateException();
        int lastParentIdx = items.length / 2 - 1;
        for(int currentIdx = lastParentIdx; currentIdx >=0; currentIdx --){
            bubbleDown(currentIdx, items);
        }
        return items;
    }

    private void bubbleDown(int currentIdx, int[] items) {
        int greaterChildIdx = greaterChildIdx(currentIdx, items);
        if(items[currentIdx] < items[greaterChildIdx]){
            swap(currentIdx, greaterChildIdx, items);
            bubbleDown(greaterChildIdx, items);
        }
    }

    private void swap(int currentIdx, int greaterChildIdx, int[] items) {
        int temp = items[currentIdx];
        items[currentIdx] = items[greaterChildIdx];
        items[greaterChildIdx] = temp;
    }

    private int greaterChildIdx(int index, int[] items) {
        if(!hasLeftChild(index, items)){
            return index;
        }
        if(!hasRightChild(index, items)){
            return items[leftChildIdx(index)] > items[index] ? leftChildIdx(index) : index;
        }
        return items[leftChildIdx(index)] > items[rightChildIdx(index)] ? leftChildIdx(index) : rightChildIdx(index);
    }

    private boolean hasRightChild(int index, int[] items) {
        return rightChildIdx(index) < items.length;
    }

    private boolean hasLeftChild(int index, int[] items){
        return leftChildIdx(index) < items.length;
    }

    private int leftChildIdx(int index){
        return 2*index + 1;
    }

    private int rightChildIdx(int index){
        return 2*index + 2;
    }

    public static void main(String[] args) {
        Heapify obj = new Heapify();
        int[] items = {5,3,8,4,1,2};
        System.out.println(Arrays.toString(obj.heapify(items)));
    }

}
