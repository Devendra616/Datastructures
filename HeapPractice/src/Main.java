public class Main {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(47);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(80);

        heap.printHeap();
        heap.delete(1);//delete 75
        heap.printHeap();

        System.out.println("\nRoot is "+heap.peek());
        heap.delete(0);
        heap.printHeap();
        System.out.println("\nRoot is "+heap.peek());

        heap.sort();
        System.out.println("\nSorted heap is ");
        heap.printHeap();
    }
}