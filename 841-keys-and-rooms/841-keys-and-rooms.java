class Solution {
    boolean[] unlockRooms;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size();
        unlockRooms = new boolean[length];
        unlock(0, rooms);
        
        for(boolean b : unlockRooms){
            if(!b){
                return false;
            }
        }
        return true;
    }
    
    private void unlock(int idx, List<List<Integer>> rooms){
        unlockRooms[idx] = true;
        for(int key : rooms.get(idx)){
            if(!unlockRooms[key]){
                unlock(key, rooms);
            }
        }
    }
}