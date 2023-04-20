/* https://practice.geeksforgeeks.org/problems/count-digits5716/1 */

class CountDigits{
	public static void main(String[] args){
		int N = 12;
		System.out.println(evenlyDivides(N));
	}
	
	public static int evenlyDivides(int N){
        int count = 0;
        int dup = N;
        while(N > 0){
            int rem = N % 10;
            if(rem!= 0 && dup % rem == 0){
                count++;
            }
            N /= 10;
        }
        return count;
    }
}