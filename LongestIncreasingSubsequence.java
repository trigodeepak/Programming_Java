import java.util.Arrays;
public class LongestIncreasingSubsequence{
//program to find the length of longest Increasing Subsequence
	static int lis(int a[]){
		int n = a.length,i,max=0,j;
		int []temp = new int[n];
		for(i=0;i<n;i++)
			temp[i] = 1;

		for(i=1;i<n;i++){
			for(j=0;j<i;j++){
				if(a[j]<a[i]){
					temp[i] = Math.max(temp[i],temp[j]+1);
				}	
			}
		}

		for(i=0;i<n;i++){
				if(max<temp[i])
					max = temp[i];
				System.out.print(String.valueOf(temp[i])+" ");
		}
		return max;
	}

	public static void main(String[] args){
		int []a = {3,4,-1,0,6,2,3};
		
		System.out.println("Answer is "+String.valueOf(lis(a)));
	}
}
// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/