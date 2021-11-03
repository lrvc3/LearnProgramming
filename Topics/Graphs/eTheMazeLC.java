/*
    Problem Link: https://www.lintcode.com/problem/787/
    Topic: Graphs - BFS
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
*/

import java.io.*;
import java.util.*;

public class eTheMazeLC {

	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            for (int direction = 0; direction < 4; direction++) {
                int nx = cur[0], ny = cur[1];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                }
                nx -= dx[direction];
                ny -= dy[direction];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }



	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    
		}
		
	}
}