import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = "helablkajsklfdjauf89oanfvjkvbjknadvjkadvfjkcadskvbihe";
		StringBuilder sb = new StringBuilder(str);
		int size = sb.length();
		
		for(int i = 1;i<size;i++) {
			for(int j = 0; j< i;j++) {
				if(sb.charAt(i)==sb.charAt(j)) {
					sb.deleteCharAt(i);
					size--;
					if(i>1) {
						i--;
					}
					break;
				}
			}
		}
		
		System.out.println(sb);
		scan.close();
	}
}
