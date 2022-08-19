class Solution {
    public int maxProduct(int[] nums) {
        int answer = -11;
        for(int n : nums){
            answer = Math.max(answer, n);
        }
        int length = nums.length;
        if(length == 1){
            return answer;
        }
        
        Map<Integer, int[]> division = new HashMap<>();
        division.put(0, new int[]{-1,-1,0});
        int key = 0;
        for(int i=0; i<length; i++){
            if(nums[i] == 0){
                division.put(i+1, new int[]{-1,-1, 0});
                key = i+1;
            } else if(nums[i] < 0){
                if(division.get(key)[0] == -1){
                    division.get(key)[0] = i;
                } else {
                    division.get(key)[1] = i;
                }
                division.get(key)[2]++;
            }
        }
        
        for(int k : division.keySet()){
            int[] minus = division.get(k);
            // System.out.println(k+" "+minus[0]+","+minus[1]+" "+minus[2]);
            if(minus[0] == -1 && minus[1] == -1){
                boolean isStart = false;
                int product = 1;
                for(int i=k; i<length; i++){
                    if(nums[i] == 0){
                        break;
                    }
                    isStart = true;
                    product *= nums[i];
                }
                if(isStart){
                    answer = Math.max(answer, product);
                }
            } else if(minus[1] == -1){
                boolean isStart = false;
                int product = 1;
                for(int i=k; i<length; i++){
                    if(nums[i] <= 0){
                        if(isStart){
                            answer = Math.max(answer, product);
                        }
                        isStart = false;
                        product = 1;
                        if(nums[i] == 0){
                            break;
                        }
                    } else {
                        isStart = true;
                        product *= nums[i];
                    }
                }
                if(isStart){
                    answer = Math.max(answer, product);
                }
            } else {
                int count = minus[2];
                if(count % 2 == 0){
                    int product = 1;
                    for(int i=k; i<length; i++){
                        if(nums[i] == 0){
                            break;
                        }
                        product *= nums[i];
                    }
                    answer = Math.max(answer, product);
                } else {
                    int product = 1;
                    for(int i=k;i<minus[1]; i++){
                        product *= nums[i];
                    }
                    answer = Math.max(answer, product);
                    product = 1;
                    for(int i=minus[0]+1; i<length; i++){
                        if(nums[i] == 0){
                            break;
                        }
                        product*=nums[i];
                    }
                    answer = Math.max(answer, product);
                }
            }
        }
        
        
        return answer;
    }
}