class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int it : arr){
            freqMap.put(it, freqMap.getOrDefault(it, 0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> hm : freqMap.entrySet()){
            int val = hm.getValue();
            if(set.contains(val)){
                return false;
            }else{
                set.add(val);    
            }
        }
        return true;
    }
}