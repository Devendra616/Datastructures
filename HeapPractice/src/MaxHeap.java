public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity){
        heap = new int[capacity];
    }

    public boolean isFull(){
        return size == heap.length;
    }

     public boolean isEmpty(){
        return size==0;
    }

     public int getParentPos(int index){
        return (index-1)/2;
     }

     public int getChildPos(int index, boolean isLeftChild){
        return 2*index+(isLeftChild?1:2);
     }

     public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is already full");
        }

        heap[size]=value;
        heapifyUp(size);
        size++;
     }

     //makes nodes above node index as proper heap
     private void heapifyUp(int index){

        int newVal = heap[index];
        while (index>0 && newVal> heap[getParentPos(index)]){
            heap[index]= heap[getParentPos(index)];
            index= getParentPos(index);
        }

        heap[index]=newVal;
     }

     private void heapifyBelow(int index,int lastHeapIndex){
        int childToSwap;
        int leftChild,rightChild;

        while(index <= lastHeapIndex){
            leftChild = getChildPos(index,true);
            rightChild= getChildPos(index,false);

            //if left child exist index is within heapsize
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild; //only left child exist, right child is outofbound
                }else { //both child exist
                    childToSwap = heap[leftChild] >heap[rightChild]?leftChild:rightChild;
                }

                if(heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap]= temp;
                }else {
                    break; //index is at its proper position
                }
                index = childToSwap;
            }else { //no children exist
                break;
            }
        }
     }

//     taking index where to delete
//    if we get value then have to linear search the array for index
//    position to delete so adding n complexity
     public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parentPos = getParentPos(index);
        int deletedValue = heap[index];
        int replacementValue = heap[size-1]; //last node
        heap[index] = replacementValue;

        if(index == 0|| heap[index]< heap[parentPos]){ //if root or replacement value is less than parent
            heapifyBelow(index,size-1);
        }else {
            heapifyUp(index);
        }

         size--;

         return deletedValue;
     }

     //top most element is shown
     public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
     }

     public void sort(){
        int lastHeapIndex = size-1;
        int temp;
        for(int i=0;i<lastHeapIndex;i++){
//            swap root with last item, heapify excluding sorted items
            temp = heap[0];
            heap[0]=heap[lastHeapIndex-i];
            heap[lastHeapIndex-i]=temp;

            heapifyBelow(0,lastHeapIndex-i-1);//exclude heapify sorted
        }
     }

     public void printHeap(){
        if(isEmpty()){
            return;
        }

        for(int i=0;i<size;i++){
            System.out.print(heap[i]+"->");
        }
        System.out.println();
     }

}
