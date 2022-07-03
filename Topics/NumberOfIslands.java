package Topics;

public class NumberOfIslands {

    private static final int[] directionX = {-1, 0, 1, 0};
    private static final int[] directionY = {0, 1, 0, -1};
    public static void dfs(int[][] grid, int[][] visited, int x, int y){
        visited[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            x = x + directionX[k];
            y = y + directionY[k];
            if(x < grid.length && x > 0 && y < grid[0].length && y > 0 && grid[x][y] == 1){
                if(visited[x][y] != 0) {
                    dfs(grid, visited, x, y);
                }
            }

        }

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] grid = new int[n][m];

        int[][] visited = new int[n][m];

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] != 0){
                    dfs(grid, visited, i, j);
                    counter++;
                }
            }
        }
        


    }
}
