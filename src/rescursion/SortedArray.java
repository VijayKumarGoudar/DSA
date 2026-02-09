package rescursion;

// Basic recursion problem to check if an array is sorted in ascending order.
public class SortedArray {

    public static boolean isSorted(int[] arr, int n, int i) {
        if (i == n - 1) {
            return true;
        }

        if(arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, n, i + 1);
    }

    static void main() {
        int arr[] = {1, 2, 3, 4, 5, 8, 10};
        int n = arr.length;
        boolean sorted = isSorted(arr, n, 0);
        System.out.println("Is the array sorted? " + sorted);
    }

}
