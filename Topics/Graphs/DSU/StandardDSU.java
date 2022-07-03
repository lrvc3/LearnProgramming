package Topics.Graphs.DSU;




public class StandardDSU {
    class DSU{

        private int[] parent;
        private int[] size;
        private int n;
        public DSU(int s){
            n = s;
            parent = new int[n];
            size = new int[n];
        }
    
        public void makeSet(){
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
    
        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            // Path compression - O(log n) [Height of the tree]
            return parent[node] = findParent(parent[node]);
        }
    
        public void unionSet(int a, int b){
            a = findParent(a);
            b = findParent(b);
    
            if(a == b){
                return;
            }
            
            if(size[a] < size[b]){
                int temp = a;
                a = b;
                b = temp;
            }
    
            parent[b] = a;
            size[a] += size[b];
        }
    
        public int getNoOfComponents(){
            int ans = 0;
            for(int i = 0; i < n; i++){
                if(parent[i] == i){
                    ans++;
                }
            }
            return ans;
        }
    }

    public int solve(int[][] friends) {
        int n = friends.length;

        DSU d = new DSU(n);
        d.makeSet();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < friends[i].length; j++){
                d.unionSet(i, friends[i][j]);
            }
        }
        int res = d.getNoOfComponents();
        return res;
    }

    public static void main(String[] args) {
        int[][] friends = {{1}, {0, 2}, {1}, {4}, {3}, {}};
        /**
         * BinarySearch: https://binarysearch.com/problems/Friend-Groups
         * You are given an undirected graph friends as an adjacency list, 
         * where friends[i] is a list of people i is friends with. Friendships are two-way. 
         * Two people are in a friend group as long as there is some path of mutual friends connecting them.
         * Return the total number of friend groups.
         */
        StandardDSU sDsu = new StandardDSU();
        int friendGroups = sDsu.solve(friends);
        System.out.println(friendGroups);
    }
}
