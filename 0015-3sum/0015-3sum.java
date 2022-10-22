class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        int length = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<length-2; i++){
            int j = i+1;
            int k = length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    answer.add(list);
                    j++;
                    k--;
                } else if(sum > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>> (answer);
    }
}