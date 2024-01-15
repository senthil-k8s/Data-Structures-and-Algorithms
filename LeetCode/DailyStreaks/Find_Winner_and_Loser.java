class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // TC -> O(n + nlogn), SC -> O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        // find the loser count

        for(int it[] : matches){
            int u = it[0];
            int v = it[1];
            map.put(v, map.getOrDefault(v,0)+1);
        }
        List<Integer> loser = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();

        // logics to find winner and loser
        for(int it[] : matches){
            int u = it[0];
            int key = it[1];
            if(map.get(key) == 1) loser.add(key);
            if(!map.containsKey(u)){
                map.put(u,0); // to avoid dupliactes 
                winner.add(u);
            }
        }
        result.add(winner);
        result.add(loser);
        Collections.sort(winner); // sort it
        Collections.sort(loser); // sort it
        return result;
    }
}