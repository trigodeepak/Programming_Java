//LeetCode 207 Course Schedule (Union Find) Detect cycle/Deadlock
class Solution {
    boolean visited[],recStack[];
    HashMap<Integer,List<Integer>> graph;
    public boolean isCyclic(int node){
        // System.out.println(node+" "+Arrays.toString(recStack));
        if(recStack[node])
            return true;
        visited[node] = true;
        recStack[node] = true;
        if(graph.containsKey(node))
        for(Integer neigh: graph.get(node)){
            if(recStack[neigh])
                return true;
            if(!visited[neigh] && isCyclic(neigh)){
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        graph = new HashMap();
        for(int[] edge:prerequisites){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(graph.containsKey(i) && !visited[i]){
                if(isCyclic(i))
                    return false;
            }
                
        }
        return true;
    }
}