package com.skipper.service.learn.leetcode;

import java.util.Arrays;

/**
 * 506
 *
 * 给出一个长度为N的运动员得分数组，求每个运动员对应的名次。
 * 其中1,2,3的表达为”Gold Medal”, “Silver Medal”, “Bronze Medal”
 * Created by shoujian on 2017/7/17.
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
//        Integer[] index = new Integer[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            index[i] = i;
//        }
//        Arrays.sort(index, (a, b) -> (nums[a] - nums[b]));
//        String[] strings = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            switch (i) {
//                case 0:
//                    strings[i] = "Gold Medal";
//                    break;
//                case 1:
//                    strings[i] = "Silver Medal";
//                    break;
//                case 2:
//                    strings[i] = "Bronze Medal";
//                    break;
//                default:
//                    strings[i] = nums[i] + "";
//            }
//        }
//        return strings;

        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        int[] nums = {1, 2, 3, 4};
        String[] strings = relativeRanks.findRelativeRanks(nums);
        for (String str : strings) {

            System.out.println(str);
        }
    }

}
