package com.skipper.service.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * Created by shoujian on 2017/7/17.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            Integer sum = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (sum + i < target) {

                }
            }
        }

        return result;
    }

}
