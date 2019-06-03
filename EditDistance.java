public class EditDistance{
	static int minEditDist(char [] a,char []b){
		int n1 = a.length,n2 = b.length,i,j;

		int [][]dp = new int[n1+1][n2+1];
		for(i=0;i<=n1;i++){
			for(j=0;j<=n2;j++)
				if(i==0 && j==0)
					dp[i][j] = 0;
				else if(i==0)
					dp[i][j] = dp[i][j-1]+1;
				else if(j==0)
					dp[i][j] = dp[i-1][j]+1;
				else if(a[i-1]==b[j-1]){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
				}
		}
		for(i=0;i<=n1;i++){
			for(j=0;j<=n2;j++){
				System.out.print(String.valueOf(dp[i][j])+" ");
			}
			System.out.println("");
		}
		return dp[n1][n2];
	}
	public static void main(String []args){
		String a = "azced";
		String b = "abcdef";
		char[] a_c = a.toCharArray();
		char[] b_c = b.toCharArray();
 		System.out.println("Answer is "+minEditDist(a_c,b_c));
	}
}
// https://www.geeksforgeeks.org/edit-distance-dp-5/