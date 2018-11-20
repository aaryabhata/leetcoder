package com.leetcode;

import java.util.Random;

public class GetRandom {
    public static int getRandomOdd(int[] arr) {
        //int randomElementIndex
        //  = ThreadLocalRandom.current().nextInt(listSize) % givenList.size();
        while (true) {
            int ran = new Random().nextInt(arr.length);
            if (arr[ran] % 2 != 0) {
                return arr[ran];
            }
        }
    }
}

