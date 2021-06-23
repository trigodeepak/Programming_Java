// LeetCode 68 Text Justification
class Solution {
    public String buildJustify(String[] words,int maxWidth,int start,int end,int currLen){
        StringBuffer sb = new StringBuffer();
        if(start==end) {
        	sb.append(words[start]);
        	for(int j=0;j<maxWidth-currLen;j++)
                sb.append(" ");
        	return sb.toString();
        }
        //This means this is the last part and we do not have to justify this
        if(end == words.length -1) {
        	sb.append(words[start]);
        	for(int i=start+1;i<=end;i++) {
        		sb.append(" ");
        		sb.append(words[i]);
        	}
        	
        	int len = sb.length();
        	for(int i=0;i<maxWidth-len;i++) {
        		sb.append(" ");
        	}
        	
        	return sb.toString();
        	
        }
        	
        int diff = maxWidth-currLen;
        int spacesReq = end - start;
        int normalSpace = diff/spacesReq;
        int extraSpace = diff%spacesReq;
        int i=start;
        sb.append(words[start]);
        while(i<end){
            for(int j=0;j<normalSpace;j++)
                sb.append(" ");
            if(extraSpace>0) {
            	sb.append(" ");
            	extraSpace--;
            }
            i++;
            sb.append(words[i]);
        }

        return sb.toString();
        
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int i,j,len = words.length,currLen,start,end;
        List<String> res = new ArrayList();
        i=0;
        while(i<len){
            start = i;
            end = i;
            currLen = 0;
            while(i<len){
                if((currLen + words[i].length()+i-start)<=maxWidth){
                    currLen += words[i].length();
                    end = i;
                    i++;
                }
                else
                    break;
            }
            String s = buildJustify(words,maxWidth,start,end,currLen);
            // System.out.println(s);
            res.add(s);
//            i++;
        }
        return res;
        
        
    }
}