//394 Leetcode Decode String Stack question
class Solution {
    public int decodeUtil(String s,StringBuffer sb,int i){
        int j=i-1,start=i;
        for(j=i-1;j>=0;j--){
            if(s.charAt(j)==']'){
                j = decodeUtil(s,sb,j)+1;
            }
            if(s.charAt(j)=='['){
                start = j;
                j--;
                break;
            }
        }
        while(j>=0&&Character.isDigit(s.charAt(j))){
            j--;
        }
        if(j==0)
              j--;
        // System.out.println(j+" "+start+" "+i);
        int iter = Integer.valueOf(s.substring(j+1,start));
        String ut = s.substring(start+1,i);
        StringBuffer util = new StringBuffer();
        
        for(int k = 0;k<iter;k++){
            util.append(ut);
        }
        sb.append(util.reverse());
        return j;
    }
    
    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length(),i,start;
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Integer> stack2 = new LinkedList<Integer>();
        i=0;
        while(i<len){  	
//            if(s.charAt(i)!=']')
//                sb.append(s.charAt(i));
//            else{
//                i = decodeUtil(s,sb,i)+1;
//            }
        	if(Character.isDigit(s.charAt(i))) {
        		start = i;
        		while(i<len && Character.isDigit(s.charAt(i))) {
        			i++;
        		}
        		stack2.push(Integer.valueOf(s.substring(start,i)));
        		i--;
        	}
        	else if(s.charAt(i)=='[' || s.charAt(i)!=']') {
        		stack.push(s.charAt(i));
        	}        	
        	else if(s.charAt(i)==']') {
        		StringBuffer util = new StringBuffer();
        		sb = new StringBuffer();
//        		System.out.println(stack+" "+i+" "+stack2);
        		Character ch;
        		ch = stack.pop();
        		while(stack.size()>0 && ch!='[') {
        			util.append(ch);
        			ch = stack.pop();
        		}
        		int iter = stack2.pop();
        		for(int k=0;k<iter;k++)
        			sb.append(util);
                sb.reverse();
        		for(int k=0;k<sb.length();k++) {
        			stack.push(sb.charAt(k));
        		}
//        		System.out.println(stack+" "+i+" "+stack2);
        		sb = new StringBuffer();
        	}
//        	System.out.println("Main"+stack+" "+i+" "+stack2);
        	i++;
        }

        while(stack.size()>0)
        	sb.append(stack.pop());
       sb.reverse();
        return sb.toString();
    }
}