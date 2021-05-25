class Solution {
    ArrayList<Integer> nums;
    boolean visited[];
    int res; 
    public int countSticks(ArrayList<Integer> temp,int k){
        int max = temp.get(0),count=1;
        for(int i=1;i<temp.size();i++){
            if(temp.get(i)>max){
                max = temp.get(i);
                count++; 
                if(count>k)
                    return 0;
            }
        }
        if(count==k)
            return 1;
        return 0;
    }
    public void rearrangeUtil(int [] arr,int ind,int k,int n){
        if(nums.size()==n){
            res+= countSticks(nums,k);
            // System.out.println(nums);
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                nums.add(arr[i]);
                rearrangeUtil(arr,i+1,k,n);
                nums.remove((Integer)arr[i]);
                visited[i] = false;
            }
        }
            
        
    }
    public int rearrangeSticks(int n, int k) {
        res = 0;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        visited = new boolean[n];
        nums = new ArrayList<>(n);
        rearrangeUtil(arr,0,k,n);
        return res; 
        
    }
}
