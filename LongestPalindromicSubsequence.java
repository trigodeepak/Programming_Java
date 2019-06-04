public class LongestPalindromicSubsequence{
	static int lps(char []a){
		int n = a.length,i,j,k;
		int [][]dp = new int[n][n];
		for(k=0;k<n;k++){
			for(i=0,j=k;j<n;j++,i++){
				if(i==j)
					dp[i][j]=1;
				else if(a[i]==a[j])
					dp[i][j] = dp[i+1][j-1]+2;
				else
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
			}
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		String s = "geeks for geeks";
		char []a = s.toCharArray();
		System.out.println("Longest Palindromic Subsequence is "+lps(a));
	}
}
// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/