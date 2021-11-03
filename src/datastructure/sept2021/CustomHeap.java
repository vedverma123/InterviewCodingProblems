package datastructure.sept2021;

//Max Heap
public class CustomHeap {

    private int[] items;
    private int count;

    public static void main(String[] args) {
        CustomHeap obj = new CustomHeap();
        obj.insert(5);
        obj.insert(10);
        obj.insert(3);
        obj.insert(4);
        obj.insert(12);
        obj.insert(7);
    }

    public CustomHeap(){
        items = new int[10];
    }

    public void insert(int item){
        items[count ++] = item;
        bubbleUp();
    }

    public int remove(){
        if(count == 0)
            throw new IllegalStateException();
        int item = items[0];
        items[0] = items[count - 1];
        bubbleDown();
        return item;
    }

    private void bubbleUp() {
        int index = count - 1;
        while(index > 0 ){
            int parentIndex = parentIndex(index);
            if(items[index] > items[parentIndex]){
                swap(index, parentIndex);
            }
            index = parentIndex;
        }
    }

    private void bubbleDown() {
        int index = 0;
        while(index > count){
            int greaterChildIdx = greaterChildIdx(index);
            if(items[index] > items[greaterChildIdx]){
                swap(index, greaterChildIdx);
                index = greaterChildIdx;
            }
        }
    }

    public int greaterChildIdx(int index){
        return getLeftChild(index) > getRightChild(index) ? getLeftChildIdx(index) : getRightChildIdx(index);
    }

    private void swap(int index, int parentIndex) {
        int temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;
    }

    private int parentIndex(int index) {
        return (index - 1 ) / 2;
    }

    private int getLeftChildIdx(int index){
        return 2*index + 1;
    }

    private int getRightChildIdx(int index){
        return 2*index + 2;
    }

    private int getLeftChild(int index){
        return items[getLeftChildIdx(index)];
    }

    private int getRightChild(int index){
        return items[getRightChildIdx(index)];
    }

}
