import java.util.Arrays;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		//Complexity is nlogn
		Scanner scan = new Scanner(System.in);
		String str1 = "hellol";
		String str2 = "llohel";
		char [] g1 = str1.toCharArray();
		Arrays.sort(g1);
		char [] g2 = str2.toCharArray();
		Arrays.sort(g2);
		Boolean flag = true;
		if(str1.length()!=str2.length()) {
			flag= false;
		}else {
		int size = str1.length();
		for(int i =0 ; i< size;i++) {
			if(g1[i]!=g2[i]) {
				flag = false;
				break;
			}
		}}
		if(flag) {
			System.out.println("Anagram");
		}else {
			System.out.println("Nope");
		}
//		System.out.println(sort(str1)==sort(str2));
		scan.close();
	}
}
