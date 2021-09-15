//Leetcode 60 Permutation Sequence 

class Solution {
    int target = 0,len;
    String result;
    boolean visited[];
    public void permuteUtil(String[] arr,int ind,StringBuffer sb){
        // System.out.println(ind+" "+sb.toString());
        if(sb.length()==len){
            //System.out.println(sb.toString());
            target--;
            if(target==0)
                result = sb.toString();
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(arr[i]);
                permuteUtil(arr,i+1,sb);
                visited[i] = false;
                sb.setLength(sb.length()-1);
            }
        }
    }
    public String getPermutation(int n, int k) {
        target = k; len = n;
        result = "";
        visited = new boolean[n];
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.toString(i+1);
        }
        //System.out.println(Arrays.toString(arr));
        permuteUtil(arr,0,new StringBuffer());
        return result;
    }
}
