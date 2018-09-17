public class InsertionSort{
        public static void main(String[] args) {
            int array[] = {5,-15,35,6,4,2,-4,14};
            System.out.println("Original Array=>");
            printArray(array);

            int position=0;
            for(int firstUnsortedIndex= 1;firstUnsortedIndex < array.length;firstUnsortedIndex++){

                int newElement = array[firstUnsortedIndex];
                int i;
                for( i=firstUnsortedIndex;i>0 && array[i-1]>newElement;i--){
                   array[i] = array[i-1];
                }
                array[i] = newElement;
            }
            System.out.println("\nSorted Array=>");
            printArray(array);

        }

        public static void printArray(int arr[]){
            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+ " ");
            }
        }

      }
/*
    Time Complexity : O(n*n)
    Inplace Algorithim
    Stable Sorting: Position of duplicate elements preserved

 */