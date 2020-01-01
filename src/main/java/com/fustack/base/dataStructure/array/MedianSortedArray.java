package com.fustack.base.dataStructure.array;

/**
 * Created by yaoagcn on 2019/7/11.
 */
public class MedianSortedArray {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

     你可以假设 nums1 和 nums2 不会同时为空。

     示例 1:

     nums1 = [1, 3]
     nums2 = [2]

     则中位数是 2.0
     示例 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     则中位数是 (2 + 3)/2 = 2.5

     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] maxNum = nums1;
        int maxLen = len1;
        if (len1 < len2) {
            maxNum = nums2;
            maxLen = len2;
        }

        int[] mergeArr = new int[len1 + len2];

        for (int i = 0; i < maxLen; i++) {

        }

        return 0.0;
    }
}
