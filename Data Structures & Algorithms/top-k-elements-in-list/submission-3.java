

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Reverse map: freq → list of numbers
        Map<Integer, List<Integer>> revC = new HashMap<>();

        for (int num : countMap.keySet()) {   // ✅ FIXED
            int count = countMap.get(num);

            if (!revC.containsKey(count)) {
                revC.put(count, new ArrayList<>());
            }

            revC.get(count).add(num);
        }

        int[] res = new int[k];
        int index = 0;

        // Traverse from high freq to low
        for (int pc = nums.length; pc >= 0; pc--) {

            if (!revC.containsKey(pc)) continue;   // ✅ FIXED

            for (int n : revC.get(pc)) {
                if (index < k) {                  // ✅ FIXED
                    res[index++] = n;
                } else {
                    break;
                }
            }

            if (index >= k) break;
        }

        return res;
    }
}