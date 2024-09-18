package com.jaideep.dsalgo.array;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int i = 0;
        int j = 0;
        int sum = 0;
        final ArrayList<Integer> ans = new ArrayList<>();
        while (j < arr.length) {
            sum += arr[j];
            if (sum > s) {
                while (sum > s && i < j) {
                    sum -= arr[i++];
                }
            }
            if (sum == s) {
                break;
            }
            j++;
        }
        if (sum == s) {
            ans.add(i + 1);
            ans.add(j + 1);
        } else {
            ans.add(-1);
        }
        return ans;
    }
}
