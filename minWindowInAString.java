//minimum window in a string Hash Map approach// doesn't work for duplicates
class Solution {
    public String minWindow(String s, String t) {
        int start,minLen, n = s.length(), m = t.length(),count=0,i;
        String res = "";
        if(m>n) {
            return "";
        }
        //Making the hashmap for the characters to match in the string
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        Character ch;
        for(i=0;i<m;i++) {
            ch = t.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,0);
            }
        }
        count = map.size();
        
        //Finding the minimum window in which all character are available
        
        minLen = n+1;
        start = -1;
        int countMatch=0,len,minInd=0;
        //Finding the first window
        for(i=0;i<n;i++) {
            ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,i);
                if(countMatch<count) {
                countMatch++;}
                if(countMatch==count) {
                    minInd = Collections.min(map.values());
                    len = Collections.max(map.values())-Collections.min(map.values());
//                  System.out.print(len+" "+minLen);
                    if(len<minLen) {
                        start = minInd;
                        minLen = len;
                    }
//                  System.out.println(len+" "+minLen+" "+ch+" "+i);
                }
                
            }
        }
        if (start == -1){
            return "";
        }
        res = s.substring(start,start+minLen+1);
        return res;
    }
}