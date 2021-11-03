package algoexpert;

public class ContinuousStreamMedian {

    private int[] minHeapArray;
    private int minHeapCount, maxHeapCount;
    private int[] maxHeapArray;
    private final static int CAPACITY = 10;
    public ContinuousStreamMedian() {
        minHeapArray = new int[CAPACITY];
        maxHeapArray = new int[CAPACITY];
    }

    public void addNum(int num) {
        if(minHeapCount >= CAPACITY || maxHeapCount >= CAPACITY)
            return;

        if(minHeapCount == 0 && maxHeapCount == 0){
            maxHeapArray[maxHeapCount ++] = num;
            return;
        }

        if(num > maxHeapArray[0]){
            minHeapArray[minHeapCount ++] = num;
            bubbleUp(minHeapArray, minHeapCount);
        }else{
            maxHeapArray[maxHeapCount ++] = num;
            bubbleUp(maxHeapArray, maxHeapCount);
        }
        int lengthDiff = Math.abs(minHeapCount - maxHeapCount);
        if(lengthDiff >= 2){
            //rebalalnce both heap.
            boolean isMinHeapCountBigger = minHeapCount > maxHeapCount ? true : false;
            if(isMinHeapCountBigger){
                int item = remove(minHeapArray, minHeapCount);
                addNum(item, maxHeapArray, maxHeapCount);
            }else{
                int item = remove(maxHeapArray, maxHeapCount);
                addNum(item, minHeapArray, minHeapCount);
            }
        }
    }

    private void addNum(int item, int[] heap, int count) {
        heap[count ++] = item;
        bubbleUp(heap, count);
    }

    private void bubbleUp(int[] heap, int count) {
        int index = count - 1;
        int parentIndex;
        while(index > 0 && heap[index] < heap[parentIndex(index)]){
            parentIndex = parentIndex(index);
            swap(heap, index, parentIndex);
            index = parentIndex;
        }
    }

    private void swap(int[] heap, int index, int parentIndex) {
        int temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    private int parentIndex(int index){
        return (index - 1)/2;
    }
    private void bubbleDown(int[] heap, int count) {
    }

    public int remove(int[] heap, int count){
        if(count < 0)
            throw new IllegalStateException();
        int item = heap[0];
        bubbleDown(heap, count);
        return item;
    }

    public double findMedian() {
        if(minHeapCount > maxHeapCount)
            return minHeapArray[0];
        else if(maxHeapCount > minHeapCount)
            return maxHeapArray[0];
        return (double)(minHeapArray[0] + maxHeapArray[0]) / 2;
    }

    public static void main(String[] args) {
        ContinuousStreamMedian obj = new ContinuousStreamMedian();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
