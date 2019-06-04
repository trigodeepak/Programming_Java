import java.util.Arrays;
public class MinimumJumpsToEnd{
//program to find the Minium jump to reach end
	static int jumpToReachEnd(int a[]){
		int n = a.length,i,j;
		int []temp = new int[n];
		int []res = new int[n];
		for(i=0;i<n;i++){
			temp[i] = 9;
			res[i] = 9;
		}
		temp[0] = 0; res[0] = 0;
		for(i=1;i<n;i++){
			for(j=0;j<i;j++){
				if(a[j]+j>=i && temp[j]+1<temp[i]){
					temp[i] = temp[j]+1;
					res[i] = j;
				}	
			}
		}

		for(i=0;i<n;i++){
				System.out.print((temp[i])+" ");
		}
		System.out.println("");
		int output[] = new int[temp[n-1]];
		i=n-1;j=temp[n-1]-2;
		output[j+1] = n-1;
		while(i>0&&j>=0){
			output[j]=res[i];
			j--;
			i=res[i];
		}
		System.out.print("The jumps are as follows : 0 ");
		for(i=0;i<temp[n-1];i++){
				System.out.print((output[i])+" ");
		}
		return temp[n-1];
	}

	public static void main(String[] args){
		int []a = {2,3,1,1,2,4,2,0,1,1};
		System.out.println("\nMinimum Jumps to reach End are "+jumpToReachEnd(a));
	}
}
// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
// More efficient solution also available