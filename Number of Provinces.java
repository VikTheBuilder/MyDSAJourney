
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean vis[] = new boolean[v];
        int res=0;
        for(int i=0; i<v; i++){
            vis[i] =false;
        }
        for(int i=0; i<v; i++){
            if(vis[i]==false){
                res++;
                dfs(i, vis, isConnected);
            } 
        }
        return res;
    }
    void dfs(int n, boolean vis[], int[][] isConnected){
        vis[n] =true;
        for(int i =0; i< vis.length; i++){
            if(isConnected[n][i]== 1){
                if(vis[i]== false) dfs(i, vis, isConnected);
            }
        }
    }
}
