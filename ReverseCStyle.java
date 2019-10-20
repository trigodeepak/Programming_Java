import java.util.*;

public class ReverseCStyle{
	public static void main(String[] args){
		String str = "abcd\0";
		str = str.substring(0, str.length() - 1);
		System.out.print(str);
		//This is not correct
	}
}