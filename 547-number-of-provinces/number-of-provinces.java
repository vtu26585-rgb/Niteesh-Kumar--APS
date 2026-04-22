class Solution {
    public void dfs(List<List<Integer>> adj, Integer[] vis, int node) {
        vis[node] = 1;

        for(int i=0; i<adj.get(node).size(); i++) {
            int ngbr = adj.get(node).get(i);

            if(vis[ngbr] == null) {
                vis[ngbr] = 1;
                
                dfs(adj, vis, ngbr);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // create adjacency list
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        // fill adjacency list
        for(int u=0; u<n; u++) {
            for(int v=0; v<n; v++) {
                if(isConnected[u][v]==1 && u!=v) {
                    int n1 = u+1;
                    int n2 = v+1;

                    adj.get(n1).add(n2);
                    adj.get(n2).add(n1);
                }
            }
        }

        int cnt = 0;
        Integer[] vis = new Integer[n+1];
        for(int i=1; i<=n; i++) {
            if(vis[i] == null) {
                cnt++;
                dfs(adj, vis, i);
            }
        }

        return cnt;
    }
}