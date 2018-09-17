public class RotationWithTemp {
    public static void main(String[] args) {
        Rotation rotate = new Rotation();
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("Before rotation:");
        rotate.printArray(arr,arr.length);
        System.out.println("\nAfter rotation:");
        rotate.leftRotate(arr,2,arr.length);
        rotate.printArray(arr,arr.length);
    }

    /*Utility function to print array*/
    void printArray(int arr[],int n){
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    void leftRotate(int arr[],int d, int n){
        int []temp = new int[d];
        int j=0;
        //store d elements in temp array
        for(int i=0;i<d;i++){
            temp[i]= arr[i];
        }
        //shift remaining elements to d places left
        for(int i=d;i<n;i++){
            arr[i-d]= arr[i];
        }

        //push temp array to right end
        for(int i=d+1;i<n;i++){
            arr[i]=temp[j++];
        }
    }

}

/*
    Time complexity: O(n)
    Auxillary space: O(d)

 */