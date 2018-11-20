package com.leetcode;

import java.util.Arrays;

/**
 * If the heaviest person can share a boat with the lightest person, then do so.
 * Otherwise, the heaviest person can't pair with anyone, so they get their own boat.
 * The reason this works is because if the lightest person can pair with anyone,
 * they might as well pair with the heaviest person.
 */

public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int numPeople = people.length;
        int j = 0, boats = 0;
        for (int i = numPeople - 1; i >= 0; i--) {
            if (i < j) break;
            if (i != j && people[i] + people[j] <= limit) {
                j++;
            }
            boats++;
        }
        return boats;
    }
}
