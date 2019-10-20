import java.util.*;

public class UniqueChar{
	public static void main(String[] args){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		Scanner scan = new Scanner(System.in);
		String s = new String();
		s = scan.nextLine();
		// System.out.println(s);
		Boolean flag = true;
		for(int i =0; i< s.length() ; i++){
			if(map.containsKey(s.charAt(i))){
				flag = false;
				break;
			}else{
				map.put(s.charAt(i),1);
			}
		}
		if(flag){
			System.out.println("All characters are unique");
		}else{
			System.out.println("All characters are NOT unique");
		}
	}
}