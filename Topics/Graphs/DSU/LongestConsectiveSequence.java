package Topics.Graphs.DSU;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestConsectiveSequence
 */
public class LongestConsectiveSequence {

    class DSU{
        private int[] parent;
        private int[] size;
        private int n;
        private int maxComponentSize = 0;
        public DSU(int s){
            parent = new int[s];
            size = new int[s];
            n = s;
        }

        public void makeSet(){
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public void union(int a, int b){
            a = findParent(a);
            b = findParent(b);

            if (a == b) {
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

        public int getLargetComponentSize() {
            int maxSize = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i && size[i] > maxSize) {
                    maxSize = size[i];
                }
            }
            
            return maxSize;
        }
    }

    public int longestConsectiveSequence(int [] nums){
        DSU d = new DSU(nums.length);
        Map<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valToIndex.containsKey(nums[i])) {
                continue;                
            }

            if (valToIndex.containsKey(nums[i] - 1)) {
                d.union(i, valToIndex.get(nums[i] - 1));
            }
            
            if (valToIndex.containsKey(nums[i] + 1)) {
                d.union(i, valToIndex.get(nums[i] + 1));
            }

            valToIndex.put(nums[i], i);
        }

        return d.getLargetComponentSize();
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsectiveSequence l = new LongestConsectiveSequence();
        int ans = l.longestConsectiveSequence(nums);
        System.out.println(ans);
    }
}