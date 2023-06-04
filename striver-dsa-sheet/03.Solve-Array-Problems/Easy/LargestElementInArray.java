/*
	https://tinyurl.com/yt2mrhcv
*/

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 8, 56, 90};
        int n = arr.length;
        System.out.println(largest(arr, n));
    }

    static public int largest(int arr[], int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }
        return largest;
    }
}