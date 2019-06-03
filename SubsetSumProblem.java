public class SubsetSumProblem{
	public static void main(String[] args){
		int []s = {2,3,7,8,10};
		int n = s.length,k=11,i,j;

		boolean [][]a = new boolean[n+1][k+1];
		for(i=0;i<=k;i++)
			a[0][i] = false;
		a[0][0] = true;

		for(i=1;i<=n;i++){
			for(j=0;j<=k;j++){
				 if(s[i-1]>j)
				 	a[i][j] = a[i-1][j];
				 else {
				 	a[i][j] = a[i-1][j] || a[i-1][j-s[i-1]];
				 }
			}
		}

		for(i=0;i<=n;i++){
			for(j=0;j<=k;j++){
				System.out.print(String.valueOf(a[i][j])+" ");
			}
			System.out.println("");
		}
	}
}
// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/