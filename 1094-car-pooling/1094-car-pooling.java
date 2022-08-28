class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] peopleInCar = new int[1001];
        for(int[] trip : trips){
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];
            for(int i=from; i<to; i++){
                peopleInCar[i] += people;
                if(peopleInCar[i] > capacity){
                    return false;
                }
            }
        }
        return true;
    }
}