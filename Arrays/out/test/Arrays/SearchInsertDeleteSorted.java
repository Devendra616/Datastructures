public class SearchInsertDeleteSorted {

    public static void main(String[] args) {
        int arr[] = {2,3,4,6,8,12,14};
        int ele =55;
        int index = binarySearch(arr,ele,0,arr.length-1);
        if(index == -1){
            System.out.println("Element "+ ele+" not found");
        }else{
            System.out.println("Element "+ ele+" found at index: "+index);
        }

        int capacity =10;
        int insertEle = 15;
        int []array = new int[capacity];
        array[0]=5;array[1]=7;array[2]=8;array[3]=10;
        array[4]=12;array[5]= 14;array[6]=17;
        int n=7;
        System.out.println("Before insertion: ");
        printArray(array,n);
        n = insert(array,n,insertEle,capacity);
        System.out.println("\nAfter insertion: ");
        printArray(array,n);

        int delEle= 4;
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
       int pos=  binarySearch(arr,ele,0,arr.length-1);
       if(pos == -1){
           System.out.println("\nElement not found!");
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
        int i;
        for( i=n-1;i>=0;i--){
            if(arr[i]>e){
                arr[i+1]= arr[i];
            }else{
                break;
            }

        }
        arr[i+1] =e;
        return n+1;
    }

    static int binarySearch(int []arr,int element,int f, int l) {

        int mid = (f + l)/ 2;
        if(f>l){
            return  -1;
        }

        if(element == arr[mid]){
            return  mid;
        }
        if(element > arr[mid]){
            return binarySearch(arr,element,mid+1,l);
        }else {
            return binarySearch(arr,element,f,mid-1);
        }
    }
}

/*Searching :
    Time complexity: O(Log n)
    Auxiliary space: O(1)

   Inserting :
     Time complexity: O(n)
     Auxiliary space: O(1)

 Deleting:
    Time complexity: O(n)
    Auxiliary space: O(1)
 */
