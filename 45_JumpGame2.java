//LeetCode 45 Jump Game 2
class Solution {
    public int jump(int[] nums) {
        int i,j,len= nums.length;
        
        if(len==1)
            return 0;
        
        int[] status = new int[len]; 
        
        for(i=1;i<len;i++)
            status[i] = len;
        status[0] = 0;
        for(i=0;i<len;i++){
            for(j=nums[i];j>0;j--){
                if(j+i>=len-1){
                    // System.out.println(i+" "+j+" "+Arrays.toString(status));
                    return status[i]+1;
                }
                else
                    status[i+j] = Math.min(status[i]+1,status[i+j]);
            }
            // System.out.println(i+" "+Arrays.toString(status));
        }
        // System.out.println("Before return");
        return status[len-1];
    }
}