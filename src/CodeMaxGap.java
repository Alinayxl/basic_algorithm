package src;
/**
 * 时间复杂度 O(n)
 * 首先就是排序，我们可以选择复杂度较低的算法
 * 这里使用类似桶排序的思想，我们不是以元素的值来计算桶的数目，
 * 而是元素个数来划分桶，即使桶的个数比元素个数多1，
 * 最大和最小的元素之间等差值的放置桶，将元素依次放入各桶之间，
 * 由于桶比元素多1，必定有一个以上的桶是空的,
 * 而最大的差值，必定处于空桶左右，只需记录每个桶里面的最大值和最小值即可，
 * 最大差值即为后一个桶的最小值-前一个桶的最大值（以空桶为基准）
 * 
 * */

import java.util.Arrays;

public class CodeMaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min == max) {
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bucketId = 0;
        for (int i = 0; i < len; i++) {
            bucketId = getBucketId(nums[i], len, min, max);
            mins[bucketId] = hasNum[bucketId] ? Math.min(mins[bucketId], nums[i]) : nums[i];
            maxs[bucketId] = hasNum[bucketId] ? Math.max(mins[bucketId], nums[i]) : nums[i];
            hasNum[bucketId] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int getBucketId(int num, int len, int min, int max) {
        return ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 50;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }


        System.out.println(succeed ? "Bingo!!" : "Sorry");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxGap(arr));
        int[] myArr = {1, 9, 4, 6, 21, -3, 20};
        System.out.println(Arrays.toString(myArr));
        System.out.println(maxGap(myArr));
    }

    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
           gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return  arr;
    }
}

