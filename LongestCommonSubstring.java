public class LongestCommonSubstring{
	static int lcs(char []a,char []b){
		int n1 = a.length,n2 = b.length,i,j,max=0;
		int [][]dp = new int[n1+1][n2+1];
		for(i=0;i<=n1;i++){
			for(j=0;j<=n2;j++){
				if(i==0 || j==0)
					dp[i][j] = 0;
				else if(a[i-1]==b[j-1]){
					dp[i][j] = dp[i-1][j-1]+1;
					if(dp[i][j]>max)
						max = dp[i][j];
				}
				else
					dp[i][j] = 0;

			}
		}
		return max;
	}
	public static void main(String []args){
		String a = "abcdaf";
		String b = "zbcdf";//bcd is the Answer 
		char []a_c = a.toCharArray();
		char []b_c = b.toCharArray();
		System.out.print("Longest common Substring length = "+lcs(a_c,b_c));
	}
}
// https://www.geeksforgeeks.org/longest-common-substring-dp-29/