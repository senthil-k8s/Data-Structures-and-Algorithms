import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private ArrayList<Integer> values;
    private HashMap<Integer, Integer> indexMap;
    private Random random;

    public RandomizedSet() {
        values = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        values.add(val);
        indexMap.put(val, values.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int indexToRemove = indexMap.get(val);
        int lastValue = values.get(values.size() - 1);

        values.set(indexToRemove, lastValue);
        indexMap.put(lastValue, indexToRemove);

        values.remove(values.size() - 1);
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
