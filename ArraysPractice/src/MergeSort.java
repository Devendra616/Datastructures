public class MergeSort {

    public static void main(String[] args) {

        int []arr =  {12, 11, 13, 5, 6, 7,2,11,6};
        System.out.println("Original Array=>\n");
        printArray(arr);

        MergeSort obj = new MergeSort();
        obj.sort(arr,0,arr.length-1);
        System.out.println("Sorted Array=>\n");
        printArray(arr);
    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    void sort(int []arr,int low,int high){

        if(low<high){
            int mid = (low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    //merges two subarrays arr[low...mid], arr[mid+1 .... high]
    void merge(int []arr,int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid; //high - (mid+1)+1

        //create temp arrays
        int temp1[] = new int[n1];
        int temp2[] = new int[n2];

        //copy data to temp arrays
        for(int i=0;i<n1;i++){
            temp1[i] = arr[low+i];
        }
        for(int i=0;i<n2;i++){
            temp2[i] = arr[mid+1+i];
        }

        //Merge the temp arrays
        int i=0, j=0,k=low;
        while(i<n1 && j <n2){
            if(temp1[i]<temp2[j]){
                arr[k++] = temp1[i++];
            }else{
                arr[k++] = temp2[j++];
            }
        }

        //copy remaining elements
        while(i<n1){
            arr[k++]= temp1[i++];
        }
        while(j<n2){
            arr[k++] = temp2[j++];
        }
    }
}
/*
    Time complexity of Merge Sort is O(nLogn) in all 3 cases (worst, average and best)
    as merge sort always divides the array in two halves and take linear time to merge two halves.

Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes
 */