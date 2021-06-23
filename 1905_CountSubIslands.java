//LeetCode 1905 Count SubIslands
class Solution {
    
    boolean [][]visited ;
    int [] rowItr = new int[]{1,-1,0,0};
    int [] colItr = new int[]{0,0,-1,1};
    
    public boolean isValid(int row,int col, int grid[][]){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length)
            return true;
        return false; 
    }
    
    public boolean dfs(int [][] grid1,int [][] grid2, int i,int j){
        //iterating over all possible 4 neighbours 
        // System.out.println(i+" "+j);
        boolean flag = true;
        for(int k = 0;k<4;k++){
            int row = i+rowItr[k], col = j+colItr[k];
            if(isValid(row,col,grid2) && !visited[row][col] && grid2[row][col]==1){
                visited[row][col] = true;
                if(grid1[row][col] != 1)
                    flag = false;
                if(!dfs(grid1,grid2,row,col))
                    flag = false;
            }
        }
        return flag;
        
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        if(n==0)
            return 0;
        int m = grid1[0].length;
        visited = new boolean[n][m];
        
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid2[i][j]==1 && grid1[i][j]==1){
                    visited[i][j] = true;
                    if(dfs(grid1,grid2,i,j)){
                        // System.out.println("True For"+i+" "+j);
                        res++;
                    }
                    
                }
        }}
        return res;
    }
}