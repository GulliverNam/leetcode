class Solution {
    int[] answer = {-1, -1};
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length > 0){
            binarySearch(nums, target, 0, nums.length);        
        }
        return answer;
    }
    
    private void binarySearch(int[] nums, int target, int start, int end){
        if(start == end){
            return;
        }
        int mid = (start + end) / 2;
        
        if(nums[mid] > target){
            if(mid != end){
                binarySearch(nums, target, start, mid);                        
            }
        } else if(nums[mid] < target){
            if(mid != start){
                binarySearch(nums, target, mid, end);                        
            }
        } else {
            if(answer[0] == -1){
                answer[0] = answer[1] = mid;
            } else {
                answer[0] = Math.min(mid, answer[0]);
                answer[1] = Math.max(mid, answer[1]);
            }
            if(mid != end){
                binarySearch(nums, target, start, mid);            
            }
            if(mid != start){
                binarySearch(nums, target, mid, end);            
            }
        }
    }
}