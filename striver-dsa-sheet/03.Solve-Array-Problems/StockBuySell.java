class StockBuySell{
	public static void main(String[] args){
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfitUsingTwoLoops(prices));
		System.out.println(maxProfit(prices));
	}
	
	// using two loops TC - O(n^2) & SC - O(1)
	static public int maxProfitUsingTwoLoops(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return Math.max(max, 0);
    }
	
	// TC - O(n) & SC - O(1)
	static public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }
}