public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {5,-15,35,6,4,2,-4,14};
        System.out.println("Original Array=>");
        printArray(array);

        int indexOfLargest;
        for(int lastUnsortedIndex= array.length-1;lastUnsortedIndex>0;lastUnsortedIndex--){
            indexOfLargest = 0;
            for(int i=1;i<=lastUnsortedIndex;i++){
                if(array[i]>array[indexOfLargest]){
                    indexOfLargest = i;
                }
            }

                swap(array,indexOfLargest,lastUnsortedIndex);
            }
        System.out.println("\nSorted Array=>");
        printArray(array);

    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void swap(int []array,int i, int j){
        if(i==j){
            return;
        }
        int temp = array[i];
        array[i]= array[j];
        array[j] = temp;
    }
}
/*
    Time Complexity : O(n*n)
    Inplace Algorithim
    Unstable Sorting: Duplicate element may change its place
    Lesser swap than bubble swap as swap once an internal loop
 */