public class BubbleSort {

    public static void main(String[] args) {
        int array[] = {5,-15,35,6,4,2,-4,14};
        System.out.println("Original Array=>");
        printArray(array);

        for(int unsortedIndex= array.length-1;unsortedIndex>0;unsortedIndex--){
            for(int i=0;i<unsortedIndex;i++){
                if(array[i]>array[i+1]){
                    swap(array,i,i+1);
                }
            }
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
    Inplace sorting algo
    Time Complexity : O(n*n)
    Auxiliary space : O(1)
    Algorithm degrades quickly
 */
