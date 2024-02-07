class Tuple{
    char key;
    int freq;
    Tuple(int _freq, char _key){
        this.freq = _freq;
        this.key = _key;
    }
}

class Solution {
    private static void addFreqInPq(HashMap<Character, Integer> map, PriorityQueue<Tuple> pq ){
        // TC -> O(n*(logN))
        // SC- > O(n)
        for(Map.Entry<Character, Integer> hm : map.entrySet()){
            char key = hm.getKey();
            int value = hm.getValue();
            pq.add(new Tuple(value, key));
        }
    }

    private static String sortByFrequency(PriorityQueue<Tuple> pq){
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()){
            Tuple temp = pq.poll();
            int freq = temp.freq;
            char ch = temp.key;
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String frequencySort(String s) {
        if(s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b) -> b.freq-a.freq);
        for(char currentChar : s.toCharArray()){
            map.put(currentChar, map.getOrDefault(currentChar, 0)+1);
        }
        addFreqInPq(map, pq);
        String result = sortByFrequency(pq);
        return result;
    }
}