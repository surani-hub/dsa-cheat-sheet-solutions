/*
	https://tinyurl.com/82s88xfa
*/

import java.util.Arrays;

class LeftRotation{
	public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int k = 2;
        leftRotate(arr, k, n);
        System.out.println(Arrays.toString(arr));
    }

    static public void leftRotate(long arr[], int k, int n) {
        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    static public void reverse(long[] arr, int start, int end) {
        while (start < end) {
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
	
	// https://tinyurl.com/5xzbjh7f
	// TC - O(n) & SC - O(k)
	static void leftRotate(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        if (k >= 0)
            System.arraycopy(arr, 0, temp, 0, k);
        if (n - k >= 0)
            System.arraycopy(arr, 0 + k, arr, 0, n - k);
        if (n - (n - k) >= 0)
            System.arraycopy(temp, n - k - n + k, arr, n - k, n - (n - k));
    }
}