import java.util.*;

class MaximumSubarraySum{
	public static void main(String[] args){
		int[] a = {3,2,1};
		System.out.println(maxSubarraySumUsingThreeLoops(a, a.length));
		System.out.println(maxSubarraySumUsingTwoLoops(a, a.length));
		System.out.println(maxSubarraySumUsingKadane(a, a.length));
		System.out.println(maxSubarraySumUsingKadanes(a, a.length));
	}
	
	// using three loops TC - O(n^3) & SC - O(1)
	static public long maxSubarraySumUsingThreeLoops(int arr[], int n) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
				max = Math.max(max, sum);
            }
        }
        return max;
    }
	
	// using three loops TC - O(n^2) & SC - O(1)
	static public long maxSubarraySumUsingTwoLoops(int arr[], int n) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
	
	// using Kadane's algo TC - O(n) & SC - O(1)
	static public long maxSubarraySumUsingKadane(int arr[], int n) {
        long max = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
	
	// using Kadane's algo TC - O(n) & SC - O(1)
	static public long maxSubarraySumUsingKadanesAlgo(int arr[], int n) {
        long max = Long.MIN_VALUE, sum = 0, start = -1, end = -1;
        for (int i = 0; i < n; i++) {
			sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
	
	static public long maxSubarraySumUsingKadanes(int arr[], int n) {
        long max = Long.MIN_VALUE, sum = 0;
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("Maximum subarray is : [");
        for (int k = start; k <= end; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.print("]");
		System.out.println();
        return max;
    }
}