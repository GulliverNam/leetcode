class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        int length = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for(int i=0; i<length-2; i++){
            int j = i+1;
            int k = length-1;
            while(j < k){
                // System.out.println(i+" "+j+" "+k);
                int sum = nums[j] + nums[k];
                if(sum + nums[i] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    answer.add(list);
                    j++;
                    k--;
                } else if(sum + nums[i] > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>> (answer);
    }
}