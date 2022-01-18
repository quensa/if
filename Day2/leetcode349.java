import java.util.ArrayList;
import java.util.HashSet;

public class leetcode349 {


    //给定两个数组，编写一个函数来计算它们的交集。
    // 思路：要求交集，那就是找相同元素，相同元素且不能重复就用set---
    // 定义交集的集合，先把第一个数组放进set集合然后遍历第二个数组如果有相同的就放进新集合中但是要删除多余的一个，最后遍历交集集合
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            int len1 = nums1.length;
            int len2 = nums2.length;
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < len1; i++) {
                set.add(nums1[i]);
            }
            int count = 0;

            for (int i = 0; i < len2; i++) {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                    set.remove(nums2[i]);
                }
            }
            int size = list.size();
            int[] a = new int[size];
            for (int i = 0; i < size; i++) {
                a[i] = list.get(i);
            }
            return a;
        }
    }
}
