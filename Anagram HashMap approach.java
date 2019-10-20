import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = "hellol";
		String str2 = "llohel";
		HashMap<Character,Integer> m1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> m2 = new HashMap<Character,Integer>();
		Boolean flag = true;
		if(str1.length()!=str2.length()) {
			flag= false;
		}else {
		int size = str1.length();
		//Making 2 maps
		for(int i =0 ; i< size;i++) {
			try {
			char word = str1.charAt(i);
			int count = m1.containsKey(word) ? m1.get(word) : 0;
			m1.put(word, count + 1);
			word = str2.charAt(i);
			count = m2.containsKey(word) ? m1.get(word) : 0;
			m2.put(word, count + 1);}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}//Compare 2 maps
		Character[] keys = m1.keySet().toArray(new Character[0]);	
		for(int i = 0; i < keys.length;i++) {
			if(m1.get(keys[i])!=m2.get(keys[i])) {
				System.out.println(m1.get(keys[i]));
				System.out.println(m2.get(keys[i]));
				flag = false;
				break;
			}
		}
		}
		if(flag) {
			System.out.println("Anagram");
		}else {
			System.out.println("Nope");
		}
//		System.out.println(sort(str1)==sort(str2));
		scan.close();
	}
}
