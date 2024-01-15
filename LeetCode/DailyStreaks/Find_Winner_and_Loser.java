class Solution {
    private static void findLoserCount(HashMap<Integer, Integer> map, int[][] matches){
        // find the loser count
        for(int it[] : matches){
            int u = it[0];
            int v = it[1];
            map.put(v, map.getOrDefault(v,0)+1);
        }
    }

    private static void findWinnerAndLoser(HashMap<Integer, Integer> map, int[][] matches, List<Integer> loser, List<Integer> winner){
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
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        // TC -> O(n + nlogn), SC -> O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        findLoserCount(map, matches)
        findWinnerAndLoser(map, matches, loser, winner)
        result.add(winner);
        result.add(loser);
        Collections.sort(winner); // sort it
        Collections.sort(loser); // sort it
        return result;
    }
}