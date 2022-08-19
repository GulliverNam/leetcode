class Solution {
    int answer = Integer.MAX_VALUE;
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        if(length == h){
            int max = 0;
            for(int p : piles){
                max = Math.max(max, p);
            }
            answer = max;
        } else if(length == 1){
            answer = (int)Math.ceil(piles[0] / (h*1.0));
        } else {
            binarySearch(1, Integer.MAX_VALUE-1, h, piles);
        }
        return answer;
    }
    
    private void binarySearch(int start, int end, int target, int[] piles){
        if(start == end){
            return;
        }
        int mid = (start + end) / 2;
        int sum = 0;
        for(int p : piles){
            sum += (int)Math.ceil(p/(mid*1.0));
        }
        if(sum <= target){
            answer = Math.min(answer, mid);
            if(mid != end){
                binarySearch(start, mid, target, piles);
            }
        } else {
            if(start != mid){
                binarySearch(mid, end, target, piles);   
            }
        }
    }
}