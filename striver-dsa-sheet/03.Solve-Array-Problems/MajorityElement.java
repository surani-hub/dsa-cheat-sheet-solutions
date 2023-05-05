import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class MajorityElement{
	public static void main(String[] args){
		int[] a = {3,2,1};
		System.out.println(majorityElementUsingTwoLoops(a, a.length));
		System.out.println(majorityElementUsingHashMap(a, a.length));
		System.out.println(majorityElementUsingJava8(a, a.length));
		System.out.println(majorityElementWithOptimisation(a, a.length));
	}
	
	public static int majorityElementUsingTwoLoops(int a[], int size) {
        // using two loops TC - O(n^2) & SC - O(1)
        for (int i = 0; i < size - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < size; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count > size / 2) {
                return a[i];
            }
        }
        return -1;
    }

    public static int majorityElementUsingHashMap(int a[], int size) {
        // using HashMap TC - O(nlogn)+O(n) & SC - O(n)
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entries : freqMap.entrySet()) {
            if (entries.getValue() > size / 2) {
                return entries.getKey();
            }
        }
        return -1;
    }
	
	public static int majorityElementUsingJava8(int a[], int size) {
        // using HashMap TC - O(nlogn)+O(n) & SC - O(n)
        Map<Integer, Long> freqMap = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Map.Entry<Integer, Long>> entries = freqMap.entrySet().stream().filter(e -> e.getValue() > size / 2).findFirst();
        return entries.map(Map.Entry::getKey).orElse(-1);
    }
	
	public static int majorityElementWithOptimisation(int a[], int size) {
        // using Moore's voting algo TC - O(n) & SC - O(1)
        int count = 0, ele = 0;
        for (int num : a) {
            if (count == 0) {
                ele = num;
                count++;
            } else if (num == ele) {
                count++;
            } else {
                count--;
            }
        }

        int cnt = 0;
        for (int num : a) {
            if (num == ele) {
                cnt++;
            }
        }
        if (cnt > size / 2) {
            return ele;
        }
        return -1;
    }
}