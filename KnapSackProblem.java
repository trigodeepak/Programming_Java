public class KnapSackProblem{
	public static void main(String[] args){
		int []wt = {1,3,4,5};
		int []val = {1,4,5,7};
		int n = wt.length,k,i,j;
		k = val[n-1];
		int [][]a = new int[n+1][k+1];
		for(i=0;i<=k;i++)
			a[0][i] = 0;

		for(i=1;i<=n;i++){
			for(j=0;j<=k;j++){
				 if(wt[i-1]>j)
				 	a[i][j] = a[i-1][j];
				 else {
				 	a[i][j] = Math.max(a[i-1][j],val[i-1]+a[i-1][j-wt[i-1]]);
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
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/