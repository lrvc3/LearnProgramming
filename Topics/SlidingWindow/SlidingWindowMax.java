package Topics.SlidingWindow;
import java.util.*;

public class SlidingWindowMax {

    public static int[] solve(int[] nums, int k) {
        int i = 0;
        int j = 0;
        List<Integer> ansList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();    

        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) +  1);
            subList.add(nums[j]);

            if (j - i + 1 < k) {
                j++;
                continue;
            } else if (j - i + 1 == k) {
                int ll = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    ll = Math.max(ll, entry.getKey());
                }

                // int res = Collections.max(subList);
                ansList.add(ll);

                map.put(nums[i], map.get(nums[i]) - 1);
                // subList.remove(new Integer(nums[i]));

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return ansList.stream().mapToInt(e->e).toArray();
    }

    public static void main(String[] args) {
        int [] ans = solve(new int[]{1, 1}, 2);
        // int [] ans = solve(new int[]{10, 5, 2, 7, 8, 7}, 3);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
