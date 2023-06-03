public class ArraySortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int n = arr.length;
        System.out.println(arraySortedOrNot(arr, n));
        System.out.println(arraySortedAndRotated(arr));
    }

	// https://tinyurl.com/4bc773r5
    static boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

	// https://tinyurl.com/yecatuty
    static boolean arraySortedAndRotated(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[(i + 1) % arr.length])
                count++;
        }
        return count <= 1;
    }
}