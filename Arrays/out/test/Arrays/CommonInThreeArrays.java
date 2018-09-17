/*
    Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples:

ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5
 */
public class CommonInThreeArrays {

    public static void main(String[] args) {

        CommonInThreeArrays obj = new CommonInThreeArrays();
        int arr1[] = {2,4,6,8,10,12,15};
        int arr2[] = {3,4,5,6,7,8,10,12,15};
        int arr3[]= {2,6,10,7,8,12,15,18,20,24,30,124};

        obj.findCommon(arr1,arr2,arr3);
    }

    static void findCommon(int a1[],int a2[], int a3[]){

        int i=0,j=0,k=0;
        while (i<a1.length && j<a2.length && k<a3.length) {
            if (a1[i] == a2[j] && a2[j] == a3[k]) {
                System.out.print(a1[i] + " ");
                i++;j++;k++;
            } else if (a1[i] < a2[j]) {
                i++;
            } else if (a2[j] < a3[k]) {
                j++;
            } else {
                k++; //k is smallest
            }
        }
    }
}

/*
    Time complexity : O(n1+n2+n3)
 */
