//Leetcode 424 | Longest Repeating Character Replacement
class Solution {
    public int calculateNewK(HashMap map,int len){
        if(map.size()<=1)
            return 0;
        int maxVal = -1;
        for(Object ch: map.keySet()){
            maxVal = Math.max((int)map.get(ch),maxVal);
        }
        return len-maxVal;
        
    }
    public int characterReplacement(String s, int k) {
        int i,j,len = s.length(),tempK=0;
        HashMap<Character,Integer> map = new HashMap<>();
        i = 0;
        j = -1;
        int res = 0;
        while(true){
            boolean flag1 = false, flag2 = false;
            //Acquire  
            while(i<len && tempK<=k){
                flag1 = true;
                char curr = s.charAt(i);
                map.put(curr,map.getOrDefault(curr,0)+1);
                tempK = calculateNewK(map,i-j);
                if(tempK<=k) {
                    res = Math.max(i-j,res);
                }
                i++;
                //System.out.println(i+" "+map+" "+tempK+" "+res);
            }
            
            //Release 
            while(tempK>k && j<i){
                flag2 = true;
                j++;
                //System.out.println("Release "+(i-j)+" "+map+" "+tempK+" "+res);
                char curr = s.charAt(j);
                int freq = map.get(curr);
                if(freq == 1)
                    map.remove(curr);
                else 
                    map.put(curr,map.get(curr)-1);
                
                tempK = calculateNewK(map,i-j);
                
                //System.out.println("Release "+(i-j)+" "+map+" "+tempK+" "+res);
                
                if(tempK<=k)
                    res = Math.max(i-j,res);
            }
            if(!flag1 && !flag2)
                break;
        }
        return res; 
    }
}
