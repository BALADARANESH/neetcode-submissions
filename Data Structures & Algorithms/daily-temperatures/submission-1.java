class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> hs=new Stack<>();
        int n=temperatures.length;
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!hs.isEmpty()&& temperatures[i]>=temperatures[hs.peek()])
            {
                hs.pop();
            }
            if(!hs.isEmpty())
            {
                res[i]=hs.peek()-i;
            }
            hs.push(i);
        }
        return res;
    }
}
