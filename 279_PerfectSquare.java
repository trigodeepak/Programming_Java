//LeetCode 279 Perfect Squares
class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int min;
    boolean visited[];
    //Done using BFS
    public int numSquares(int n) {
        int i = 1,k;
        k = i*i;
        visited = new boolean[n];
        while(k<=n){
            k = i*i;
            res.add(k);
            i++;
        }
        min = 0;
        // System.out.println(res);
        visited[0] = true;
        int len = res.size();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while(queue.size()>0){
            min++;
            int level = queue.size();
            for(int j=0;j<level;j++){
                int node = queue.poll();
                for(i=0;i<len;i++){
                    int temp = res.get(i);
                    if(temp+node==n){
                        return min;
                    }
                    else if(temp+node>n)
                        break;
                    else if(temp+node<n && !visited[temp+node]){
                        visited[temp+node] = true;
                        queue.offer(temp+node);
                    }
                }
            }
            
        }
        
        return min;
    }
}