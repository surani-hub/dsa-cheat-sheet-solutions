/*
	gfg - https://tinyurl.com/bdt74wje
	lc - https://tinyurl.com/kjt7efwj
*/

import java.util.Arrays;

class MoveAllZerosToEnd{
	public static void main(String[] args) {
        int[] nums = {3, 5, 0, 0, 4};
//        pushZerosToEnd(nums, nums.length);
        pushZerosToEndInPlace(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }


    public static void pushZerosToEndInPlace(int[] nums, int n) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }
    }

    static void pushZerosToEnd(int[] nums, int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < n; i++) {
            if (j >= 0 && nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}