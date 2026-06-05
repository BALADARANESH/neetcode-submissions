class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
        return res;
        Arrays.sort(nums);
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],i);
        }
        Set<String>used=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int cs=nums[i]+nums[j];
                if(map.containsKey(-1*cs))
            {
                int k=map.get(-1*cs);
                if(!used.contains(nums[i]+":"+nums[j]+":"+nums[k])&&k>i&&k>j)
                {
                res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    used.add(nums[i]+":"+nums[j]+":"+nums[k]);}
            }
            }
        }
        return res;

    }
}
