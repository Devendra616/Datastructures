public class ActivitySelectionProblem {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        printMaxActivities(start, finish, n);
    }
    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
    private static void printMaxActivities(int[] s, int[] f, int n) {
        int done;
        int traversing;

        System.out.println("Items selected are: ");
        done = 0;
        System.out.print(done);
        for (traversing = 1; traversing < n; traversing++) {
            if (s[traversing] >= f[done]) {
                System.out.print(", " + traversing);
                done = traversing;
            }
        }
    }
}
