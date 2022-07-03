package Topics.Graphs.DSU;

import java.util.*;


public class ContainVirus {
    class Solution {
        public int containVirus(int[][] grid) {
            int rst = 0;
            int s = solve(grid);
            while (s != 0) {
                rst += s;
                s = solve(grid);
            }
            return rst;
        }
    
        private int solve(int[][] g) {
            int r = g.length;
            int c = g[0].length;
            int[] uf = new int[getIdx(g, r - 1, c - 1) + 1];
            initUF(uf);
            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            // First mark connected components into same group.
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    if (g[i][j] <= 0) {
                        continue;
                    }
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= 0 && x < r && y >= 0 && y < c && g[x][y] > 0) {
                            union(uf, getIdx(g, x, y), getIdx(g, i, j));
                        }
                    }
                }
            }
            // blankSets, key is group index, value set contains all adjacent 0s.
            Map<Integer, Set<Integer>> blankSets = new HashMap<>();
            // wallCounts, key is group index, value is count of walls to build.
            Map<Integer, Integer> wallCounts = new HashMap<>();
            // And then iterate graph, count adjacent 0s and walls to build.
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    if (g[i][j] <= 0) {
                        continue;
                    }
                    int idx = find(uf, getIdx(g, i, j));
                    if (!blankSets.containsKey(idx)) {
                        blankSets.put(idx, new HashSet<>());
                    }
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= 0 && x < r && y >= 0 && y < c && g[x][y] == 0) {
                            int blankIdx = getIdx(g, x, y);
                            blankSets.get(idx).add(blankIdx);
                            wallCounts.put(idx, wallCounts.getOrDefault(idx, 0) + 1);
                        }
                    }
                }
            }
            // And then find the connected component with max adjacent 0s.
            int maxIdx = 0;
            int maxSize = 0;
            int walls = 0;
            for (int idx : blankSets.keySet()) {
                Set<Integer> s = blankSets.get(idx);
                if (s.size() > maxSize) {
                    maxSize = s.size();
                    maxIdx = idx;
                    walls = wallCounts.get(idx);
                }
            }
            if (maxSize == 0) {
                return 0;
            }
            // And finally, update the graph in-place, mark contained virus to be -1,
            // and spread other virus to adjacent 0s.
            int[][] tmp = cp(g);
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    if (tmp[i][j] <= 0) {
                        continue;
                    }
                    int idx = find(uf, getIdx(g, i, j));
                    if (idx == maxIdx) {
                        g[i][j] = -1;
                        continue;
                    }
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= 0 && x < r && y >= 0 && y < c && tmp[x][y] == 0) {
                            g[x][y] = 1;
                        }
                    }
                }
            }
            return walls;
        }
    
        // 2d to 1d index mapping.
        private int getIdx(int[][] g, int x, int y) {
            return g[0].length * x + y;
        }
    
        // methods for union find set.
        private void initUF(int[] uf) {
            for (int i = 0; i < uf.length; ++i) {
                uf[i] = i;
            }
        }
    
        private int find(int[] uf, int a) {
            if (uf[a] == a) {
                return a;
            }
            int r = find(uf, uf[a]);
            uf[a] = r;
            return r;
        }
    
        private void union(int[] uf, int a, int b) {
            int ga = find(uf, a);
            int gb = find(uf, b);
            uf[gb] = ga;
        }
    
        private int[][] cp(int[][] g) {
            int[][] r = new int[g.length][g[0].length];
            for (int i = 0; i < g.length; ++i) {
                for (int j = 0; j < g[0].length; ++j) {
                    r[i][j] = g[i][j];
                }
            }
            return r;
        }
    }
    
    public static void main(String[] args) {
        ContainVirus cVirus = new ContainVirus();
        Solution s = cVirus.new Solution();
        int ans = s.containVirus(new int[][] { { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 } });
        System.out.println(ans);
    }
}
