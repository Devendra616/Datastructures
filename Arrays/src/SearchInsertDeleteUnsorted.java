/*
In an unsorted array, the search operation can be performed by linear traversal from the first element to the last element.
 */

public class SearchInsertDeleteUnsorted {

    public static void main(String[] args) {
        int arr[] = {2,3,5,4,7,8,9,1,2};
        int ele =80;
        int index = linearSearch(arr,ele);
        if(index == -1){
            System.out.println("Element "+ ele+" not found");
        }else{
            System.out.println("Element "+ ele+" found at index: "+index);
        }

        int capacity =10;
        int insertEle = 45;
        int []array = new int[capacity];
        array[0]=12;array[1]=5;array[2]=3;array[3]=61;
        array[4]=12;array[5]= 23;array[6]=20;
        int n=7;
        System.out.println("Before insertion: ");
        printArray(array,n);
        n = insert(array,n,insertEle,capacity);
        System.out.println("\nAfter insertion: ");
        printArray(array,n);

        int delEle= 5;
        n= arr.length;
        System.out.println("\nBefore deletion: ");
        printArray(arr,n);
        n = deleteElement(arr,delEle);
        System.out.println("\nAfter deletion: ");
        printArray(arr,n);
    }

    static void printArray(int arr[], int n){
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    static int deleteElement(int arr[],int ele){
       int pos=  linearSearch(arr,ele);
       if(pos == -1){
           System.out.println("Element not found!");
           return arr.length;
       }

       //shift one index to left
       for(int i=pos;i<arr.length-1;i++){
           arr[i]=arr[i+1];
       }
       return  arr.length -1;
    }

    static int insert(int arr[],int n,int e, int capacity){
        if(n >= capacity){
            //can not insert more element as reached its cap
            return n;
        }
        arr[n]= e;
        return n+1;
    }

    static int linearSearch(int []arr,int element){
        for(int i=0;i<arr.length;i++){
            if(element == arr[i]){
                return i;
            }
        }
        return -1;
    }
}

/*Searching :
    Time complexity: O(n)
    Auxillary space: O(1)

   Inserting :
     Time complexity: O(1)
     Auxillary space: O(1)

 Deleting:
    Time complexity: O(n)
    Auxillary space: O(1)
 */
