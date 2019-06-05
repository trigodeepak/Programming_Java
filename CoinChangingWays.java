import java.util.Arrays;
public class CoinChangingWays{
	static int coinChange(int []a,int k){
		int i,j,n=a.length;
		int dp[] = new int[k+1];
		Arrays.fill(dp,0);
		dp[0] = 1;
		for(i=0;i<n;i++){
			for(j=a[i];j<=k;j++){
				dp[j] += dp[j-a[i]];
			}
		}

		for(j=0;j<=k;j++){
			System.out.print(dp[j]+" ");
		}
		return dp[k];
	}
	public static void main(String[] args) {
		int a[] = {1,2,3};
		int k = 5;
		System.out.println("\nNo of ways Value can be made : "+coinChange(a,k));
	}
}
// https://www.geeksforgeeks.org/coin-change-dp-7/