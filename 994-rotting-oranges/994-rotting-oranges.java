class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int answer = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int numOfFresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j, 0});
                } else if(grid[i][j] == 1){
                    numOfFresh++;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            answer = Math.max(answer, now[2]);
            for(int d=0; d<4; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr > -1 && nc > -1 && nr < m && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    numOfFresh--;
                    queue.offer(new int[] {nr,nc,now[2]+1});
                }
            }
        }
        if(numOfFresh != 0){
            return -1;
        }
        return answer;
    }
}