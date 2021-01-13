package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class RandomizedSet {

    /**
     * @description RandomizedSet 를 구현하는 문제, 평균 O(1) 의 time complexity 를 갖는 insert, remove, random 함수를 구현하라
     * 1. HashMap 에 key 는 입력받는 수, value 는 내부 LinkedList 의 index 를 갖는다.
     * 2. LinkedList 에 insert 될 때마다 값을 push 하고 remove 할 때 마다, remove 한다.
     * (linkedList 를 내부적으로 갖는 이유는 해당 인덱스만큼 랜덤함수를 돌려 해당 인덱스의 값을 랜덤으로 돌려주기 위함)
     * 3. Random 함수에서 linkedList 의 사이즈 만큼 랜덤값을 생성하여 해당 인덱스의 LinkedList 값을 반환한다.
     */

    private LinkedList<Integer> values;
    private HashMap<Integer, Integer> hashMap;

    public RandomizedSet() {
        values = new LinkedList<>();
        hashMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        Integer index = hashMap.get(val);
        if (index == null) {
            hashMap.put(val, val);
            values.push(val);

            return true;
        }

        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer index = hashMap.get(val);
        if (index == null) {
            return false;
        }

        values.remove(index);
        hashMap.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int randomValue = random.nextInt(values.size());

        return values.get(randomValue);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number
    }
}
