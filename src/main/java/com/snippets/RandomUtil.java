package com.snippets;

import java.util.Random;

public class RandomUtil {

    public RandomUtil(Random rand) {
        RandomUtil.rand = rand;
    }

    private static Random rand = new Random();

    public static float randFloat(float min, float max) {

        return rand.nextFloat() * (max - min) + min;

    }
    public static void main(String[] args) {
        System.out.println(randFloat(1,10));
    }
}
