public class MinimumCoinChanging{
	static int coinChange(int []a,int k){
		int i,j,n=a.length;
		int dp[] = new int[k+1];
		for(i=0;i<=k;i++)
			dp[i] = Integer.MAX_VALUE;
		dp[0]=0;
		for(i=0;i<n;i++){
			for(j=0;j<=k;j++){
				if(j>=a[i])
					dp[j] = Math.min(dp[j],dp[j-a[i]]+1);
			}
		}

		for(j=0;j<=k;j++){
			System.out.print(dp[j]+" ");
		}
		return dp[k];
	}
	public static void main(String[] args) {
		int a[] = {1,5,6,8};
		int k = 11;
		System.out.println("\nMinimum Coins needed : "+coinChange(a,k));
	}
}
// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/