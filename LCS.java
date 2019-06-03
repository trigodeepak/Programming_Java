import java.util.Scanner;  
public class LCS {  
	public static void main(String[] args){
		String s1 = "acbcf";
		String s2 = "abcdaf";
		int n1 = s1.length(),n2 = s2.length();
		
		int[][] res = new int[n1+1][n2+1];
		int i=0,j=0;  
		
		for(i=1;i<=n1;i++){
			for(j=1;j<=n2;j++){
				if (i == 0 || j == 0) 
           			res[i][j] = 0; 	
				else if((s1.charAt(i-1))==(s2.charAt(j-1))){
					res[i][j] = res[i-1][j-1]+1;
				}else{
					res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
				}
			}
		}
		for(i=0;i<n1+1;i++){
			for(j=0;j<n2+1;j++){
				System.out.print(String.valueOf(res[i][j])+" ");
			}
			System.out.println("");
		}
		
	}

}
// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
