
class Pair{
   int first;
   int second;
   public Pair(int first,int second){
      this.first = first;
      this.second = second;
   }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;  
        int vis[][] = new int[n][m];
        int countOfIsland =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){  
                    countOfIsland++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return countOfIsland;
    }

    public static void bfs(int row,int col,char grid[][],int vis[][]){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();
            for(int drow=-1;drow<=1;drow++){
                for(int dcol=-1;dcol<=1;dcol++){
                    int newRow = r+drow;
                    int newCol = c+dcol;
                    if(Math.abs(drow-dcol) == 1 && (newRow >= 0 && newRow < n) && (newCol >= 0 && newCol < m) && grid[newRow][newCol] == '1' && vis[newRow][newCol] == 0){
                         vis[newRow][newCol] = 1;
                        q.add(new Pair(newRow,newCol));
                    } 
                }
            }
        }
    }
}
